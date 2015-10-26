package com.somallg.nasadailyimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by somallg on 3/11/15.
 */
public class IotdHandler extends DefaultHandler {

    private String url = "http://www.nasa.gov/rss/image_of_the_day.rss";

    // variables to keep track of what element you're in
    private boolean inUrl = false;
    private boolean inTitle = false;
    private boolean inDescription = false;
    private boolean inItem = false;
    private boolean isFirstTime = true;

    private boolean inDate = false;
    private Bitmap image = null;
    private StringBuilder title = new StringBuilder();
    private StringBuilder description = new StringBuilder();
    private String date = null;

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return new String(description);
    }

    public String getTitle() {
        return new String(title);
    }

    public Bitmap getImage() {
        return image;
    }

    public void processFeed() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(this);
            InputStream inputStream = new URL(url).openStream();
            reader.parse(new InputSource(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getBitmap(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            input.close();

            return bitmap;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isFirstTime && localName.startsWith("item")) {
            inItem = true;
        } else if (inItem) {
            inUrl = localName.equals("enclosure");

            if (inUrl && image == null) {
                String imageURL = attributes.getValue("url");
                image = getBitmap(imageURL);
            }

            if (localName.equals("title")) {
                inTitle = true;
            }

            if (localName.equals("description")) {
                inDescription = true;
            }

            if (localName.equals("pubDate")) {
                inDate = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("title")) {
            inTitle = false;
        }

        if (localName.equals("description")) {
            inDescription = false;
        }

        if (localName.equals("pubDate")) {
            inDate = false;
        }

        if (localName.equals("item")) {
            inItem = false;
            isFirstTime = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        String chars = new String(ch).substring(start, start + length);
        if (inItem && inTitle) {
            title.append(chars);
        }

        if (inItem && inDescription) {
            description.append(chars);
        }

        if (inItem && inDate && date == null) {
            date = chars;
        }
    }
}
