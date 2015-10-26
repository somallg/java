package java.com.somallg.logger.injector.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somallg.logger.injector.annotation.InjectLogger;

/**
 * Created by somallg on 12/14/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:logger-injector-test.xml")
public class LoggerInjectorTest {

    @InjectLogger
    private Logger logger;

    @Test
    public void testInjectLogger() throws Exception {
        assertNotNull(logger);

        logger.info("Logger injected");
    }
}
