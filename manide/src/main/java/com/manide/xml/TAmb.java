package com.manide.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TAmb", namespace = "http://www.portalfiscal.inf.br/nfe")
@XmlEnum
public enum TAmb {

    @XmlEnumValue("1")
    PRODUCAO("1"),

    @XmlEnumValue("2")
    HOMOLOGACAO("2");
    private final String value;

    TAmb(String v) {
	value = v;
    }

    public String value() {
	return value;
    }

    public static TAmb fromValue(String v) {
	for (TAmb c : TAmb.values()) {
	    if (c.value.equals(v)) {
		return c;
	    }
	}
	throw new IllegalArgumentException(v);
    }

}
