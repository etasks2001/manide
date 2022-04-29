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
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="procNFeGrupoZip">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="NFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *                     &lt;element name="protNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="procNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *           &lt;element name="procNFe">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;any processContents='skip'/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
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
    "chNFe",
    "cStat",
    "xMotivo",
    "procNFeGrupoZip",
    "procNFeZip",
    "procNFe"
})
public class RetNFe {

    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    protected ProcNFeGrupoZip procNFeGrupoZip;
    protected byte[] procNFeZip;
    protected ProcNFe procNFe;

    /**
     * Obtém o valor da propriedade chNFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * Define o valor da propriedade chNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChNFe(String value) {
        this.chNFe = value;
    }

    /**
     * Obtém o valor da propriedade cStat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Define o valor da propriedade cStat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCStat(String value) {
        this.cStat = value;
    }

    /**
     * Obtém o valor da propriedade xMotivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Define o valor da propriedade xMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * Obtém o valor da propriedade procNFeGrupoZip.
     * 
     * @return
     *     possible object is
     *     {@link ProcNFeGrupoZip }
     *     
     */
    public ProcNFeGrupoZip getProcNFeGrupoZip() {
        return procNFeGrupoZip;
    }

    /**
     * Define o valor da propriedade procNFeGrupoZip.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcNFeGrupoZip }
     *     
     */
    public void setProcNFeGrupoZip(ProcNFeGrupoZip value) {
        this.procNFeGrupoZip = value;
    }

    /**
     * Obtém o valor da propriedade procNFeZip.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getProcNFeZip() {
        return procNFeZip;
    }

    /**
     * Define o valor da propriedade procNFeZip.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setProcNFeZip(byte[] value) {
        this.procNFeZip = value;
    }

    /**
     * Obtém o valor da propriedade procNFe.
     * 
     * @return
     *     possible object is
     *     {@link ProcNFe }
     *     
     */
    public ProcNFe getProcNFe() {
        return procNFe;
    }

    /**
     * Define o valor da propriedade procNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcNFe }
     *     
     */
    public void setProcNFe(ProcNFe value) {
        this.procNFe = value;
    }

}
