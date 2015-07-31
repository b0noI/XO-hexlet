package io.hexlet.xo.model;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Game implements Iterable<Player> {

    private final Player[] players;

    private final Field field;

    private final String name;

    public Game(final Player[] players,
                final Field field,
                final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            return Game.this.players[index++];
        }

    }

}
