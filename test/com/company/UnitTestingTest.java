package com.company;

import org.junit.*;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
// https://www.youtube.com/watch?v=xHk9yGZ1z3k

public class UnitTestingTest {
    private UnitTesting test;

    // Timeout Rule:
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp() throws Exception {
        test = new UnitTesting("Rocky");
    }

    @After
    public void tearDown() throws Exception {

    }

    // Execute only once before executing the test
    @BeforeClass
    public static void beforeClass() throws Exception {

    }

    @AfterClass
    public static void afterClass() throws Exception {

    }

    @Test
    public void getName() {
        assertEquals("Rocky", test.getName());
    }

    @Test
    public void testUnHappy() throws AssertionError {
        assertFalse(test.isHappy());
    }

    @Test
    public void testHappyAfterPlay() {
        test.playWithRock();
        assertTrue(test.isHappy());
    }

    @Ignore("Exception throwing not yet defined")
    @Test(expected = IllegalStateException.class)
    public void getHappyMessageFail() {
        test.getHappyMessage();
    }

    @Test
    public void getHappyMessagePass() {
        test.playWithRock();
        String msg = test.getHappyMessage();

        assertEquals("I'm happy!", msg);
    }

    @Test
    public void testFavNumber() {
        assertEquals(0, test.getFevNumber());
    }

    @Test(expected = IllegalStateException.class)
    public void emptyNameFail() {
        UnitTesting t = new UnitTesting("");
    }

    //@Test(timeout = 100) // in ms
    @Test
    public void testWaitTillHappy() {
        test.waitTillHappy();
    }
}