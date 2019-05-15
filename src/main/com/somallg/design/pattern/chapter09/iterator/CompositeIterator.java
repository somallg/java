package com.somallg.design.pattern.chapter09.iterator;

import com.somallg.design.pattern.chapter09.composite.component.MenuComponent;
import com.somallg.design.pattern.chapter09.composite.component.impl.Menu;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {

    Stack<Iterator<MenuComponent>> stack = new Stack();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent component = iterator.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }

            return component;
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }

        Iterator<MenuComponent> iterator = stack.peek();
        if (!iterator.hasNext()) {
            stack.pop();
            return hasNext();
        } else {
            return true;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
