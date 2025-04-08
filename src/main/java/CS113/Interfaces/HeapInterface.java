package CS113.Interfaces;

public interface HeapInterface<E extends Comparable<E>> {
    /**
     * Adds an element to the queue
     * @param element
     * @return true if it adds
     */
    boolean add(E element);

    /**
     * Retrieves but does not remove th
     * e head
     * @return an element
     */
    E peek();

    /**
     * Retrieves and returns the head of the queue
     * @return an element
     */
    E poll();
}