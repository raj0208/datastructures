package com.company;

import java.util.Arrays;

public class Set {
    private int count;
    private Object[] data;

    public Set() {
        this(5);
    }

    public Set(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity should be greater than zero");

        this.data = new Object[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(Object value) {
        if (contains(value)) return;

        if (data.length == count) {
            Object[] t = new Object[count * 2 + 1];
            Arrays.copyOfRange(data, 0, data.length - 1);
            data = t;
        }

        data[count] = value;
        count++;
    }

    public int size() {
        return count;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < count; i++) {
            if (value.equals(data[i]))
                return true;
        }

        return false;
    }

    public boolean remove(Object value) {
        if (contains(value)) {
            boolean found = false;

            for(int i = 0; i < count; i++) {
                if (found) {
                    data[i - 1] = data[i];
                    continue;
                }
                if (value.equals(data[i])) {
                    found = true;
                }
            }
            count--;

            return true;
        }

        return false;
    }
}
