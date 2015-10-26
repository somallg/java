package com.somallg.jax.ws.mtom;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.MTOM;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by somallg on 11/30/14.
 */

@WebService(endpointInterface = "com.somallg.jax.ws.mtom.PictureManagerInterface")
@MTOM(enabled = true, threshold = 512)
public class PictureManager implements PictureManagerInterface {

    @Resource
    private WebServiceContext context;

    @WebMethod
    public Image retrievePicture(@WebParam(name = "inImageNumber") int inImageNumber) {
        Image image = null;

        MessageContext messageContext = context.getMessageContext();
        ServletContext servletContext = (ServletContext) messageContext.get(MessageContext.SERVLET_CONTEXT);

        if (servletContext != null) {
            String imageFileName = "/images/" + inImageNumber + ".jpg";
            URL imageFileURL = null;

            try {
                imageFileURL = servletContext.getResource(imageFileName);
                image = ImageIO.read(imageFileURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No servlet context, cannot retrieve image!");
        }

        return image;
    }

    @WebMethod
    public String supplyPicture(@WebParam(name = "inImage") Image inImage) {
        String message = "PictureManager received a picture with height " + inImage.getHeight(null) + " and width " + inImage.getWidth(null) + " at " + new Date();

        return message;
    }
}
