package com.somallg.jax.ws.provider;

import com.somallg.jax.ws.beans.ObjectFactory;
import com.somallg.jax.ws.beans.ReverseStringReq;
import com.somallg.jax.ws.beans.ReverseStringResp;

import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

/**
 * Created by somallg on 11/28/14.
 */

@WebServiceProvider(
        wsdlLocation = "WEB-INF/wsdl/StringProcessorService.wsdl",
        portName = "StringProcessorServicePort",
        serviceName = "StringProcessorService",
        targetNamespace = "http://www.somallg.com/stringprocessor")
@ServiceMode(value = Service.Mode.PAYLOAD)
@SOAPBinding(
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED,
        style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL)
public class StringProcessor implements Provider<Source> {

    @SuppressWarnings("unchecked")
	@Override
    public Source invoke(Source sourceRequest) {

        try {
            JAXBContext context = JAXBContext.newInstance("com.somallg.jax.ws.beans");

            Unmarshaller unmarshaller = context.createUnmarshaller();


            JAXBElement<ReverseStringReq> requestElement = (JAXBElement<ReverseStringReq>) unmarshaller.unmarshal(sourceRequest);

            ReverseStringReq requestString = requestElement.getValue();

            System.out.println("Get request to reverse string " + requestString.getInString());

            String responseString = new StringBuffer(requestString.getInString()).reverse().toString();

            ReverseStringResp reverseStringResp = new ReverseStringResp();
            reverseStringResp.setReturn(responseString);

            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<ReverseStringResp> responseElement = objectFactory.createReverseStringResp(reverseStringResp);

//            QName qName = new QName(requestElement.getName().getNamespaceURI(), "reverseStringResp");
//
//            JAXBElement<ReverseStringResp> responseElement = new JAXBElement<ReverseStringResp>(qName, ReverseStringResp.class, reverseStringResp);

            return new JAXBSource(context, responseElement);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
