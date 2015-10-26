package java.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by somallg on 9/2/14.
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };

            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
    }
}
