package CS113.Interfaces;

public interface BinarySearchTreeInterface<E extends Comparable<E>> {
    // Insert a value into the BST
    void insert(E value);

    boolean delete(E value);

    boolean contains(E value);

    // Find the minimum value in the BST
    E findMin();

    // Find the maximum value in the BST
    E findMax();

    // Get the height of the BST
    int height();

    // Check if the BST is empty
    boolean isEmpty();

    // Clear the BST
    void clear();

