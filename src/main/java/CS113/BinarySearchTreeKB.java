package CS113;

import CS113.Interfaces.BinarySearchTreeInterface;
import CS113.Interfaces.Comparable;

public class BinarySearchTreeKB<E extends Comparable<E>> implements BinarySearchTreeInterface<E> {

    private class Node<E>
    {
        E data;
        Node<E> left, right;

        public Node(E data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node<E> root;

    private Node<E> insertRecursive(Node<E> node, E data){
        if(node == null){
            return new Node<E>(data);
        }
        if(data.compareTo(node.data) > 0 ){
             node.left = insertRecursive(node.left, data);
        }
        if(data.compareTo(node.data) < 0){
            node.right = insertRecursive(node.right, data);
        }
        return node;
    }

    @Override
    public void insert(E data) {
        root = insertRecursive(root, data);
    }

    @Override
    public boolean delete(E value) {
        return false;
    }

    private Node<E> deleteRecursive(Node<E> node, E data){

        if(node == null) return null;

        if(node.data == data){
            Node<E> replace = null;
            if(heightRecursive(node) == 1) {return null;}
            if(heightRecursive(node.right) > heightRecursive(node.left)){
                replace = findMinRecrusive(node.right);
            }
            else{
                replace = findMaxRecrusive(node.left);
            }
            deleteRecursive(node, replace.data);

            replace.left = node.left;
            replace.right = node.right;
            return replace;
        }
        if(node.data.compareTo(data)> 0){
            node.left = deleteRecursive(node.left,data);
        }
        if(node.data.compareTo(data) < 0 ){
            node.right = deleteRecursive(node.right , data);
        }
        return node;
    }

    @Override
    public boolean contains(E value){
        return recurseContains(root,value);
    }
    private boolean recurseContains(Node<E> node, E data) {
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        return recurseContains(node.left, data)|| recurseContains(node.right, data);
    }

    Node<E> findMinRecrusive(Node<E> node){
        if(node.left == null) return node;
        return findMaxRecrusive(node.left);
    }

    @Override
    public E findMin() {
        return findMinRecrusive(root).data;
    }

    Node<E> findMaxRecrusive(Node<E> node){
        if(node.right == null) return node;
        return findMaxRecrusive(node.right);
    }

    @Override
    public E findMax() {
        return findMaxRecrusive(root).data;
    }

    @Override
    public int height() {
        return heightRecursive(root);
    }

    int heightRecursive(Node<E> node){
        if(node == null) return 0;

        return 1 + Integer.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    @Override
    public boolean isEmpty() {
        //add code
        return false;
    }

    @Override
    public void clear() {
        //add code
    }

    public String toString(){
        return toStringRecursive(root);
    }
    public String toStringRecursive(Node<E> node) {
        if (node == null) {
            return "";
        }
        String left = toStringRecursive(node.left);
        String center = node.data.toString();
        String right = toStringRecursive(node.right);
        return left + center + right;
    }


}
