package com.somallg.javaws.ch02.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by somallg on 5/15/14.
 */
public class Marshal {
    private static final String file_name = "bd.mar";

    public static void main(String[] args) {
        new Marshal().run_example();
    }

    private void run_example() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Skier.class);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshal a Skier object:
            Skier skier = createSkier();
            m.marshal(skier, System.out);

            FileOutputStream out = new FileOutputStream(file_name);
            m.marshal(skier, out);
            out.close();

            // Unmarshal as proof of concept
            Unmarshaller u = ctx.createUnmarshaller();
            Skier bd_clone = (Skier) u.unmarshal(new File(file_name));
            System.out.println();
            m.marshal(bd_clone, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Skier createSkier() {
        Person bd = new Person("Bjoern", 41, "Male");
        List<String> list = new ArrayList<String>();
        list.add("12 Olympic Medals");
        list.add("9 World Championships");
        list.add("Winter Olympian");
        list.add("Greatest Nordic Skier");
        return new Skier(bd, "Norway", list);
    }
}
