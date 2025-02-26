package CS113;

public class Main {
    public static void main(String[] args) {

        LinkedListKB<Integer> testArray = new LinkedListKB<>();
        for (int i = 0; i < 10; i++) {
            testArray.add(i);
        }

        testArray.add(4,null);
        System.out.println(testArray);
        System.out.println(testArray.size());



    }
}