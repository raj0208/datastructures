package com.company;

public class RingBuffer {
    private int capacity;
    private int available;
    private int writePos;
    private int[] elements;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getWritePos() {
        return this.writePos;
    }

    public boolean put(int i) {
        if (available < capacity) {
            if (writePos >= capacity)
                writePos = 0;

            elements[writePos] = i;
            writePos++;
            available++;

            return true;
        }

        return false;
    }

    public int take() {
        if (available > 0) {
            int nextPos = writePos - available;

            if (nextPos < 0)
                nextPos += capacity;

            available--;
            return elements[nextPos];
        }

        return Integer.MIN_VALUE;
    }
}
