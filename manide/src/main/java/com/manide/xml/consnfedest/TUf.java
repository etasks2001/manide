package com.manide.xml.consnfedest;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TUf")
@XmlEnum
public enum TUf {

    AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO, EX;

    public String value() {
	return name();
    }

    public static TUf fromValue(String v) {
	return valueOf(v);
    }

}
