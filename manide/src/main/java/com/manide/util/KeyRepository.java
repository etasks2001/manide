package com.manide.util;

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

    private X509Certificate certificado;

    protected KeyRepository(InputStream stream, char[] password) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, UnrecoverableKeyException {

	keyStore = KeyStore.getInstance("PKCS12");
	keyStore.load(stream, password);

	String alias = null;
	Enumeration<String> aliases = keyStore.aliases();

	while (aliases.hasMoreElements()) {
	    alias = aliases.nextElement();
	}
	certificado = (X509Certificate) keyStore.getCertificate(alias);

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

    public X509Certificate getCertificado() {
	return certificado;
    }

    public PrivateKey getPrivateKey() {
	return privateKey;
    }

}
