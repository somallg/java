package java.chapter05.item26;

import java.util.EmptyStackException;

/**
 * Created by somallg on 8/22/14.
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INIT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INIT_CAPACITY];
    }

    public void push(E e) {
        //ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        E result = elements[--size];
        elements[size] = null;
        return result;
    }
}
