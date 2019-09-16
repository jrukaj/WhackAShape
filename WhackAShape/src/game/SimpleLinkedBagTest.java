package game;

import student.TestCase;
import student.TestableRandom;

/**
 * Tests the SimpleLinkedBag class and all its
 * associated methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.3.2019
 */
public class SimpleLinkedBagTest extends TestCase {
    
    private SimpleLinkedBag<String> linkedBag;
    private SimpleLinkedBag<String> emptyBag;
    
    /**
     * Sets up the conditions to be called before 
     * the test cases.
     */
    public void setUp() {
        linkedBag = new SimpleLinkedBag<String>();
        emptyBag = new SimpleLinkedBag<String>();
    }
    
    /**
     * Tests the isEmpty() method.
     */
    public void testIsEmpty() {
        assertTrue(emptyBag.isEmpty());
        linkedBag.add("Add me!");
        assertFalse(linkedBag.isEmpty());
        assertFalse(emptyBag.remove("remove me!"));
    }
    
    /**
     * Tests the getCurrentSize() method.
     */
    public void testGetCurrentSize() {
        assertEquals(0, emptyBag.getCurrentSize());
        linkedBag.add("Not empty!");
        assertEquals(1, linkedBag.getCurrentSize());
        for (int i = 0; i < 5; i++)
        {
            linkedBag.add("Copies!");
        }
        assertEquals(6, linkedBag.getCurrentSize());
    }
    
    /**
     * Tests the add() method.
     */
    public void testAdd() {
        assertFalse(emptyBag.add(null));
        for (int i = 0; i < 20; i++)
        {
            assertTrue(linkedBag.add("Add me!"));
        }
    }
    
    /**
     * Tests the pick() method.
     */
    public void testPick() {
        assertNull(emptyBag.pick());
        linkedBag.add("Number 1");
        linkedBag.add("Number 2");
        linkedBag.add("Number 3");
        TestableRandom.setNextInts(0, 1, 2);
        assertEquals("Number 3", linkedBag.pick());
        assertEquals("Number 2", linkedBag.pick());
        assertEquals("Number 1", linkedBag.pick());
    }
    
    /**
     * Tests the remove() method.
     */
    public void testRemove() {
        assertFalse(emptyBag.remove("Empty"));
        linkedBag.add("Remove me!");
        assertFalse(linkedBag.remove("Apples"));
        assertTrue(linkedBag.remove("Remove me!"));
    }

}
