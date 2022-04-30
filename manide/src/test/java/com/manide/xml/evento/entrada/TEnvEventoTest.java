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

import com.manide.xml.TAmb;
import com.manide.xml.TCOrgaoIBGE;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(value = Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Gravar XML envio de evento")
class TEnvEventoTest {

	private static final String VERSAO = "1.00";

	@Autowired
	ObjectFactory objectFactory;

	@Autowired
	Marshaller marshaller;

	@Test
	void test() throws JAXBException, IOException {

		TEvento evento = new TEvento();
		evento.setVersao(VERSAO);

		InfEvento infEvento = new InfEvento();
		infEvento.setId("1");
		infEvento.setCOrgao(TCOrgaoIBGE.SP);
		infEvento.setTpAmb(TAmb.HOMOLOGACAO);
		infEvento.setCNPJ("11222333000199");
		infEvento.setChNFe("01234567890123456789012345678901234567890123");
		infEvento.setDhEvento("2010-08-19T13:00:15-03:00");
		infEvento.setTpEvento("210200");
		infEvento.setNSeqEvento("1");
		infEvento.setVerEvento(VERSAO);

		DetEvento detEvento = new DetEvento();
		detEvento.setVersao(VERSAO);
		detEvento.setDescEvento("Confirmacao da Operacao");
		detEvento.setXJust("pedido não foi realizado");

		infEvento.setDetEvento(detEvento);

		evento.setInfEvento(infEvento);

		TEnvEvento envEvento = new TEnvEvento();
		envEvento.setVersao(VERSAO);
		envEvento.setIdLote("1");
		envEvento.addEvento(evento);

		JAXBElement<TEnvEvento> tEnvEvento = objectFactory.createEnvEvento(envEvento);

		OutputStream file = new FileOutputStream("c:\\mde\\teste.xml");
		marshaller.marshal(tEnvEvento, file);

		file.close();

	}

}
