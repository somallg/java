package java.scjp5.chapter6.ioexample;

import java.io.File;

public class IOExample {

    public static void main(String[] args) throws Exception {
        File file = new File("abc");
        file.list();
        //file.createNewFile();
//		FileReader fr = new FileReader(file);
//		FileInputStream fis = new FileInputStream(file);
        //FileWriter fw = new FileWriter(file);
        System.out.println(file.exists());
    }

}
