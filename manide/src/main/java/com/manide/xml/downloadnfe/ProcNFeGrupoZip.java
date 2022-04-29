//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:54:59 AM GMT-03:00 
//


package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="protNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nFeZip",
    "protNFeZip"
})
public class ProcNFeGrupoZip {

    @XmlElement(name = "NFeZip", required = true)
    protected byte[] nFeZip;
    @XmlElement(required = true)
    protected byte[] protNFeZip;

    /**
     * Obtém o valor da propriedade nFeZip.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getNFeZip() {
        return nFeZip;
    }

    /**
     * Define o valor da propriedade nFeZip.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setNFeZip(byte[] value) {
        this.nFeZip = value;
    }

    /**
     * Obtém o valor da propriedade protNFeZip.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getProtNFeZip() {
        return protNFeZip;
    }

    /**
     * Define o valor da propriedade protNFeZip.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setProtNFeZip(byte[] value) {
        this.protNFeZip = value;
    }

}
