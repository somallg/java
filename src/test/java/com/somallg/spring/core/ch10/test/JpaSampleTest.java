package com.somallg.spring.core.ch10.test;

import com.somallg.spring.core.ch10.domain.Contact;
import com.somallg.spring.core.ch10.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ch10/app-context.xml")
public class JpaSampleTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Qualifier("jpaContactService")
    @Resource
    private ContactService contactService;

    @Test
    public void testFindAll() throws Exception {
        List<Contact> list = contactService.findAll();

        for (Contact c : list) {
            System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getBirthDate());
        }
    }
}
