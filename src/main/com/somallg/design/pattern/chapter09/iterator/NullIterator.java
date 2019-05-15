package com.somallg.design.pattern.chapter09.iterator;

import com.somallg.design.pattern.chapter09.composite.component.MenuComponent;

import java.util.Iterator;

public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public MenuComponent next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
