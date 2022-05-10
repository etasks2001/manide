package com.manide.util;

import java.util.logging.Logger;

import javax.xml.bind.Unmarshaller;

public class UnmarshalLogger extends Unmarshaller.Listener {
    @Override
    public void afterUnmarshal(Object target, Object parent) {
	Logger.getLogger("Unmarshalling").info(target + " " + Thread.currentThread());
    }

    @Override
    public void beforeUnmarshal(Object target, Object parent) {
	Logger.getLogger("Unmarshalling").info(target + " " + Thread.currentThread());
    }
}