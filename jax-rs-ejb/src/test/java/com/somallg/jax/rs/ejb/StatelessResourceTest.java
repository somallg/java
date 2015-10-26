package com.somallg.jax.rs.ejb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jax-rs-ejb-spring.xml")
public class StatelessResourceTest {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void testSayHello() throws Exception {

        String s = restTemplate.getForObject("http://localhost:8080/jax-rs-ejb/rest/hello", String.class);

        assertEquals("Hello World", s);
    }
}