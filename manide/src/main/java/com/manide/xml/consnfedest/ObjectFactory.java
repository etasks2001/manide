//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:51:24 AM GMT-03:00 
//


package com.manide.xml.consnfedest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.manide.xml.consnfedest package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsNFeDest_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "consNFeDest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.manide.xml.consnfedest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TConsNFeDest }
     * 
     */
    public TConsNFeDest createTConsNFeDest() {
        return new TConsNFeDest();
    }

    /**
     * Create an instance of {@link TRetConsNFeDest }
     * 
     */
    public TRetConsNFeDest createTRetConsNFeDest() {
        return new TRetConsNFeDest();
    }

    /**
     * Create an instance of {@link Ret }
     * 
     */
    public Ret createRet() {
        return new Ret();
    }

    /**
     * Create an instance of {@link ResNFe }
     * 
     */
    public ResNFe createResNFe() {
        return new ResNFe();
    }

    /**
     * Create an instance of {@link ResCanc }
     * 
     */
    public ResCanc createResCanc() {
        return new ResCanc();
    }

    /**
     * Create an instance of {@link ResCCe }
     * 
     */
    public ResCCe createResCCe() {
        return new ResCCe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TConsNFeDest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "consNFeDest")
    public JAXBElement<TConsNFeDest> createConsNFeDest(TConsNFeDest value) {
        return new JAXBElement<TConsNFeDest>(_ConsNFeDest_QNAME, TConsNFeDest.class, null, value);
    }

}
