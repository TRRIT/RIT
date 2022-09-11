package quest1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;

public class MyLinkedList<E> implements Iterable<E> {
    int size = 0;
    Node<E> head;
    Node<E> tail;

    public E add(E element) {

        Node<E> newHead = new Node<E>();
        newHead.value = element;
        if (size == 0) {
            tail = newHead;
            head = newHead;
        }
        newHead.previous = head;
        head.next = newHead;
        head = newHead;
        size++;
        return element;
    }

    public E add(int index, E element) {
        if (this.size < index) {
            throw new IllegalStateException();
        }
        Node<E> newNode = new Node<E>();
        newNode.value = element;
        if (index == 0) {
            newNode.next = tail;
            tail.previous = newNode;
            tail = newNode;
        } else {
            Node<E> nextNode = get(index);
            Node<E> previousNode = nextNode.previous;
            previousNode.next = newNode;
            nextNode.previous = newNode;
            newNode.previous = previousNode;
            newNode.next = nextNode;
        }
        size++;
        return element;

    }

    public int size() {
        return this.size;
    }

    public E getValue(int index) {

        return get(index).value;
    }

    private Node<E> get(int index) {
        if (index > size) {
            throw new IllegalStateException();
        }
        Node<E> result = tail;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> currentNode = tail;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E value = currentNode.value;
                currentNode = currentNode.next;
                return value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }


    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

    }


}
