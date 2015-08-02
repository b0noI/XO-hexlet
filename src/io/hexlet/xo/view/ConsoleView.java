package io.hexlet.xo.view;


import io.hexlet.xo.common.IXOProperty;
import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.view.reader.ConsoleCoordinateReader;


public class ConsoleView {

    private static final Character separator = IXOProperty.getDefaultProperties().getSeparatorCharacter();

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    private final ConsoleCoordinateReader coordinateReader = new ConsoleCoordinateReader();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            System.out.println(generateLine(field, x));
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(coordinateReader.askCoordinate("X") - 1, coordinateReader.askCoordinate("Y") - 1);
    }

    private String generateLine(final Field field,
                                final int x) {
        String resultLine = "";
        for (int y = 0; y < field.getSize(); y++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            String leftFigureWall = (y != 0 ? "|" : "");
            String figureSymbol = String.format("%s", figure != null ? figure : " ");
            String figureCell = String.format("%s%2s ", leftFigureWall, figureSymbol);
            resultLine = resultLine.concat(figureCell);
        }
        return resultLine;
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}
