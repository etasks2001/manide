package com.manide.xml.evento.entrada;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
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

import com.manide.xml.TAmb;
import com.manide.xml.TCOrgaoIBGE;
import com.manide.xml.evento.ObjectFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(value = Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Service - Lista de Preço")
class TEnvEventoTest {
    @Autowired
    JAXBContext context;

    @Autowired
    ObjectFactory objectFactory;

    @Autowired
    Marshaller marshaller;

    @Test
    void test() throws JAXBException, IOException {

	TEnvEvento envEvento = new TEnvEvento();
	envEvento.setVersao("2.22");
	envEvento.setIdLote("1");

	TEvento evento = new TEvento();
	evento.setVersao("1.11");

	InfEvento infEvento = new InfEvento();
	infEvento.setId("jfdklçaslfjdklçjdl");
	infEvento.setCOrgao(TCOrgaoIBGE.SP);
	infEvento.setTpAmb(TAmb.HOMOLOGACAO);
	infEvento.setCNPJ("11222333000199");
	infEvento.setChNFe("156456456456456456456");
	infEvento.setDhEvento("2010-08-19T13:00:15-03:00");
	infEvento.setTpEvento("210200");
	infEvento.setNSeqEvento("1");
	infEvento.setVerEvento("123");

	DetEvento detEvento = new DetEvento();
	detEvento.setVersao("45");
	detEvento.setDescEvento("Confirmacao da Operacao");
	detEvento.setXJust("jkfdçeior");

	infEvento.setDetEvento(detEvento);

	evento.setInfEvento(infEvento);

	envEvento.addEvento(evento);

	JAXBElement<TEnvEvento> tEnvEvento = objectFactory.createEnvEvento(envEvento);

	OutputStream file = new FileOutputStream("c:\\mde\\teste.xml");
	marshaller.marshal(tEnvEvento, file);

	file.close();

    }

}
