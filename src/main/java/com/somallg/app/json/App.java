package java.com.somallg.app.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.somallg.model.json.RssWrapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by somallg on 3/13/15.
 */
public class App {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RssWrapper rssWrapper = objectMapper.readValue(new File("image_of_the_day.json"), RssWrapper.class);

        objectMapper.writeValue(System.out, rssWrapper);
    }
}
