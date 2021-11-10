package com.company;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RingBufferTest {
    private RingBuffer ringBuffer;

    @Before
    public void setup() {
    }

    @Test
    public void testPut() {
        this.ringBuffer = new RingBuffer(1);
        assertTrue(this.ringBuffer.put(4));
        assertFalse(this.ringBuffer.put(1));
        this.ringBuffer.take();
        assertTrue(this.ringBuffer.put(4));
    }

    @Test
    public void testCapacity() {
        this.ringBuffer = new RingBuffer(5);
        assertEquals(5, this.ringBuffer.getCapacity());
    }

    @Test
    public void testTake() {
        this.ringBuffer = new RingBuffer((1));
        //this.ringBuffer.put(1);
        //assertEquals(1, this.ringBuffer.take());
        assertEquals(Integer.MIN_VALUE, this.ringBuffer.take());
        assertEquals(0, this.ringBuffer.getWritePos());
        assertEquals(0, this.ringBuffer.getAvailable());

        this.ringBuffer = new RingBuffer(2);
        this.ringBuffer.put(1);
        this.ringBuffer.put(2);
        this.ringBuffer.take();
        this.ringBuffer.put(3);
        assertEquals(2, ringBuffer.take());
    }



}
