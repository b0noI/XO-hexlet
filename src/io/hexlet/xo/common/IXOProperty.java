package io.hexlet.xo.common;

import io.hexlet.xo.model.exceptions.XOCriticalException;

import java.io.IOException;

public interface IXOProperty {

    public Character getSeparatorCharacter();

    static IXOProperty getDefaultProperties() {
        try {
            return FileBasedXOProperty.generateInstance();
        } catch (final IOException e) {
            e.printStackTrace();
            throw new XOCriticalException(e);
        }
    }

}
