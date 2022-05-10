package com.manide.xml.beans;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.XmlCursor;
import org.junit.jupiter.api.Test;

import br.inf.portalfiscal.nfe.EnvEventoDocument;
import br.inf.portalfiscal.nfe.TEnvEvento;

class CreateXmlBeansTest {

    @Test
    void test() {

	try {

	    File file = new File("C:\\MDe\\envioXMLBeans.xml");
	    EnvEventoDocument envEventoDocument = EnvEventoDocument.Factory.newInstance();
	    TEnvEvento envEvento = TEnvEvento.Factory.newInstance();

	    envEvento.setVersao("1.00");
	    envEvento.setIdLote("1");

	    XmlCursor cursor = envEvento.newCursor();

	    Map<String, String> addToThis = new HashMap<String, String>();

	    cursor.getAllNamespaces(addToThis);
	    cursor.prefixForNamespace("http://www.portalfiscal.inf.br/nfe");
	    cursor.toNextToken();
	    cursor.insertNamespace("", "http://www.portalfiscal.inf.br/nfe");
	    cursor.dispose();

	    envEventoDocument.setEnvEvento(envEvento);

	    envEventoDocument.save(file);

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
