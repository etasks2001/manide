package com.manide.xml.evento.entrada;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.manide.FactoryXml;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(value = Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("XML Envio de Evento")
class TEnvEventoTest {

	@Autowired
	ObjectFactory objectFactory;

	@Autowired
	Marshaller marshaller;

	@Autowired
	private FactoryXml factoryXml;

	@Test
	@DisplayName("Grava XML")
	void test() throws JAXBException, IOException {

		TEnvEvento envEvento = factoryXml.createEvent();

		JAXBElement<TEnvEvento> tEnvEvento = objectFactory.createEnvEvento(envEvento);

		OutputStream file = new FileOutputStream("c:\\mde\\teste.xml");
		marshaller.marshal(tEnvEvento, file);

		file.close();

	}

}
