package io.hexlet.xo.view;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.*;

public class LanternaView {

    private static final Screen screen = TerminalFacade.createScreen();

    public static void uiStart(){

        screen.startScreen();

    }

    public static void uiStop(){

        screen.stopScreen();

    }

    public static void uiClearScreen() {

        screen.clear();

    }

    public static void uiPrint(final String out, final int screenColumn, final int screenRow) {

        screen.putString(screenColumn, screenRow, out, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.refresh();
    }

    public static void uiShowGameName() {
        uiPrint("XO", screen.getTerminalSize().getColumns() / 2, 4);

    }

}


