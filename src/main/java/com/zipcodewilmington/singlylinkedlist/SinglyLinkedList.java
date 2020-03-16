package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    private static int counter;
    private Node<T> head;

    public class Node<E> {
        Node<T> next;
        E data;

        public Node(E dataValue) {
            this.next = null;
            this.data = dataValue;
        }

        public Node(E dataValue, Node<T> nextValue) {
            this.next = nextValue;
            this.data = dataValue;
        }

        public E getData() {
            return this.data;
        }

        public void setData(E dataValue) {
            this.data = dataValue;
        }

        public Node<T> getNext() { return next; }

        public void setNext(Node<T> nextValue) { this.next = nextValue; }
    }

    public SinglyLinkedList() {

    }

    public void add(T data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node<T>(data);
        }

        Node<T> temp = new Node<T>(data);
        Node<T> current = head;

        if (current != null) {


            while (current.getNext() != null) {
                current = current.getNext();
            }
            // the last node's "next" reference set to new node
            current.setNext(temp);
        }
        incrementCounter();
    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() { counter++; }

    private void decrementCounter() { counter--; }

    public int size() { return getCounter(); }


    public void add(T data, int index) {
        Node<T> temp = new Node<T>(data);
        Node<T> current = head;

        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }

        temp.setNext(current.getNext());
        current.setNext(temp);
        incrementCounter();
    }

    public Object get(int index) {
        if (index < 0) return null;

        Node<T> current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) return null;
                current = current.getNext();
            }
            return current.getData();

        }
        return current;
    }

    public boolean remove(int index) {
        if (index < 1 || index > size()) return false;
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) return false;
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            decrementCounter();
            return true;
        }
        return false;
    }

    public String toString() {
        String output = "";
        if (head != null) {
            Node<T> current = head.getNext();
            while (current != null) {
                output += "[" + current.getData().toString() + "]";
                current = current.getNext();
            }
        }
        return output;
    }
}
