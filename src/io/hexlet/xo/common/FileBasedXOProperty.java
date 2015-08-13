package io.hexlet.xo.common;

import java.io.*;
import java.util.Properties;

class FileBasedXOProperty implements IXOProperty {

    private static final String PROPERTY_FILE = "xo.property";

    private static final String SEPARATOR_KEY = "separator";

    private final Properties properties;

    public static IXOProperty generateInstance() throws IOException {
        final Properties properties = new Properties();
        try (final InputStream is = FileBasedXOProperty.class.getResourceAsStream(PROPERTY_FILE)) {
            properties.load(is);
        } catch (IOException ex) {
            System.out.println(String.format("Something wrong with file: %s! Please, check!", PROPERTY_FILE));
        }
        return new FileBasedXOProperty(properties);
    }

    private FileBasedXOProperty(final Properties properties) {
        this.properties = properties;
    }

    @Override
    public Character getSeparatorCharacter() {
        return this.properties.getProperty(SEPARATOR_KEY).charAt(0);
    }

}
