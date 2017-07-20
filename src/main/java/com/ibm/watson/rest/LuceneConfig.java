package com.ibm.watson.rest;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibm.watson.QueryLucene;
import com.ibm.watson.SemanticType;

@WebListener
public class LuceneConfig implements ServletContextListener {
	
	private static Log log = LogFactory.getLog(LuceneConfig.class);
	private QueryLucene queryLucene;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.info("Shutting lucene...");
		queryLucene.finish();
		log.info("Done");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("Initializing lucene....");
		log.info("Lucene DIR: " + System.getenv("LUCENE_DIR_NEW"));
		try {
			queryLucene = new QueryLucene(System.getenv("LUCENE_DIR_NEW"));
			event.getServletContext().setAttribute("lucene", queryLucene);
		} catch (IOException e) {
			log.error("Unable to read Lucene index: " + e);
			throw new RuntimeException();
		}
		log.info("Done");
	}

}