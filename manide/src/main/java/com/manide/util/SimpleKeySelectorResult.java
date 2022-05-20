package com.manide.util;

import java.security.Key;
import java.security.PublicKey;

import javax.xml.crypto.KeySelectorResult;

public class SimpleKeySelectorResult implements KeySelectorResult {
    private PublicKey a;

    SimpleKeySelectorResult(PublicKey pk) {
	this.a = pk;
    }

    public Key getKey() {
	return this.a;
    }
}
