package com.manide.util;

import org.junit.jupiter.api.Test;

class DocumentoUtilTest {

    @Test
    void test() {
	String xml = DocumentoUtil.criarXMLEnvioEventoManifestacao();
	System.out.println(xml);

    }

}
