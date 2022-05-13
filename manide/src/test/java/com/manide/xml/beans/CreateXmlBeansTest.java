package com.manide.xml.beans;

import java.io.File;
import java.io.IOException;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.junit.jupiter.api.Test;

import br.inf.portalfiscal.nfe.EnvEventoDocument;
import br.inf.portalfiscal.nfe.TAmb;
import br.inf.portalfiscal.nfe.TCOrgaoIBGE;
import br.inf.portalfiscal.nfe.TEnvEvento;
import br.inf.portalfiscal.nfe.TEvento;
import br.inf.portalfiscal.nfe.TEvento.InfEvento;
import br.inf.portalfiscal.nfe.TEvento.InfEvento.TpEvento;

class CreateXmlBeansTest {
    private static final QName[] PROPERTY_QNAME = { new QName("http://www.portalfiscal.inf.br/nfe", "evento"), };

    @Test
    void test() {

	try {

	    File fileEnvEvento = new File("C:\\MDe\\envioXMLBeans.xml");
	    File fileEvento = new File("C:\\MDe\\eventoXMLBeans.xml");
	    EnvEventoDocument document = EnvEventoDocument.Factory.newInstance();

	    TEnvEvento envEvento = TEnvEvento.Factory.newInstance();

	    TEvento evento = TEvento.Factory.newInstance();

	    evento.setVersao("1.00");

	    InfEvento infEvento = InfEvento.Factory.newInstance();
	    infEvento.setId("123123123");
	    infEvento.setCOrgao(TCOrgaoIBGE.X_35);
	    infEvento.setTpAmb(TAmb.X_2);
	    infEvento.setCNPJ("11222333000199");
	    infEvento.setChNFe("01234567890123456789012345678901234567891234");
	    infEvento.setDhEvento("AAAA-MM-DDThh:mm:ssTZD-03:00");
	    infEvento.setTpEvento(TpEvento.X_210200);
	    infEvento.setNSeqEvento("1");

	    evento.setInfEvento(infEvento);

	    envEvento.setEventoArray(new TEvento[] { evento });
	    envEvento.setVersao("1.00");
	    envEvento.setIdLote("1");

	    XmlCursor cursor = envEvento.newCursor();

	    cursor.toNextToken();
	    cursor.insertNamespace("", "http://www.portalfiscal.inf.br/nfe");
	    cursor.dispose();

	    document.setEnvEvento(envEvento);

	    document.save(fileEnvEvento);

	    XmlOptions options = new XmlOptions();
	    options.setSaveSyntheticDocumentElement(new QName("http://www.portalfiscal.inf.br/nfe", "evento"));

	    XmlCursor cursor2 = evento.newCursor();

	    cursor2.toNextToken();
	    cursor2.insertNamespace("", "http://www.portalfiscal.inf.br/nfe");
	    cursor2.dispose();
	    evento.save(fileEvento, options);
	    TEvento parse = TEvento.Factory.parse(new File("C:\\MDe\\event2-signed.xml"));
	    System.out.println(parse);

	} catch (IOException | XmlException e) {
	    e.printStackTrace();
	}
    }
}