package game;

import student.TestCase;
import student.TestableRandom;

/**
 * Tests the SimpleArrayBag class and all its
 * associated methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.3.2019
 */
public class SimpleArrayBagTest extends TestCase {

    private SimpleArrayBag<String> bag;


    /**
     * Sets up the test methods, initializing
     * a SimpleArrayBag object.
     */
    public void setUp() {
        bag = new SimpleArrayBag<String>();
    }


    /**
     * Tests the add() method.
     */
    public void testAdd() {
        String str1 = "True";
        String str2 = null;
        String str3 = "Yes";
        for (int i = 0; i < 12; i++) {
            bag.add(str1);
            bag.add(str3);
        }
        assertTrue(bag.add(str1));
        assertFalse(bag.add(str2));
        assertFalse(bag.add(str3));
    }


    /**
     * Tests the getCurrentSize() method.
     */
    public void testGetCurrentSize() {
        assertEquals(0, bag.getCurrentSize());
        String str = "Add me!";
        for (int i = 0; i < 10; i++) {
            bag.add(str);
        }
        assertEquals(10, bag.getCurrentSize());
    }


    /**
     * Tests the isEmpty() method.
     */
    public void testIsEmpty() {
        SimpleArrayBag<String> bag2 = new SimpleArrayBag<String>();
        String str = "not empty";
        bag.add(str);
        assertTrue(bag2.isEmpty());
        assertFalse(bag2.remove("not here"));
        assertFalse(bag.isEmpty());
    }


    /**
     * Tests the pick() method.
     */
    public void testPick() {
        SimpleArrayBag<String> bag2 = new SimpleArrayBag<String>();
        assertNull(bag2.pick());
        TestableRandom.setNextInts(0, 1, 2);
        String str = "str";
        String str2 = "str2";
        String str3 = "str3";
        bag.add(str);
        bag.add(str2);
        bag.add(str3);
        assertEquals("str", bag.pick());
        assertEquals("str2", bag.pick());
        assertEquals("str3", bag.pick());

    }


    /**
     * Tests the remove() method.
     */
    public void testRemove() {
        String str = "str";
        String str2 = "str2";
        String str3 = "str3";
        bag.add(str);
        bag.add(str2);
        bag.add(str3);
        assertFalse(bag.remove("0"));
        assertTrue(bag.remove("str2"));
    }
}
