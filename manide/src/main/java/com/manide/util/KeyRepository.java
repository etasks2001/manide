package com.manide.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import com.manide.exception.ManideException;

public class KeyRepository {

    private KeyStore keyStore;
    private PrivateKey privateKey;

    private X509Certificate certificado;

    public KeyRepository(String pathName, char[] password) {
	try {
	    keyStore = KeyStore.getInstance("PKCS12");
	    keyStore.load(new FileInputStream(new File(pathName)), password);

	    String alias = null;
	    Enumeration<String> aliases = keyStore.aliases();

	    while (aliases.hasMoreElements()) {
		alias = aliases.nextElement();
	    }
	    certificado = (X509Certificate) keyStore.getCertificate(alias);

	    privateKey = (PrivateKey) keyStore.getKey(alias, password);
	} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
	    throw new ManideException("Verifique o seu certificado. Pode ser caminho, senha ou nome.");
	}

    }

    public X509Certificate getCertificado() {
	return certificado;
    }

    public PrivateKey getPrivateKey() {
	return privateKey;
    }
}