package CS113;

import CS113.Interfaces.DequeInterface;

public class ArrayDequeKB<E> implements DequeInterface<E> {
    static final private int DEFAULT_SIZE = 10;
    E[] array;
    int first = -1;
    int last = -1;
    int size = 0;

    public ArrayDequeKB(){
        resize(DEFAULT_SIZE);
        first = last = -1;
        size =0;
    }

    private void resize(int size){
        E[] newArray = (E[]) new Object[size];
        if(array == null){
            array = newArray;
            return;
        }
        //otherwise resize
        for(int i = 0 ; i < array.length; i++){
            newArray[i] = array[i];
        }

        int difference = (newArray.length - array.length);
        if(first > last) {
            for(int i = array.length -1; i > array.length - first; i--){
                newArray[i + difference] = array[i];
            }
        }
    }

    @Override
    public boolean offerFirst(E element) {
        if(size == array.length) {
            return false;
        }
        addFirst(element);
        return true;
    }

    @Override
    public boolean offerLast(E element) {
       if(size == array.length){
           return false;
       }
       addLast(element);
       return true;
    }

    @Override
    public boolean addFirst(E element) {


        return false;
    }

    @Override
    public boolean addLast(E element) {

        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
