//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2022.04.29 �s 10:54:59 AM GMT-03:00 
//


package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TAmb.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TAmb">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="preserve"/>
 *     &lt;enumeration value="1"/>
 *     &lt;enumeration value="2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TAmb")
@XmlEnum
public enum TAmb {

    @XmlEnumValue("1")
    VALUE_1("1"),
    @XmlEnumValue("2")
    VALUE_2("2");
    private final String value;

    TAmb(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TAmb fromValue(String v) {
        for (TAmb c: TAmb.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
