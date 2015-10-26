package com.somallg.jax.rs.json.resource;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.somallg.jax.rs.json.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jax-rs-json-spring.xml")
public class EJBResourceTest {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void testGetPerson() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<Person> response = restTemplate.exchange("http://localhost:8080/jax-rs-json/rest/person", HttpMethod.GET, entity, Person.class);

        assertEquals(200, response.getStatusCode().value());

        Person person = response.getBody();
        System.out.println(person);

        assertEquals("Lala", person.getName());
        assertEquals(23, person.getAge());
    }

    @Test
    public void testGetList() throws Exception {

    }

    @Test
    public void testGetListString() throws Exception {

    }

    @Test
    public void testPostPerson() throws Exception {
        Person p = new Person();
        p.setName("TanhLam");
        p.setAge(23);

        restTemplate.postForObject("http://localhost:8080/jax-rs-json/rest/post", p, Person.class);
    }
}