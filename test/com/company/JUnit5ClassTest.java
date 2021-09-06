package com.company;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnit5ClassTest {
    @Test
    void testObjectCreation() {
        JUnit5Class test = new JUnit5Class("water", 75.0);
        assertEquals("water", test.getLiquidType());
        assertEquals(75, test.getPercentFull(), 0.001);
    }

    @Test
    void testObjectCreationviaAssertAll() {
        JUnit5Class test = new JUnit5Class("water", 75.0);
        assertAll("Currently builds object",
                () -> assertEquals("water1", test.getLiquidType()),
                () -> assertEquals(75.232, test.getPercentFull(), 0.001)
        );
    }

    @Disabled("Disabled test until happy")
    @Test
    void testIsEmpty() {
        JUnit5Class test = new JUnit5Class("water", 75.0);
        assertFalse(test.isEmpty());
    }

    @Test
    void testSetBadPercentThrows() {
        JUnit5Class test = new JUnit5Class("water", 75);
        assertThrows(IllegalArgumentException.class,
                () -> test.setPercentFull(-1)
        );
    }
}