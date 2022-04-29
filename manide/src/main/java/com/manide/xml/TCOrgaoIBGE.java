package com.manide.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TCOrgaoIBGE", namespace = "http://www.portalfiscal.inf.br/nfe")
@XmlEnum
public enum TCOrgaoIBGE {

    @XmlEnumValue("11")
    RO("11"),

    @XmlEnumValue("12")
    AC("12"),

    @XmlEnumValue("13")
    AM("13"),

    @XmlEnumValue("14")
    RR("14"),

    @XmlEnumValue("15")
    PA("15"),

    @XmlEnumValue("16")
    AP("16"),

    @XmlEnumValue("17")
    TO("17"),

    @XmlEnumValue("21")
    MA("21"),

    @XmlEnumValue("22")
    PI("22"),

    @XmlEnumValue("23")
    CE("23"),

    @XmlEnumValue("24")
    RN("24"),

    @XmlEnumValue("25")
    PB("25"),

    @XmlEnumValue("26")
    PE("26"),

    @XmlEnumValue("27")
    AL("27"),

    @XmlEnumValue("28")
    SE("28"),

    @XmlEnumValue("29")
    BA("29"),

    @XmlEnumValue("31")
    MG("31"),

    @XmlEnumValue("32")
    ES("32"),

    @XmlEnumValue("33")
    RJ("33"),

    @XmlEnumValue("35")
    SP("35"),

    @XmlEnumValue("41")
    PR("41"),

    @XmlEnumValue("42")
    SC("42"),

    @XmlEnumValue("43")
    RS("43"),

    @XmlEnumValue("50")
    MS("50"),

    @XmlEnumValue("51")
    MT("51"),

    @XmlEnumValue("52")
    GO("52"),

    @XmlEnumValue("53")
    DF("53");
    private final String value;

    TCOrgaoIBGE(String v) {
	value = v;
    }

    public String value() {
	return value;
    }

    public static TCOrgaoIBGE fromValue(String v) {
	for (TCOrgaoIBGE c : TCOrgaoIBGE.values()) {
	    if (c.value.equals(v)) {
		return c;
	    }
	}
	throw new IllegalArgumentException(v);
    }

}
