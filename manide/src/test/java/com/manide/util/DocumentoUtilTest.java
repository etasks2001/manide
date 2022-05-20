package com.manide.util;

import org.junit.jupiter.api.Test;

class DocumentoUtilTest {

    @Test
    void test() {
	try {
	    String xml = new DocumentoUtil().xmlAssinado();
	    System.out.println(xml);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
