package com.somallg.spring.core.ch8.test;

import com.somallg.spring.core.ch8.dao.ContactDao;
import com.somallg.spring.core.ch8.domain.Contact;
import com.somallg.spring.core.ch8.domain.ContactTelDetail;
import com.somallg.spring.core.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(value = "classpath:ch8/spring-embedded-database.xml")
public class JdbcContactDaoTest extends SpringTest {

    @Autowired
    private ContactDao contactDao;

    @Test
    public void testJdbcContactDao() {

        assertEquals("Lala", contactDao.findFirstNameById(1L));
        assertEquals("Lili", contactDao.findFirstNameById(2L));
        assertEquals("Lolo", contactDao.findFirstNameById(3L));

        List<Contact> contactsWithDetail = contactDao.findAllWithDetail();
        assertEquals(3, contactsWithDetail.size());
        Contact lala = contactsWithDetail.get(0);
        assertEquals("Lala", lala.getFirstName());
        assertEquals("1991-07-30", lala.getBirthDate().toString());

        List<ContactTelDetail> telDetails = lala.getContactTelDetails();
        assertEquals(2, telDetails.size());
    }

}