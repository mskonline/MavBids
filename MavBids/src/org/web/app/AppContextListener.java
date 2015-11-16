package org.web.app;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class AppContextListener implements ServletContextListener  {

	final static Logger logger = Logger.getLogger(AppContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("MavBids Context Loaded");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                logger.info("Deregistering driver : " + driver.toString());
            } catch (SQLException e) {
            	logger.error("Error in deregistering driver : " + driver.toString() + " " + e.getMessage());
            }
        }

       /* try {
        	logger.info("Performing MySQL cleanup...");
            AbandonedConnectionCleanupThread.shutdown();
        }
        catch (InterruptedException e) {
            logger.error("SEVERE problem cleaning up: " + e.getMessage());
            e.printStackTrace();
            return;
        }*/

        logger.info("MavBids Cleanup completed.");
	}
}
