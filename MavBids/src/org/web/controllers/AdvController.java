package org.web.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
			byte[] imgData = null;
			try {
				imgData = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
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

	@RequestMapping(value = "/getAdvImage", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getAdvImage(@RequestParam("id") String id){
		Image img = new Image();
		img.setImageId(Integer.parseInt(id));
		return dbMgr.getImage(img);
	}
}
