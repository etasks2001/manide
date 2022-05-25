package com.manide.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import com.manide.exception.ManideKeyException;

public class KeyRepository {

    private KeyStore keyStore;
    private PrivateKey privateKey;

    private X509Certificate certificate;

    protected KeyRepository(InputStream stream, char[] password)
	    throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyStoreException, UnrecoverableKeyException {

	keyStore = KeyStore.getInstance("PKCS12");
	keyStore.load(new FileInputStream(new File("C:\\x\\franco\\fdasfdsa.pfx")), password);

	String alias = null;
	Enumeration<String> aliases = keyStore.aliases();

	while (aliases.hasMoreElements()) {
	    alias = aliases.nextElement();
	}
	certificate = (X509Certificate) keyStore.getCertificate(alias);

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
}
