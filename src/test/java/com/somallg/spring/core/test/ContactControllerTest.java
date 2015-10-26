package com.somallg.spring.core.test;

import com.somallg.spring.core.ch13.service.ContactService;
import com.somallg.spring.core.ch9.domain.Contact;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by somallg on 11/9/14.
 */
public class ContactControllerTest extends AbstractTest {

    private final List<Contact> contacts = new ArrayList<Contact>();

    private ContactService contactService;

    @Before
    public void initContacts() {
        Contact c = new Contact();

        c.setId(1L);
        c.setFirstName("Hello");
        c.setLastName("Lala");

        contacts.add(c);
    }

    @Test
    public void testList() throws Exception {
        contactService = Mockito.mock(ContactService.class);
        Mockito.when(contactService.findAll()).thenReturn(contacts);

        ContactController contactController = new ContactController();

        ReflectionTestUtils.setField(contactController, "contactService", contactService);

        ExtendedModelMap uiModel = new ExtendedModelMap();

        String result = contactController.list(uiModel);

        Assert.assertNotNull(result);
        Assert.assertEquals(result, "contacts/lists");

        @SuppressWarnings("unchecked")
		List<Contact> modelContacts = (List<Contact>) uiModel.get("contacts");

        Assert.assertEquals(1, modelContacts.size());
    }
}
