package com.manide.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TCOrgaoIBGE", namespace = "http://www.portalfiscal.inf.br/nfe")
@XmlEnum
public enum TCOrgaoIBGE {

    @XmlEnumValue("11")
    VALUE_1("11"), @XmlEnumValue("12")
    VALUE_2("12"), @XmlEnumValue("13")
    VALUE_3("13"), @XmlEnumValue("14")
    VALUE_4("14"), @XmlEnumValue("15")
    VALUE_5("15"), @XmlEnumValue("16")
    VALUE_6("16"), @XmlEnumValue("17")
    VALUE_7("17"), @XmlEnumValue("21")
    VALUE_8("21"), @XmlEnumValue("22")
    VALUE_9("22"), @XmlEnumValue("23")
    VALUE_10("23"), @XmlEnumValue("24")
    VALUE_11("24"), @XmlEnumValue("25")
    VALUE_12("25"), @XmlEnumValue("26")
    VALUE_13("26"), @XmlEnumValue("27")
    VALUE_14("27"), @XmlEnumValue("28")
    VALUE_15("28"), @XmlEnumValue("29")
    VALUE_16("29"), @XmlEnumValue("31")
    VALUE_17("31"), @XmlEnumValue("32")
    VALUE_18("32"), @XmlEnumValue("33")
    VALUE_19("33"), @XmlEnumValue("35")
    VALUE_20("35"), @XmlEnumValue("41")
    VALUE_21("41"), @XmlEnumValue("42")
    VALUE_22("42"), @XmlEnumValue("43")
    VALUE_23("43"), @XmlEnumValue("50")
    VALUE_24("50"), @XmlEnumValue("51")
    VALUE_25("51"), @XmlEnumValue("52")
    VALUE_26("52"), @XmlEnumValue("53")
    VALUE_27("53"), @XmlEnumValue("90")
    VALUE_28("90"), @XmlEnumValue("91")
    VALUE_29("91");
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
