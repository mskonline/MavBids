package org.web.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.web.beans.Category;
import org.web.beans.Image;
import org.web.beans.UserProfile;

@Component
public class DBMgr {

	final static Logger logger = Logger.getLogger(DBMgr.class);
	private static SessionFactory factory;

	public DBMgr() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserProfile> listUserProfiles() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<UserProfile> userProfiles = null;

		try {
			tx = session.beginTransaction();
			userProfiles = session.createQuery("FROM UserProfile").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Failed to execute Hibernate transaction : " + e);
		} finally {
			session.close();
		}

		return userProfiles;
	}


	public String addCategory(Category c){
		return null;
	}

	public String removeCategory(Category c){
		return null;
	}

	public boolean saveImage(Image img){

		Transaction tx = null;
		Session session = factory.openSession();
		tx = session.beginTransaction();

		session.save(img);
		tx.commit();

		session.close();
		return true;
	}

	public Image getImage(int imageId){
		Session session = factory.openSession();

		Image image = (Image) session.get(Image.class, imageId);

		session.close();
		return image;
	}
}
