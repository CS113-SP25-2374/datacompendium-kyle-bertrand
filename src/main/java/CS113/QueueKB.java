package CS113;

import CS113.Interfaces.DequeInterface;
import CS113.Interfaces.QueueInterface;

import java.util.Queue;
public class QueueKB<E> implements QueueInterface<E> {

    DequeInterface<E> dataStructure;
   public QueueKB(DequeInterface<E> dataStructure) {
       this.dataStructure = dataStructure;
   }

    @Override
    public boolean add(E element) {
        return this.dataStructure.addLast(element);
    }

    @Override
    public E element() {
        return this.dataStructure.peekFirst();
    }

    @Override
    public boolean offer(E element) {
        return this.dataStructure.offerLast(element);
    }

    @Override
    public E peek() {
        return this.dataStructure.peekFirst();
    }

    @Override
    public E poll() {
        return this.dataStructure.pollFirst();
    }

    @Override
    public E remove() {
        return this.dataStructure.removeFirst();
    }
}
