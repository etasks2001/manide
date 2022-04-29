package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TUfEmi", namespace = "http://www.portalfiscal.inf.br/nfe")
@XmlEnum
public enum TUfEmi {

    AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO;

    public String value() {
	return name();
    }

    public static TUfEmi fromValue(String v) {
	return valueOf(v);
    }

}
