package com.manide.certificado;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;

public final class CertificadoUtil {

    public static void validarNaoRepudio(X509Certificate certificado) throws Exception {
	boolean[] keyUsage = certificado.getKeyUsage();
	if (!keyUsage[1]) {
	    System.out.println("[Npermitido o uso da chave do certificado para assinatura - Certificado deve ser \"N\".] " + keyUsage[1]);
	    throw new Exception("Npermitido o uso da chave do certificado para assinatura - Certificado deve ser \"N\".");
	}
    }

    public static void validarUsoChaveAssinatura(X509Certificate certificado) throws Exception {
	boolean[] keyUsage = certificado.getKeyUsage();
	if (!keyUsage[0]) {
	    System.out.println("[Npermitido o uso da chave do certificado para assinatura.] " + keyUsage[0]);
	    throw new Exception("Npermitido o uso da chave do certificado para assinatura.");
	}
    }

    public static void validarPeriodo(X509Certificate certificado) throws Exception {
	Date dataValidacao = new Date();
	if (!certificado.getNotBefore().before(dataValidacao) || !certificado.getNotAfter().after(dataValidacao)) {
	    System.out.println("[O perde validade do certificado expirou.] " + certificado.getNotBefore() + " at" + certificado.getNotAfter());
	    throw new Exception("O perde validade do certificado expirou.");
	}
    }

    public static String getAssunto(X509Certificate certificado) {
	return certificado.getSubjectDN().toString();
    }

    public static String getEmissor(X509Certificate certificado) {
	return certificado.getIssuerDN().toString();
    }

    public static Date getDataValidadeFim(X509Certificate certificado) {
	return certificado.getNotAfter();
    }

    public static Date getDataValidadeInicio(X509Certificate certificado) {
	return certificado.getNotBefore();
    }

    public static String getCnpj(X509Certificate cert) throws CertificateEncodingException {
	X500Name x500name = new JcaX509CertificateHolder(cert).getSubject();

	RDN cn = x500name.getRDNs(BCStyle.CN)[0];

	String nome = IETFUtils.valueToString(cn.getFirst().getValue());

	String cnpj = nome.substring(nome.length() - 14, nome.length());
	return cnpj;
    }
}