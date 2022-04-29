package com.manide.xml.consulta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.manide.xml.consulta.entrada.TConsNFeDest;
import com.manide.xml.consulta.retorno.Ret;
import com.manide.xml.consulta.retorno.TRetConsNFeDest;

@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsNFeDest_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "consNFeDest");

    public ObjectFactory() {
    }

    public TConsNFeDest createTConsNFeDest() {
	return new TConsNFeDest();
    }

    public TRetConsNFeDest createTRetConsNFeDest() {
	return new TRetConsNFeDest();
    }

    public Ret createRet() {
	return new Ret();
    }

    public ResNFe createResNFe() {
	return new ResNFe();
    }

    public ResCanc createResCanc() {
	return new ResCanc();
    }

    public ResCCe createResCCe() {
	return new ResCCe();
    }

    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "consNFeDest")
    public JAXBElement<TConsNFeDest> createConsNFeDest(TConsNFeDest value) {
	return new JAXBElement<TConsNFeDest>(_ConsNFeDest_QNAME, TConsNFeDest.class, null, value);
    }

}
