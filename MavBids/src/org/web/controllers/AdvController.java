package org.web.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.web.beans.Image;
import org.web.dao.DBMgr;

@Controller
public class AdvController {

	final static Logger logger = Logger.getLogger(AdvController.class);

	@Autowired
	DBMgr dbMgr;

	@RequestMapping(value = "/uploadAdvImage", method = RequestMethod.POST)
	public @ResponseBody String uploadAdvImage(@RequestParam("file") MultipartFile file){

		if(!file.isEmpty()){
			logger.info("Content type : " + file.getContentType());
			byte[] imgData = null;
			try {
				imgData = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
				return "false";
			}

			if(imgData != null){
				Image img = new Image();
				img.setImage(imgData);

				dbMgr.saveImage(img);
			}
			return "true";
		} else
			return "false";
	}

	@RequestMapping(value = "/getAdvImage", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<byte[]> getAdvImage(@RequestParam("id") String id){
		int imageId = Integer.parseInt(id);

		Image img = dbMgr.getImage(imageId);

		if (img != null){
			HttpHeaders headers = new HttpHeaders();
			// TODO Save the content type during upload ?
	        headers.setContentType(MediaType.IMAGE_JPEG);
	        headers.setContentLength(img.getImage().length);
	        return new HttpEntity<byte[]>(img.getImage(), headers);
		} else {
			//TODO How about sending some default image ?
			return null;
		}
	}
}
