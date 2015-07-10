package io.hexlet.xo;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

import java.util.Scanner;

public class XOCLI {

    static int nameCount = 1;
    public static void main(final String[] args) {
        final String name1 = playerInput();
        final String name2 = playerInput();

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while(consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

    static String playerInput() {
        Scanner sc = new Scanner(System.in);
        System.out.format("Enter Player %s  name: ", nameCount);
        String name = sc.nextLine();
        nameCount++;
        return name;
    }

}

