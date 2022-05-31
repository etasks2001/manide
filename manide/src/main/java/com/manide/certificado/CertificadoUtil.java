package com.manide.certificado;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.springframework.stereotype.Component;

import com.manide.exception.ManideException;

@Component
public final class CertificadoUtil {

    public boolean cnpjEncontrado(X509Certificate certificate, String cnpj) throws CertificateEncodingException {
	X500Name x500name = new JcaX509CertificateHolder(certificate).getSubject();
	RDN cn = x500name.getRDNs(BCStyle.CN)[0];
	String nome = IETFUtils.valueToString(cn.getFirst().getValue());
	String cnpjCertificado = nome.substring(nome.length() - 14, nome.length());

	if (!cnpj.equals(cnpjCertificado)) {
	    throw new ManideException("CNPJ não encontrado.");
	}
	return true;

    }

}