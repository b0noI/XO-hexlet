package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GenerateConsoleLineTest {

    private ConsoleView consoleView;

    @Before
    public void createConsoleView() throws Exception {
        consoleView = new ConsoleView();
    }

    @Test
    public void testLineFormatWithElement() throws Exception {
        final String line = " O |   |   ";

        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);

        assertEquals("Line format", line, consoleView.generateLine(field, 1));
    }


    @Test
    public void testLineFormatWith2Elements() throws Exception {
        final String line = " O |   | X ";

        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(2, 1), Figure.X);

        assertEquals("Line format", line, consoleView.generateLine(field, 1));
    }

    @Test
    public void testLineFormatWith3Elements() throws Exception {
        final String line = " O | X | X ";

        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);

        assertEquals("Line format", line, consoleView.generateLine(field, 1));
    }


    @Test
    public void testArgumentFieldIsNull() throws Exception {
        try {
            consoleView.generateLine(null, 1);
        } catch (Exception ex) {
            fail("Program is failed, because argument 'field' is null");
        }
    }

    @Test
    public void testArgumentLineNumberIsInvalid() throws Exception {
        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);

        try {
            consoleView.generateLine(field, -1);
        } catch (Exception ex) {
            fail("Program is failed, because argument 'line number' has value '-1'");
        }
    }

    @Test
    public void testArgumentsFieldAndLineNumberAreInvalid() throws Exception {
        try {
            consoleView.generateLine(null, -1);
        } catch (Exception ex) {
            fail("Program is failed, because argument 'field' is null or argument 'line number' has value '-1'");
        }
    }

}
