package game;

import bag.SimpleBagInterface;
import student.TestableRandom;
import bag.Node;

/**
 * SimpleLinkedBag class, and all its implemented methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.3.2019
 * @param <T>
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;


    /**
     * Initializes the SimpleLinkedBag() constructor.
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * Adds an entry to the bag.
     * 
     * @param anEntry
     *            the entry data
     * @return boolean representing if the action was carried out
     */
    @Override
    public boolean add(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        else {
            Node<T> currentNode = new Node(anEntry);
            currentNode.setNext(firstNode);
            firstNode = currentNode;
            numberOfEntries++;
            return true;
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
     * 
     * @return T Object at the random index
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        else {
            TestableRandom gen = new TestableRandom();
            int index = gen.nextInt(numberOfEntries);
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                if (currentNode == null) {
                    return null;
                }
                currentNode = currentNode.next();
            }
            return currentNode.data();
        }
    }


    /**
     * Searches for the entry specified.
     * 
     * @param anEntry
     *            the specified entry
     * @return T the Node
     */
    public Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        return currentNode;
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
        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        if (isEmpty()) {
            return false;
        }
        else {
            firstNode = getReferenceTo(anEntry).next();
            numberOfEntries--;
            return true;
        }
    }

}
