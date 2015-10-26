package java.scjp5.chapter6.serialization;

import java.io.*;

class Animal {
    private int id;

    Animal() {
        id = 12345;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }
}

class Collar implements Serializable {
    String name;

    Collar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal implements Serializable {
    static int i = 10;
    String name;

    Cat(int id, String name) {
        this.setId(id);
        this.name = name;
    }

    public String toString() {
        return name + " " + getId();
    }
}

public class SerializationExample {

    public static void main(String[] args) {
        Cat c = new Cat(100, "Tom");
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("testSer.ser"));
            System.out.println("Before serialization");
            c.setId(0);
            System.out.println(c);
            c.i = 0;
            System.out.println(c.i);
            os.writeObject(c);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "testSer.ser"));
            Cat d = (Cat) is.readObject();
            System.out.println("After deserialization");
            System.out.println(d);
            System.out.println(d.i);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
