package java.scjp6.exams.practice.dump;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SticksMud {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println(sb1.equals(sb2));
        try {
            File dir = new File("dir");
            dir.createNewFile();
        } catch (FileNotFoundException io) {
        } catch (IOException io) {
        } catch (NullPointerException io) {
        } catch (IllegalArgumentException io) {
        } catch (ClassCastException io) {
        } catch (RuntimeException io) {
        } catch (Exception io) {
        } catch (Throwable io) {
        }
    }

}
