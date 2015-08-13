package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;


public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerCustomRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final int fieldSize = new Random().nextInt(50);
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            for (int j=0 ; j<fieldSize; j++) {
                field.setFigure(new Point(i, j), Figure.X);
            }
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerCustomRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final int fieldSize = new Random().nextInt(50);
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            field.setFigure(new Point(i, 0), Figure.O);
            for (int j=1 ; j<fieldSize; j++) {
                field.setFigure(new Point(i, j), Figure.X);
            }
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerCustomColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final int fieldSize = new Random().nextInt(50);
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            for (int j=0 ; j<fieldSize; j++) {
                field.setFigure(new Point(j, i), Figure.X);
            }
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerCustomColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        int fieldSize = new Random().nextInt(50);
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            field.setFigure(new Point(0, i), Figure.O);
            for (int j=1 ; j<fieldSize; j++) {
                field.setFigure(new Point(j, i), Figure.X);
            }
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }
    @Test
    public void testGetWinnerWhenWinnerCustomDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        int i = new Random().nextInt(50);
        final Field field = new Field(i);
        for (int j=0;j<i;j++){
            field.setFigure(new Point(j, j), Figure.O);
        }
        assertEquals(Figure.O, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerCustomDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final int fieldSize = new Random().nextInt(50);
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.X);
        for (int j=1 ; j<fieldSize ; j++){
            field.setFigure(new Point(j, j), Figure.O);
        }
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerCustomDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final int fieldSize = new Random().nextInt(50);
        final Field field = new Field(fieldSize);
        for (int j=0 ; j<fieldSize ; j++){
            field.setFigure(new Point(fieldSize-1-j, j), Figure.X);
        }
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnercustomDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final int fieldSize = new Random().nextInt(50);
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.O);
        for (int j=1 ; j<fieldSize ; j++){
            field.setFigure(new Point(fieldSize-1-j, j), Figure.X);
        }
        assertNull(winnerController.getWinner(field));
    }

}