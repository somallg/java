package com.somallg.spring.core.ch1.test;

import com.somallg.spring.core.ch1.MessageDigester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MessageDigesterTest extends SpringTestCh1 {

    @Autowired
    private MessageDigester digester;

    @Test
    public void testDigest() throws Exception {
        MessageDigest shaDigest = digester.getShaDigest();
        assertNotNull(shaDigest);
        assertTrue("2c9182ad3eb2ace9e43bfce5c45d39f8b5677acd".equalsIgnoreCase(digester.digest("Lala", shaDigest)));

        MessageDigest md5Digest = digester.getMd5Digest();
        assertNotNull(md5Digest);
        assertTrue("054d2267a8eee41bb9ad71964e5d209e".equalsIgnoreCase(digester.digest("Lala", md5Digest)));
    }
}