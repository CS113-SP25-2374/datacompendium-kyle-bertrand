package CS113.Interfaces;

public interface QueueInterface<E>{
    /**
     * Adds an element to the queue
     * @param element
     * @return true if it adds
     */
    boolean add(E element);

    /**
     * Returns but does not remove the head of the queue
     * @return
     */
    E element();

    /**
     * Attempts to add an element to the queue
     * @param element
     * @return true if it fits
     */
    boolean offer(E element);

    /**
     * Retrieves but does not remove the head
     * @return an element
     */
    E peek();

    /**
     * Retrieves and returns the head of the queue
     * @return an element
     */
    E poll();

    /**
     * Retrieves and returns the head of the queue
     * @return an element
     */
    E remove();
}
