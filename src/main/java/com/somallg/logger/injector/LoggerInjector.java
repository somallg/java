package java.com.somallg.logger.injector;

import com.somallg.logger.injector.annotation.InjectLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by somallg on 12/4/2014.
 */
public class LoggerInjector implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                // make field accessible if private
                ReflectionUtils.makeAccessible(field);

                // check for @InjectLogger
                if (field.getAnnotation(InjectLogger.class) != null) {
                    Logger logger = LoggerFactory.getLogger(bean.getClass());
                    // set logger to bean
                    field.set(bean, logger);
                }
            }
        });

        return bean;
    }
}
