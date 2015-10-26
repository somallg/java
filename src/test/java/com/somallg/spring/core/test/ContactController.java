package com.somallg.spring.core.test;

import com.somallg.spring.core.ch13.service.ContactService;
import com.somallg.spring.core.ch9.domain.Contact;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by somallg on 11/9/14.
 */
public class ContactController {

    private ContactService contactService;

    public String list(ModelMap modelMap) {
        List<Contact> contacts = contactService.findAll();
        modelMap.put("contacts", contacts);

        return "contacts/lists";
    }
}
