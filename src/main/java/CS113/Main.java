package CS113;

import CS113.Interfaces.IterableInterface;
import CS113.Interfaces.IteratorInterface;

public class Main {
    public static void main(String[] args) {

        ArrayDequeCelebration<String> deque = new ArrayDequeCelebration<>();

        //insert demonstartion
        System.out.println("=== Insert Test ===");
        deque.addFirst("B"); // [B]
        deque.addLast("C"); // [B , C ]
        deque.addLast("A"); // [B , C , A]
        deque.addFirst("D"); // [D, B , C , A]
        System.out.println("Deque after inserts: " + deque);


        //remove demonstartion
        System.out.println("\n=== Remove Test ===");
        String removedFirst = deque.removeFirst(); // removes D
        String removedLast = deque.removeLast();   // removes A
        System.out.println("Removed from front: " + removedFirst);
        System.out.println("Removed from back: " + removedLast);
        System.out.println("Deque after removals: " + deque); //[ B , C ,null]

        //find demonstartion
        System.out.println("\n=== Contains Test ===");
        deque.addLast("X");
        deque.addLast("Y");
        deque.addLast("Z"); // [B, C, X, Y, Z, null]
        System.out.println(deque);
        System.out.println("Contains 'Y'? " + deque.contains("Y"));
        System.out.println("Contains 'Q'? " + deque.contains("Q"));

        //iterate demonstartion
        System.out.println("\n=== Iteration Test ===");
        IterableInterface<String> iterable = deque;
        IteratorInterface<String> it = iterable.iterator();
        while (it.hasNext()) {
            System.out.println("Iterated element: " + it.next());
        }

        System.out.println("\n=== Final Deque ===");
        System.out.println(deque);
    }
}