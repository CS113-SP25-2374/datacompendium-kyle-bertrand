package CS113;

import CS113.Interfaces.IterableInterface;
import CS113.Interfaces.IteratorInterface;
import CS113.Interfaces.ListInterface;

public class LinkedListKB<E> implements ListInterface<E>, IterableInterface<E> {


    private class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        private Node(E element){
            this.element = element;
        }
    }

    private Node<E> getIndex(int index){
        if(index >= size || index < 0){throw new IndexOutOfBoundsException();}

        Node<E> curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr;
    }

    private class Iterator<E> implements IteratorInterface<E> {
        LinkedListKB<E>.Node<E> curr;
        LinkedListKB<E> list;

        private Iterator(LinkedListKB<E> parentList){
            list = parentList;
            curr = list.head;
        }
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            LinkedListKB<E>.Node<E> temp = curr;
            curr = curr.next;
            return temp.element;
        }

        @Override
        public void remove() {
            if(list.head == null)throw new IllegalStateException();

            if(curr != null){
                list.unlink(curr.prev);
            }else{list.unlink(list.tail);}
        }
    }

    Node<E> head;
    Node<E> tail;
    int size;


    private void unlink(Node<E> node){
        Node<E> curr = node;
        Node<E> prev = curr.prev;
        Node<E> next = curr.next;
        size--;

        if(curr == head ){
            head = curr.next;
        }
        if(curr == tail){
            tail = curr.prev;
        }
        if(prev != null){
            prev.next = next;
        }
        if(next != null){
            next.prev = prev;
        }

    }

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        size++;

        if (head == null) {
            head = tail = node;
            return true;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;

        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = new Node<>(element);
        Node<E> curr = getIndex(index);
        size++;

        node.next = curr.next;
        curr.next = node;
        node.prev = curr;
        if(node.next!=null){
            node.next.prev = node;
        }
    }

    @Override
    public void clear() {
        Node<E> curr = head;
        while(curr != null){
            Node<E> next = curr.next;
            unlink(curr);
            curr = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        Node<E> curr = head;
        while(curr != tail) {
            curr = curr.next;
            if (curr.element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
      unlink(getIndex(index));
      return true;
    }

    @Override
    public boolean remove(E element) {
        Node<E> node = new Node<>(element);
        while(!isEmpty()) {
            if (node.element.equals(element)) {
                unlink(node);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public IteratorInterface<E> iterator() {
        return new Iterator<>(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int size = size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(getIndex(i).element);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
