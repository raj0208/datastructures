package com.company;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SetTest {
    private Set empty = new Set();
    private Set hasOne = new Set();
    private Set hasMany = new Set();

    public void setup() {
        hasOne.add(1);
        hasMany.add(1);
        hasMany.add(2);
        hasMany.add(3);
    }

    @Test
    public void testIsEmpty() {
        setup();
        assertEquals(true, empty.isEmpty());
        assertEquals(false, hasOne.isEmpty());
        assertEquals(false, hasMany.isEmpty());
    }

    @Test
    public void testAddItem() {
        setup();
        assertEquals(1, hasOne.size());
        assertEquals(3, hasMany.size());
    }

    @Test
    public void testContains() {
        setup();
        assertEquals(true, hasOne.contains(1));
        assertEquals(true, hasMany.contains(2));
        assertEquals(false, hasMany.contains(10));
    }

    @Test
    public void testCanGrow() {
        assertThrows(IllegalArgumentException.class, () -> { new Set(0); });
        Set s = new Set(1);
        for (int i = 0; i < 10; i++) {
            s.add(i);
        }
        assertEquals(10, s.size());
    }

    @Test
    public void testRemove() {
        Set s = new Set(1);
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        assertTrue(s.remove(2));
        assertTrue(s.remove(1));
        assertTrue(s.remove(3));
        assertTrue(s.remove(4));
        assertFalse(s.remove(5));
    }
}