package com.manide.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

class DocumentoUtilTest {

    @Test
    void test() {
	try {
	    DocumentoUtil util = new DocumentoUtil();
	    String xml = util.xmlAssinado();
	    System.out.println(xml);

	    OutputStream os = new FileOutputStream(new File("c:/mde/teste-assinado.xml"));
	    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, "UTF-8");
	    outputStreamWriter.write(xml);

	    outputStreamWriter.flush();
	    outputStreamWriter.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    @Test
    void test2() {
	try {
	    DocumentoUtil util = new DocumentoUtil();
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	    DocumentBuilder bd = dbf.newDocumentBuilder();

	    Document document = bd.parse(new File("c:/mde/teste-assinado.xml"));

	    boolean isValid = util.validarAssinaturaXML(document);

	    System.out.println(isValid);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
