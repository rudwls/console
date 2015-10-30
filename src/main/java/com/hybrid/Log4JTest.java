package com.hybrid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JTest {

	static Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		log.info("Hello Log4J2");

		for (int i = 0; i < 10; i++) {
			log.info("index = " + i);
		}

	}

}
