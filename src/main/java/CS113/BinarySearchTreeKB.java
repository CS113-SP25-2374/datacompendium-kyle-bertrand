//package CS113;
//
//import CS113.Interfaces.BinarySearchTreeInterface;
//
//public class BinarySearchTreeKB<E extends Comparable<E>> implements BinarySearchTreeInterface<E> {
//
//    class Node<E> {
//        int height;
//        E element;
//        Node<E> left;
//        Node<E> right;
//
//        Node(E element) {
//            this.element = element;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    Node<E> root;
//    int size;
//
//    public BinarySearchTreeKB() {
//        root = null;
//        size = 0;
//    }
//
//    Node<E> insertRecursive(Node<E> node, E element) {
//        if (node == null) {
//            size++;
//            return new Node<>(element);
//        }
//
//        int cmp = element.compareTo(node.element);
//        if (cmp < 0) {
//            node.left = insertRecursive(node.left, element);
//        } else if (cmp > 0) {
//            node.right = insertRecursive(node.right, element);
//        }
//        // cmp == 0, element already exists
//        return node;
//    }
//
//    @Override
//    public void insert(E value) {
//        if (value == null) {
//            throw new IllegalArgumentException("Cannot insert null value");
//        }
//        root = insertRecursive(root, value);
//    }
//
//
//    Node<E> deleteRecursive(Node<E> node,E value) {
//        if (node == null) {
//            return null;
//        }
//
//        int cmp = value.compareTo(node.element);
//        if (cmp < 0) {
//            node.left = deleteRecursive(node.left, value);
//        } else if (cmp > 0) {
//            node.right = deleteRecursive(node.right, value);
//        } else {
//            // Node to delete found
//            size--;
//
//            // Case 1: No children or one child
//            if (node.left == null) {
//                return node.right;
//            } else if (node.right == null) {
//                return node.left;
//            }
//
//            // Case 2: Two children
//            node.element = findMin(node.right).element;
//            node.right = deleteRecursive(node.right, node.element);
//        }
//        return node;
//    }
//
//    @Override
//    public boolean delete(E value) {
//        if (value == null || isEmpty()) {
//            return false;
//        }
//        int oldSize = size;
//        root = deleteRecursive(root, value);
//        return size < oldSize;
//    }
//
//    @Override
//    public boolean contains(E value) {
//        if (value == null) {
//            return false;
//        }
//
//        Node<E> current = root;
//        while (current != null) {
//            int cmp = value.compareTo(current.element);
//            if (cmp < 0) {
//                current = current.left;
//            } else if (cmp > 0) {
//                current = current.right;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Helper method to find minimum node in a subtree
//    private Node<E> findMin(Node<E> node) {
//        while (node != null && node.left != null) {
//            node = node.left;
//        }
//        return node;
//    }
//
//    @Override
//    public E findMin() {
//        if (isEmpty()) {
//            return null;
//        }
//        return findMin(root).element;
//    }
//
//    @Override
//    public E findMax() {
//        if (isEmpty()) {
//            return null;
//        }
//        Node<E> current = root;
//        while (current.right != null) {
//            current = current.right;
//        }
//        return current.element;
//    }
//
//    int heightRecursive(Node<E> node) {
//        if (node == null) {
//            return -1;  // Empty tree has height -1
//        }
//        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
//    }
//
//    @Override
//    public int height() {
//        return heightRecursive(root);
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return root == null;
//    }
//
//    @Override
//    public void clear() {
//        root = null;
//        size = 0;
//    }
//
//    String toStringRecursive(Node<E> node) {
//        if (node == null) {
//            return "";
//        }
//        String left = toStringRecursive(node.left);
//        String center = node.element.toString();
//        String right = toStringRecursive(node.right);
//
//        if (left != "") {
//            left += ", ";
//        }
//        if (right != "") {
//            center += ", ";
//        }
//
//        return left + center + right;
//    }
//
//    public String toString() {
//        return toStringRecursive(root);
//    }
//}