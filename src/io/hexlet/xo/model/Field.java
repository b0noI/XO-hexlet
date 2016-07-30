package io.hexlet.xo.model;


import io.hexlet.xo.model.exceptions.InvalidPointException;


public class Field<T> {

    private static final int MIN_COORDINATE = 0;

    private final T[][] field;

    private final int filedSize;

    public Field(final int filedSize) {
        this.filedSize = filedSize;
        field = (T[][])new Object[filedSize][filedSize];
    }

    public int getSize() {
        return filedSize;
    }

    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final T figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX(), field.length) && checkCoordinate(point.getY(), field[point.getX()].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

    public static void main(String[] args) throws InvalidPointException {
        Field<Figure> xoField = new Field<>(3);
        xoField.setFigure(new Point(1, 1), Figure.O);
        Field<String> chField = new Field<>(8);
        chField.setFigure(new Point(2, 2), "figure1");
    }

}
