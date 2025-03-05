package CS113;

import CS113.Interfaces.StackInterface;

import java.util.Stack;

public class StackKB<E> extends ArrayListKB<E> implements StackInterface<E> {

    @Override
    public boolean empty() {
        return this.isEmpty();
    }

    @Override
    public E peek() {
        return this.get(this.size() - 1);
    }

    @Override
    public E pop() {
        E temp = this.get(this.size() - 1);
        this.remove(this.size() - 1);
        return temp;
    }

    @Override
    public boolean push(E element) {
        return this.add(element);
    }

    @Override
    public int search(Object o) {
        return indexOf(o);
    }
}
