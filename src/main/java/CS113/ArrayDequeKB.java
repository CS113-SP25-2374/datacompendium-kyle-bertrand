package CS113;

import CS113.Interfaces.DequeInterface;

import java.util.NoSuchElementException;

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
        for(int i = 0 ; i <= last; i++){
            newArray[i] = array[i];
        }

        int difference = (newArray.length - array.length);
        if(first > last) {
            for(int i = array.length -1; i > array.length - first; i--){
                newArray[i + difference] = array[i];
            }
        }
        array = newArray;
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

    @Override
    public E removeFirst() {
        return null;
    }

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

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        if(size == 0){
            return null;
        }
        return array[last];
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        try {
            return removeLast();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int size = size();
        for (int i = 0; i < array.length; i++){
            stringBuilder.append(array[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
