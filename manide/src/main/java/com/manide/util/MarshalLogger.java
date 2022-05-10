package com.manide.util;

import java.util.logging.Logger;

import javax.xml.bind.Marshaller;

public class MarshalLogger extends Marshaller.Listener {
    @Override
    public void afterMarshal(Object source) {
	Logger.getLogger("Marshalling").info(source + " " + Thread.currentThread());
    }

    @Override
    public void beforeMarshal(Object source) {
	Logger.getLogger("Marshalling").info(source + " " + Thread.currentThread());
    }
}
