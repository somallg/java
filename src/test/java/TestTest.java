package java;

import static org.junit.Assert.*;

public class TestTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetMessage() throws Exception {
        assertEquals("Hello Lala", new Test().getMessage());
    }
}