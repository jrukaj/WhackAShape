package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * SimpleLinkedBag class, and all its implemented methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.3.2019
 * @param <T>
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;


    /**
     * Initializes the SimpleArrayBag constructor.
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    /**
     * Adds an entry to the bag.
     * 
     * @return boolean representing if the action was carried out
     */
    @Override
    public boolean add(T anEntry) {
        // Returns false if the entry is null
        if (anEntry == null) {
            return false;
        }
        // Adds anEntry to the bag and increments numberOfEntries
        if (numberOfEntries < 25) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Gets the current size of the bag.
     * 
     * @return the current size of the bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Returns whether or not the bag is empty.
     * 
     * @return boolean representing if the bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Picks an object from the bag at random, utilizing
     * the TestableRandom class.
     * @return T Object at the random index
     */
    @Override
    public T pick() {
        TestableRandom gen = new TestableRandom();
        // Generate random number from 0 to the bag's currentSize - 1
        // Nothing to pick from, so returns null
        if (isEmpty()) {
            return null;
        }
        // Returns the Object at the random index
        else {
            int index = gen.nextInt(numberOfEntries);
            return bag[index];
        }
    }


    /**
     * Checks if the entries in the bag match the
     * parameter entry, returning the index of
     * where it was found, or -1 if there are none that are
     * equal.
     * 
     * @param anEntry
     *            the entry to be checked
     */
    private int getIndexOf(T anEntry) {
        // Checks to see if the ArrayBag is empty
        if (isEmpty()) {
            return -1;
        }
        // Checks ArrayBag contents for the first index anEntry occurs
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Removes an entry from the bag.
     * 
     * @param anEntry
     *            the entry to be removed
     * @return boolean representing whether the operation
     *         was performed
     */
    @Override
    public boolean remove(T anEntry) {
        // Returns false if the entry is not in the bag
        if (getIndexOf(anEntry) == -1) {
            return false;
        }
        // Sets the index of the entry equal to the
        // last entry in the bag, then makes the last entry null
        // and returns true
        else {
            int index = getIndexOf(anEntry);
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
    }

}
