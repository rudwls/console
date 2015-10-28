package console;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLogTest {

	static Log log = LogFactory.getLog(CommonsLogTest.class);

	public static void main(String[] args) {

		log.info("Hello Commons Logging");

		for (int i = 0; i < 10; i++) {
			log.info("i = " + i);

		}
	}

}
