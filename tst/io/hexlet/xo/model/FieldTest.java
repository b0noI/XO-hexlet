package io.hexlet.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by b0noI on 25/06/15.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

}