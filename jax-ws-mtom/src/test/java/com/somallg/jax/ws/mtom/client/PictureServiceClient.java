package com.somallg.jax.ws.mtom.client;

import com.somallg.jax.ws.mtom.PictureManagerInterface;

import javax.swing.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.MTOMFeature;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by somallg on 12/1/14.
 */
public class PictureServiceClient {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/pictureManager?wsdl");

        QName qName = new QName("http://mtom.ws.jax.somallg.com/", "PictureManagerService");

        Service service = Service.create(url, qName);

        PictureManagerInterface servicePort = service.getPort(PictureManagerInterface.class, new MTOMFeature(true));

        BufferedImage image = (BufferedImage) servicePort.retrievePicture(1);

        showPicture(image);

        String message = servicePort.supplyPicture(image);

        System.out.println(message);
    }

    private static void showPicture(Image image) {
        JFrame window = new JFrame();
        window.setSize(400, 400);
        JLabel label = new JLabel(new ImageIcon(image));
        window.add(label);

        window.setVisible(true);
    }
}
