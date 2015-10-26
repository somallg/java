package java.scjp6.exams.practice.exercises;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Section3D {
    public static void main(String[] args) throws IOException {
        File dir = new File("dir");
        System.out.println(dir.delete());
        //dir.mkdir();
        File f = new File(dir, "file.txt");
        System.out.println(f.delete());
        //PrintWriter p = new PrintWriter(new FileWriter(f));
        //p.append("abc");
        //p.append("abc");
        //p.append("abc");
        //p.close();
        //f.close();
        FileWriter fw = null;
        PrintWriter pw = null;
    }


}
