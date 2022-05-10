package com.manide.xml.evento.entrada;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

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
import com.manide.util.NFeXmlSignature;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(value = Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("XML Envio de Evento")
class TEnvEventoTest {

    private static final String FILE_NAME_EVENTO_2_SIGNED = "c:\\mde\\event2-signed.xml";

    private static final String FILE_NAME_EVENTO_1_SIGNED = "c:\\mde\\event1-signed.xml";

    private static final String FILE_NAME_EVENTO_2 = "c:\\mde\\event2.xml";

    private static final String FILE_NAME_EVENTO_1 = "c:\\mde\\event1.xml";

    private static final String FILE_NAME_ENVIO_EVENTO = "c:\\mde\\envioEvento.xml";

    @Autowired
    ObjectFactory objectFactory;

    @Autowired
    Marshaller marshaller;
    @Autowired
    Unmarshaller unmarshaller;

    @Autowired
    private FactoryXmlTest factoryXml;

    @Test
    @DisplayName("Teste XML gravado")
    void test() {

	try {
	    TEvento createEvento2 = factoryXml.createEvento2();
	    TEvento createEvento1 = factoryXml.createEvento1();

	    OutputStream osEvent1 = new FileOutputStream(FILE_NAME_EVENTO_1);
	    marshaller.marshal(objectFactory.createEvento(createEvento1), osEvent1);
	    osEvent1.close();

	    FileOutputStream osEvent2 = new FileOutputStream(FILE_NAME_EVENTO_2);
	    marshaller.marshal(objectFactory.createEvento(createEvento2), osEvent2);
	    osEvent2.close();

	    /* ====================================================== */
	    NFeXmlSignature certClient = new NFeXmlSignature("C:\\MDe\\fs.jks", "448006".toCharArray(), "infEvento");

	    certClient.signXML(FILE_NAME_EVENTO_1, FILE_NAME_EVENTO_1_SIGNED);
	    certClient.signXML(FILE_NAME_EVENTO_2, FILE_NAME_EVENTO_2_SIGNED);

	    /* ====================================================== */

	    InputStream isSigned1 = new FileInputStream(FILE_NAME_EVENTO_1_SIGNED);
	    InputStream isSigned2 = new FileInputStream(FILE_NAME_EVENTO_2_SIGNED);

//	TEvento evento1 = JAXB.unmarshal(FILE_NAME_EVENTO_1_SIGNED, TEvento.class);
//	TEvento evento2 = JAXB.unmarshal(FILE_NAME_EVENTO_2_SIGNED, TEvento.class);

	    JAXBElement<TEvento> evento1 = (JAXBElement<TEvento>) unmarshaller.unmarshal(new StreamSource(isSigned1), TEvento.class);
	    JAXBElement<TEvento> evento2 = (JAXBElement<TEvento>) unmarshaller.unmarshal(new StreamSource(isSigned2), TEvento.class);

	    System.out.println(evento1.getValue().getSignature());
	    System.out.println(evento2.getValue().getSignature());

	    TEnvEvento envEvento = factoryXml.createEvent();

	    envEvento.addEvento(evento1.getValue());
	    envEvento.addEvento(evento2.getValue());

	    OutputStream os = new FileOutputStream(FILE_NAME_ENVIO_EVENTO);

	    marshaller.marshal(objectFactory.createEnvEvento(envEvento), os);
	    os.close();

	    /* ====================================================== */

	    InputStream is = new FileInputStream(FILE_NAME_ENVIO_EVENTO);
	    TEnvEvento envEvento2 = JAXB.unmarshal(is, TEnvEvento.class);
	    is.close();

	    assertThat(envEvento.getIdLote(), is(envEvento2.getIdLote()));
	    assertThat(envEvento.getVersao(), is(envEvento2.getVersao()));

	    assertThat(envEvento.getEvento().size(), is(2));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (JAXBException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
