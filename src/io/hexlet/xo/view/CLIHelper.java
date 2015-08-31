package io.hexlet.xo.view;

public class CLIHelper {

    static final int screenLinesCount = 100;

    public static void cleanScreenDefault() {

            for (int i = 0; i < screenLinesCount; ++i)  System.out.println();

    }

}


