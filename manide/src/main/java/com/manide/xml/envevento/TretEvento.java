//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2022.04.29 �s 10:47:08 AM GMT-03:00 
//


package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo retorno do Evento
 * 
 * <p>Classe Java de TretEvento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TretEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infEvento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *                   &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *                   &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
 *                   &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *                   &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/>
 *                   &lt;element name="tpEvento" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="[0-9]{6}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="xEvento" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                         &lt;minLength value="5"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="nSeqEvento" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="[0-9]{1,2}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="CNPJDest" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
 *                     &lt;element name="CPFDest" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                   &lt;/choice>
 *                   &lt;element name="emailDest" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="dhRegEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d-0[1-3]:00"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Id">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *                       &lt;pattern value="ID[0-9]{15}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEvento" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TretEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = {
    "infEvento",
    "signature"
})
public class TretEvento {

    @XmlElement(required = true)
    protected InfEvento2 infEvento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obt�m o valor da propriedade infEvento.
     * 
     * @return
     *     possible object is
     *     {@link InfEvento2 }
     *     
     */
    public InfEvento2 getInfEvento() {
        return infEvento;
    }

    /**
     * Define o valor da propriedade infEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link InfEvento2 }
     *     
     */
    public void setInfEvento(InfEvento2 value) {
        this.infEvento = value;
    }

    /**
     * Obt�m o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Obt�m o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }

}