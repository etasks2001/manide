//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.05.17 às 11:30:23 AM GMT-03:00 
//


package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;choice>
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *         &lt;/choice>
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *         &lt;element name="dhEvento" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/>
 *         &lt;element name="tpEvento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[0-9]{6}"/>
 *               &lt;enumeration value="210200"/>
 *               &lt;enumeration value="210210"/>
 *               &lt;enumeration value="210220"/>
 *               &lt;enumeration value="210240"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nSeqEvento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[0-9]{1,2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="verEvento" type="{http://www.portalfiscal.inf.br/nfe}TVerEnvEvento"/>
 *         &lt;element name="detEvento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="descEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="Confirmacao da Operacao"/>
 *                         &lt;enumeration value="Ciencia da Operacao"/>
 *                         &lt;enumeration value="Desconhecimento da Operacao"/>
 *                         &lt;enumeration value="Operacao nao Realizada"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="xJust" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;minLength value="15"/>
 *                         &lt;maxLength value="255"/>
 *                         &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="versao" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;whiteSpace value="preserve"/>
 *                       &lt;enumeration value="1.00"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="ID[0-9]{52}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cOrgao",
    "tpAmb",
    "cnpj",
    "cpf",
    "chNFe",
    "dhEvento",
    "tpEvento",
    "nSeqEvento",
    "verEvento",
    "detEvento"
})
public class InfEvento {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "string")
    protected TCOrgaoIBGE cOrgao;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String cnpj;
    @XmlElement(name = "CPF", namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String cpf;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String chNFe;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String dhEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String tpEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String nSeqEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String verEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected DetEvento detEvento;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Obtém o valor da propriedade cOrgao.
     * 
     * @return
     *     possible object is
     *     {@link TCOrgaoIBGE }
     *     
     */
    public TCOrgaoIBGE getCOrgao() {
        return cOrgao;
    }

    /**
     * Define o valor da propriedade cOrgao.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOrgaoIBGE }
     *     
     */
    public void setCOrgao(TCOrgaoIBGE value) {
        this.cOrgao = value;
    }

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
     * Obtém o valor da propriedade cpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

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
     * Obtém o valor da propriedade dhEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhEvento() {
        return dhEvento;
    }

    /**
     * Define o valor da propriedade dhEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhEvento(String value) {
        this.dhEvento = value;
    }

    /**
     * Obtém o valor da propriedade tpEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEvento() {
        return tpEvento;
    }

    /**
     * Define o valor da propriedade tpEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEvento(String value) {
        this.tpEvento = value;
    }

    /**
     * Obtém o valor da propriedade nSeqEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSeqEvento() {
        return nSeqEvento;
    }

    /**
     * Define o valor da propriedade nSeqEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSeqEvento(String value) {
        this.nSeqEvento = value;
    }

    /**
     * Obtém o valor da propriedade verEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerEvento() {
        return verEvento;
    }

    /**
     * Define o valor da propriedade verEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerEvento(String value) {
        this.verEvento = value;
    }

    /**
     * Obtém o valor da propriedade detEvento.
     * 
     * @return
     *     possible object is
     *     {@link DetEvento }
     *     
     */
    public DetEvento getDetEvento() {
        return detEvento;
    }

    /**
     * Define o valor da propriedade detEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link DetEvento }
     *     
     */
    public void setDetEvento(DetEvento value) {
        this.detEvento = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
