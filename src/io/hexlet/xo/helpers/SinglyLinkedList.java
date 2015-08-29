package io.hexlet.xo.helpers;

public class SinglyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element, Node<E> node) {
            this.element = element;
            this.next = node;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E getFirst() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void setFirst(E element) {
        head = new Node<>(element, head);
        if (isEmpty())
            tail = head;
        size++;
    }

    public void setLast(E element) {
        Node<E> newest = new Node<>(element, null);
        if (isEmpty())
            head = newest;
        tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E result = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty())
            tail = null;
        return result;
    }
}
