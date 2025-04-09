package CS113;

import CS113.Interfaces.Comparable;
import CS113.Interfaces.HeapInterface;

public class PriorityQueueKB<E extends Comparable<E>> implements HeapInterface<E> {

    ArrayListKB<E> array = new ArrayListKB<>();
    void heapifyUp(E element, int index) {
        if(index <= 0){
            return;
        }
        int parentIndex = (index -1) / 2;
        E parent = array.get(parentIndex);

        if(element.compareTo(parent) < 0){
            array.set(parentIndex, element);
            array.set(index, parent);
            heapifyUp(element, parentIndex);
        }
    }

    void heapifyDown(E element, int index) {
        int childLeftIndex = (index*2) +1;
        int childRightIndex = (index*2) + 2;
        int smallestIndex = index;

        if(childLeftIndex < array.size()){
            smallestIndex = childLeftIndex;
        }else if (childRightIndex < array.size()){
            smallestIndex = childRightIndex;
        }
        if(smallestIndex == index){return;}

        E smallestValue = array.get(smallestIndex);

        if(element.compareTo(smallestValue) > 0){
            array.set(index, smallestValue);
            array.set(smallestIndex, element);
            heapifyDown(element ,smallestIndex);
        }

    }

    @Override
    public boolean add(E element) {
        array.add(element);
        heapifyUp(element, array.size() - 1);
        return true;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E poll() {
        E first = array.get(0);
        E last = array.get(array.size() - 1);
        array.set(0, last);
        array.remove(array.size() - 1);
        heapifyDown(last, 0);
        return first;
    }
}
