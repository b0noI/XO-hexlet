package io.hexlet.xo.helpers;

import javafx.geometry.Pos;

import java.util.Iterator;

public class GeneralLinkedTree<E> {

    private static class Position<E> {

        private E element;
        private Position<E> prev;
        private Position<E> next;

        public Position(E element, Position<E> prev, Position<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() throws IllegalStateException{
            if (next.equals(null))
                throw new IllegalStateException("Position invalid");
            return element;
        }

        public Position<E> getPrev() {
            return prev;
        }

        public Position<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrev(Position<E> prev) {
            this.prev = prev;
        }

        public void setNext(Position<E> next) {
            this.next = next;
        }
    }

    public Position<E> getRoot{
        return;
    }

    public Position<E> getParent (Position<E> position) throws IllegalArgumentException;

    public Iterable<Position<E>> getChildren(Position<E> position) throws IllegalArgumentException;

    public int getNumChildren(Position<E> position) throws IllegalArgumentException;

    public boolean isEnternal(Position<E> position) throws IllegalArgumentException{
        return getNumChildren(position) > 0;
    }

    public boolean isExternal(Position<E> position) throws IllegalArgumentException{
        return getNumChildren(position) == 0;
    }

    public boolean isRoot(Position<E> position) throws IllegalArgumentException{
        return position.equals(getRoot());
    }

    public int getSize() {

    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public Iterator<E> iterator();

    public Iterable<Position<E>> getPositions();




}
