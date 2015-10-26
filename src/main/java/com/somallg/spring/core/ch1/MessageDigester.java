package com.somallg.spring.core.ch1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.security.MessageDigest;

public class MessageDigester {

    @Autowired
    @Qualifier(value = "shaDigest")
    private MessageDigest shaDigest;

    @Autowired
    @Qualifier(value = "md5Digest")
    private MessageDigest md5Digest;

    public MessageDigest getShaDigest() {
        return shaDigest;
    }

    public void setShaDigest(MessageDigest shaDigest) {
        this.shaDigest = shaDigest;
    }

    public MessageDigest getMd5Digest() {
        return md5Digest;
    }

    public void setMd5Digest(MessageDigest md5Digest) {
        this.md5Digest = md5Digest;
    }

    public String digest(String msg, MessageDigest digest) {
        System.out.println("Using algorithm " + digest.getAlgorithm());
        digest.reset();

        byte[] input = msg.getBytes();
        byte[] out = digest.digest(input);

        StringBuilder sb = new StringBuilder();

        for (byte b : out) {
            sb.append("0123456789ABCDEF".charAt((b & 0xF0) >> 4));
            sb.append("0123456789ABCDEF".charAt((b & 0x0F)));
        }

        return sb.toString();
    }
}
