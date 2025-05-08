package CS113;

import CS113.Interfaces.DequeInterface;
import CS113.Interfaces.IterableInterface;
import CS113.Interfaces.IteratorInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Kyle Bertrand
 * ArrayDeque  Double Ended Queue
 *
 * An ArrayDeque uses a resizable circular array that allows insertion and removal from both ends in constant time.
 *
 * Some advantages are that it provides constant time performance for inserting and removing elements, it is dynamic so
 * it can accommodate any number of elements, and this is a lightweight structure for when memory is limited.
 *
 * Internally there is an Object[] array with two pointers being the head and the tail.
 *
 * Functions as a stack and queue based on method usage.
 *
 * Implements Queue and Dequeue interfaces
 *
 * Big O Time complexities
 * Insert (addFirst/addLast): O(1)
 * Remove (removeFirst/removeLast): O(1)
 * Find (via iteration): O(n)
 * Iteration: O(n)
 *
 * Some disadvantages: ArrayDeque classes are not synchroized so multiple threasa can be accessesds simultaneously,
 * which can lead to potential data corruption
 * Although resizbale, you need to create another ArrayDeque when the old one reaches capacity.
 *
 * Real World use cases involve things such as:
 * browser history (
 * back/ forward are both stacks or deques clicking forward and back moves the page between these structures )
 * undo and redo in texteditors
 * actions are pushed onto a deque as the user malkes changes, undo pops from the back and redo pushes back to the front
 * task scheduling systems
 * you can have systems that use the front of the list as higher priority and the back of the list as lower priority
 * anything involving task management such as a printer better uses deques for dynamic task urgency
 *
 * */
public class ArrayDequeCelebration<E> implements DequeInterface<E>, IterableInterface<E> {

    @Override
    public IteratorInterface<E> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator<E> implements IteratorInterface<E> {
        private int count = 0;
        private int index = first;

        @Override
        public boolean hasNext() { //checks if there are element availible
            return count < size;
        }

        @Override
        public E next() { //returns the next element in iteration
            if (!hasNext()) {throw new NoSuchElementException();}
            E element = (E) array[index];
            index = (index + 1) % array.length;
            count++;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported in ArrayDeque iterator.");
        }
    }

    //constants
    static final private int DEFAULT_SIZE = 10;
    E[] array;
    int first = -1;
    int last = -1;
    int size = 0;

    //constructor
    public ArrayDequeCelebration() {
        resize(DEFAULT_SIZE);
        first =last=-1;
        size = 0;
    }

    //resize by making new array and rearrange elements
    private void resize(int size) {
        E[] newArray = (E[]) new Object[size];
        if(array == null) {
            array = newArray;
            return;
        }
        for(int i = 0 ; i <= last; i++){
            newArray[i] = array[i];
        }
        int difference = (newArray.length - array.length);
        if(first > last){
            for(int i = array.length - 1 ; i > array.length - first; i--){
                newArray[i + difference] = array[i];
            }
        }
        array = newArray;
    }

    //adds to front if space available, else return false
    @Override
    public boolean offerFirst(E element) {
        if(size == array.length) {
            return false;
        }
        addFirst(element);
        return true;
    }

    //adds to last if space available, else return false
    @Override
    public boolean offerLast(E element) {
        if(size == array.length){
            return false;
        }
        addLast(element);
        return true;
    }

    //inserts element at front of circular array
    @Override
    public boolean addFirst(E element) {
        if(size == 0){
            first = last = 0;
            array[first] = element;
            size++;
            return true;
        }

        if(size == array.length){
            resize(size * 2);
        }

        first --;
        if(first < 0){
            first = array.length - 1;
        }
        array[first] = element;
        size++;
        return true;
    }

    //inserts element at end of circular array
    @Override
    public boolean addLast(E element) {
        if(size == 0){
            first = last = 0;
            array[last] = element;
            size++;
            return true;
        }

        if(size == array.length){
            resize(size * 2);
        }

        last++;
        if(last >= array.length){
            last = 0;
        }
        array[last] = element;
        size++;
        return true;
    }


    //reomves and returns front element
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = array[first];
        array[first] = null;
        first = (first + 1) % array.length;
        size--;
        if (isEmpty()) {
            first = last = -1;
        }
        return element;
    }

    //removes and returns last elements
    @Override
    public E removeLast() {
        if( size == 0){
            throw new NoSuchElementException();
        }
        E temp = array[last];
        array[last] = null;
        last--;
        if(last < 0){
            last = array.length - 1;
        }
        if(size == 0){
            first = last = -1;
        }
        return temp;
    }

    //returns front element without removal
    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[first];
    }

    //returns last element without removal
    @Override
    public E peekLast() {
        if(size == 0){
            return null;
        }
        return array[last];
    }

    //retrieves and removes front element, returns null if empty
    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    //retrieves and removes last element, returns null if empty
    @Override
    public E pollLast() {
        try {
            return removeLast();
        }catch(Exception e){
            return null;
        }
    }

    //check if empty
    @Override
    public boolean isEmpty() {return size == 0;}

    //returns number of elements
    @Override
    public int size() {return size;}

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = size();
        for (int i = 0; i < array.length; i++){
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    //checks the deque to see if contains certain element
    public boolean contains(E element) {
        int current = first;
        for (int i = 0; i < size; i++) {
            if (array[current] != null && array[current].equals(element)) return true;
            current = (current + 1) % array.length;
        }
        return false;
    }


}
