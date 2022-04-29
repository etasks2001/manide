package com.manide.xml.consulta.retorno;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TVeConsNFeDest")
@XmlEnum
public enum TVeConsNFeDest {

    @XmlEnumValue("1.01")
    VERSAO("1.01");
    private final String value;

    TVeConsNFeDest(String v) {
	value = v;
    }

    public String value() {
	return value;
    }

    public static TVeConsNFeDest fromValue(String v) {
	for (TVeConsNFeDest c : TVeConsNFeDest.values()) {
	    if (c.value.equals(v)) {
		return c;
	    }
	}
	throw new IllegalArgumentException(v);
    }

}
