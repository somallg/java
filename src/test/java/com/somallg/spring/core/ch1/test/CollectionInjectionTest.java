package com.somallg.spring.core.ch1.test;

import com.somallg.spring.core.ch1.CollectionInjection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CollectionInjectionTest extends SpringTestCh1 {

    @Autowired
    private CollectionInjection bean;

    @Test
    public void testInjection() {

        Map<String, Object> map = bean.getMap();
        assertEquals("Hello Lala", map.get("key1"));
        assertEquals("Hello LBL", map.get("key2"));

        Properties properties = bean.getProps();
        assertEquals(2, properties.size());
        assertEquals("Lala", properties.get("prop1"));
        assertEquals("LBL", properties.get("prop2"));

        Set set = bean.getSet();
        assertEquals(2, set.size());
        String[] array = (String[]) set.toArray(new String[set.size()]);
        assertEquals("Lala", array[0]);
        assertEquals("LBL", array[1]);

        List list = bean.getList();
        assertNull(list);

        System.out.println(bean);
    }
}