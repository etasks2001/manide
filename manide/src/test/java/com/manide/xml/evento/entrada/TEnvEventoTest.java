package com.manide.xml.evento.entrada;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.manide.FactoryXmlTest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(value = Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("XML Envio de Evento")
class TEnvEventoTest {

    private static final String C_MDE_TESTE_XML = "c:\\mde\\teste.xml";

    @Autowired
    ObjectFactory objectFactory;

    @Autowired
    Marshaller marshaller;

    @Autowired
    Unmarshaller unmarshaller;

    @Autowired
    private FactoryXmlTest factoryXml;

    @Test
    @DisplayName("Grava XML")
    void test() {
	try {
	    TEnvEvento envEvento = factoryXml.createEvent();

	    OutputStream os = new FileOutputStream(C_MDE_TESTE_XML);
	    marshaller.marshal(objectFactory.createEnvEvento(envEvento), os);
	    os.close();

	    InputStream is = new FileInputStream(C_MDE_TESTE_XML);
	    TEnvEvento envEvento2 = ((JAXBElement<TEnvEvento>) unmarshaller.unmarshal(is)).getValue();

	    MatcherAssert.assertThat(envEvento.getIdLote(), Matchers.is(envEvento2.getIdLote()));
	    MatcherAssert.assertThat(envEvento.getVersao(), Matchers.is(envEvento2.getVersao()));

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}