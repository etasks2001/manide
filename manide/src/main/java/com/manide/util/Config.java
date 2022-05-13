package com.manide.util;

import static java.lang.Boolean.TRUE;
import static javax.xml.bind.Marshaller.JAXB_FRAGMENT;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String XML_HEADERS = "com.sun.xml.internal.bind.xmlHeaders";
    public static final String XML_HEADERS2 = "com.sun.xml.internal.bind.xmlHeaders";

    @Bean
    public JAXBContext jaxbContext() throws JAXBException {
//	return JAXBContext.newInstance(TEnvEvento.class, TEvento.class);
	return null;
    }

    @Bean
    Marshaller createMarshaller() throws JAXBException {
	Marshaller marshaller = jaxbContext().createMarshaller();

	marshaller.setProperty(JAXB_FRAGMENT, TRUE);
	marshaller.setProperty(XML_HEADERS, XML_VERSION);
	marshaller.setListener(new MarshalLogger());
	return marshaller;
    }

    @Bean
    Unmarshaller createUnmarshaller() throws JAXBException {
	Unmarshaller unmarshaller = jaxbContext().createUnmarshaller();
	unmarshaller.setListener(new UnmarshalLogger());
//	unmarshaller.setProperty(JAXB_FRAGMENT, TRUE);
//	unmarshaller.setProperty(XML_HEADERS, XML_VERSION);
	return unmarshaller;
    }

}