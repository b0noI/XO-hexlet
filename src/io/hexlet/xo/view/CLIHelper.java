package io.hexlet.xo.view;

public class CLIHelper {

    static final int screenLinesCount = 5;

    public static void cleanScreen() {
        try
        {
            for (int i = 0; i < screenLinesCount; ++i)  System.out.println("\b");
            //Runtime.getRuntime().exec("cls");
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}

