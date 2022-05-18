package com.manide.util;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String XML_HEADERS = "com.sun.xml.internal.bind.xmlHeaders";
    public static final String XML_HEADERS2 = "com.sun.xml.internal.bind.xmlHeaders";

//    @Bean
//    public JAXBContext jaxbContext() throws JAXBException {
//	return JAXBContext.newInstance(TEnvEvento.class, SignatureType.class);
//    }

//    @Bean
//    Marshaller createMarshaller() throws JAXBException {
//	Marshaller marshaller = jaxbContext().createMarshaller();
//
//	marshaller.setProperty(JAXB_FRAGMENT, TRUE);
//	marshaller.setProperty(XML_HEADERS, XML_VERSION);
//	marshaller.setListener(new MarshalLogger());
//	return marshaller;
//    }

//    @Bean
//    Unmarshaller createUnmarshaller() throws JAXBException {
//	Unmarshaller unmarshaller = jaxbContext().createUnmarshaller();
//	unmarshaller.setListener(new UnmarshalLogger());
//	return unmarshaller;
//    }

//    @Bean
//    ObjectFactory getObjectFactory() {
//	return new ObjectFactory();
//    }

}