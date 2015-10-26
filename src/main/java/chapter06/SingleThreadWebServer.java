package java.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by somallg on 9/2/14.
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {

    }
}
