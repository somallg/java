package java.com.somallg.app.xml;

import com.somallg.model.xml.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by somallg on 3/12/15.
 */
public class App {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Rss rss = (Rss) unmarshaller.unmarshal(new File("image_of_the_day.rss"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(rss, System.out);
    }
}
