package com.manide.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;

import com.manide.exception.ManideKeyException;

public class KeyRepository {

    private KeyStore keyStore;
    private PrivateKey privateKey;

    private X509Certificate certificate;

    protected KeyRepository(InputStream stream, char[] password)
	    throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyStoreException, UnrecoverableKeyException {

	keyStore = KeyStore.getInstance("PKCS12");
	keyStore.load(stream, password);

	String alias = null;
	Enumeration<String> aliases = keyStore.aliases();

	while (aliases.hasMoreElements()) {
	    alias = aliases.nextElement();
	}
	certificate = (X509Certificate) keyStore.getCertificate(alias);

	certname(certificate);

	Key chavePrivada = (Key) keyStore.getKey(alias, password);
	if (chavePrivada instanceof PrivateKey) {
	    privateKey = (PrivateKey) chavePrivada;
	}

    }

    public static KeyRepository getInstance(InputStream stream, char[] password) {
	try {
	    return new KeyRepository(stream, password);
	} catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException | UnrecoverableKeyException e) {
	    throw new ManideKeyException(e);
	}
    }

    public X509Certificate getCertificate() {
	return certificate;
    }

    public PrivateKey getPrivateKey() {
	return privateKey;
    }

    private void certname(X509Certificate cert) throws CertificateEncodingException {
	X500Name x500name = new JcaX509CertificateHolder(cert).getSubject();

	RDN[] rdNs = x500name.getRDNs();
	System.out.println("------------------------------------------------------------------");
	for (RDN rdn : rdNs) {
	    System.out.println(IETFUtils.valueToString(rdn.getFirst().getValue()));
	}

	RDN cn = x500name.getRDNs(BCStyle.CN)[0];

	System.out.println(IETFUtils.valueToString(cn.getFirst().getValue()));
    }

}
