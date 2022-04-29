//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:51:24 AM GMT-03:00 
//


package com.manide.xml.consnfedest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo Pedido de Consulta de Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TConsNFeDest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TConsNFeDest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;element name="xServ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="CONSULTAR NFE DEST"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/>
 *         &lt;element name="indNFe">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="indEmi">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ultNSU">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[0-9]{1,15}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVeConsNFeDest" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TConsNFeDest", propOrder = {
    "tpAmb",
    "xServ",
    "cnpj",
    "indNFe",
    "indEmi",
    "ultNSU"
})
public class TConsNFeDest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(required = true)
    protected String xServ;
    @XmlElement(name = "CNPJ", required = true)
    protected String cnpj;
    @XmlElement(required = true)
    protected String indNFe;
    @XmlElement(required = true)
    protected String indEmi;
    @XmlElement(required = true)
    protected String ultNSU;
    @XmlAttribute(name = "versao", required = true)
    protected TVeConsNFeDest versao;

    /**
     * Obtém o valor da propriedade tpAmb.
     * 
     * @return
     *     possible object is
     *     {@link TAmb }
     *     
     */
    public TAmb getTpAmb() {
        return tpAmb;
    }

    /**
     * Define o valor da propriedade tpAmb.
     * 
     * @param value
     *     allowed object is
     *     {@link TAmb }
     *     
     */
    public void setTpAmb(TAmb value) {
        this.tpAmb = value;
    }

    /**
     * Obtém o valor da propriedade xServ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXServ() {
        return xServ;
    }

    /**
     * Define o valor da propriedade xServ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXServ(String value) {
        this.xServ = value;
    }

    /**
     * Obtém o valor da propriedade cnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade indNFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndNFe() {
        return indNFe;
    }

    /**
     * Define o valor da propriedade indNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndNFe(String value) {
        this.indNFe = value;
    }

    /**
     * Obtém o valor da propriedade indEmi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndEmi() {
        return indEmi;
    }

    /**
     * Define o valor da propriedade indEmi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndEmi(String value) {
        this.indEmi = value;
    }

    /**
     * Obtém o valor da propriedade ultNSU.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltNSU() {
        return ultNSU;
    }

    /**
     * Define o valor da propriedade ultNSU.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltNSU(String value) {
        this.ultNSU = value;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link TVeConsNFeDest }
     *     
     */
    public TVeConsNFeDest getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link TVeConsNFeDest }
     *     
     */
    public void setVersao(TVeConsNFeDest value) {
        this.versao = value;
    }

}
