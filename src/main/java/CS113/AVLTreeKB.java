package CS113;

import CS113.Interfaces.Comparable;

import static java.lang.Math.max;

public class AVLTreeKB<E extends Comparable<E> & java.lang.Comparable<E>> extends BinarySearchTreeKB<E> {

    int height(Node<E> node) {
        return node != null ? node.height : -1;
    }

    private void updateHeight(Node<E> node) {
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = max(leftChildHeight, rightChildHeight) + 1;
    }

    int balanceFactor(Node<E> node) {
        return heightRecursive(node.right) - heightRecursive(node.left);
    }

    private Node<E> rotateRight(Node<E> node) {
        Node<E> childLeft = node.left;
        node.left = childLeft.right;
        childLeft.right = node;
        updateHeight(node);
        updateHeight(childLeft);
        return childLeft;
    }

    private Node<E> rotateLeft(Node<E> node) {
        Node<E> childRight = node.right;
        node.right = childRight.left;
        childRight.left = node;
        updateHeight(node);
        updateHeight(childRight);
        return childRight;
    }

    private Node<E> rebalance(Node<E> node) {
        int balanceFactor = balanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <= 0) {    // Case 1
                // Rotate right
                node = rotateRight(node);
            } else {                                // Case 2
                // Rotate left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >= 0) {    // Case 3
                // Rotate left
                node = rotateLeft(node);
            } else {                                 // Case 4
                // Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    @Override
    Node<E> insertRecursive(Node<E> node, E element) {
        node = super.insertRecursive(node, element);
        node = rebalance(node);

        if (node == null) {
            return new Node<E>(element);
        }
        if (element.compareTo(node.element) < 0) {
            node.left = insertRecursive(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = insertRecursive(node.right, element);
        } else {
            return node; // Duplicates not allowed
        }
        updateHeight(node);
        return rebalance(node);
    }

    @Override
    public boolean delete(E value) {
        if (super.delete(value)) {
            root = rebalance(root);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        return super.contains(value);
    }

    @Override
    public E findMin() {
        return super.findMin();
    }

    @Override
    public E findMax() {
        return super.findMax();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void clear() {
        super.clear();
    }
}