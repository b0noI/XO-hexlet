package io.hexlet.xo.helpers;

public class LinkedQueue<E>{

    private SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();

    public LinkedQueue() {
    }

    public int getSize() {
        return singlyLinkedList.getSize();
    }

    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    public void enqueue(E element) {
        singlyLinkedList.setLast(element);
    }

    public E dequeue() {
        return singlyLinkedList.removeFirst();
    }
}
