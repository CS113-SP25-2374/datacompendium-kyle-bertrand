package CS113;

import CS113.Interfaces.IterableInterface;
import CS113.Interfaces.IteratorInterface;

public class Main {
    public static void main(String[] args) {

        ArrayDequeCelebration<String> deque = new ArrayDequeCelebration<>();

        //insert demonstration

        deque.addFirst("B"); // [B]
        deque.addLast("C"); // [B , C ]
        deque.addLast("A"); // [B , C , A]
        deque.addFirst("D"); // [D, B , C , A]
        System.out.println("Deque after inserts: " + deque);


        //remove demonstration

        String removedFirst = deque.removeFirst(); // removes D
        String removedLast = deque.removeLast();   // removes A
        System.out.println("\nRemoved from front: " + removedFirst);
        System.out.println("Removed from back: " + removedLast);
        System.out.println("Deque after removals: " + deque); //[ B , C ,null]

        //find demonstration

        deque.addLast("X");
        deque.addLast("Y");
        deque.addLast("Z"); // [B, C, X, Y, Z, null]
        System.out.println(deque);
        System.out.println("\nContains 'Y'? " + deque.contains("Y"));
        System.out.println("Contains 'Q'? " + deque.contains("Q"));

        //iterate demonstration
        System.out.println();
        IterableInterface<String> iterable = deque;
        IteratorInterface<String> it = iterable.iterator();
        while (it.hasNext()) {
            System.out.println("Iterated element: " + it.next());
        }

        System.out.println("\nFinal Deque");
        System.out.println(deque);
    }
}