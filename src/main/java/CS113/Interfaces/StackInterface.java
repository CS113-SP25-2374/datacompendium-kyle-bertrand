package CS113.Interfaces;

public interface StackInterface<E>{
    /**
     * Tests if the stack is empty
     * @return true if empty
     */
    boolean empty();

    /**
     * Looks at the object at the top of the stack
     * @return the object
     */
    E peek();

    /**
     * Removes the object at the top of the stack (and returns it)
     * @return returns and removes the object
     */
    E pop();

    /**
     * Pushes an item on top of a stack (and returns it)
     * @return The item
     */
    boolean push(E element);

    /**
     * Returns the 1-based position where an object is on a stack
     * @param o
     * @return
     */
    int search(Object o);
}
