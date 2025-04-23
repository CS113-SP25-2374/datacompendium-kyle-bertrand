package CS113;

import CS113.Interfaces.Comparable;

public class SortingHatKB<E extends Comparable<E>>{

    void swap(ArrayListKB<E> array, int i, int j) {
        E temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    void bubbleSort(ArrayListKB<E> unsortedArray) {
        for (int i = 0; i < unsortedArray.size() - 1; i++) {
            boolean swapped = false;

            //nested loop
            for (int j = 0; j < unsortedArray.size() -1 ; j++) {
                int k = j+1;
                if(unsortedArray.get(j).compareTo(unsortedArray.get(k)) > 0){
                    //three way swap
                    swap(unsortedArray, k, j);
                    swapped = true;
                }
            }
            //for if there is no swap
            if(!swapped) return;
        }

    }

    void insertionSort(ArrayListKB<E> unsortedArray) {
        for (int i = 1; i < unsortedArray.size() - 1; i++) {
            E temp = unsortedArray.get(i);
            int j = i;

            while( j > 0 && temp.compareTo(unsortedArray.get(j)) < 0){
                unsortedArray.set(j, unsortedArray.get(j -1));
                j--;
            }
            unsortedArray.set(j, temp);
        }
    }

    ArrayListKB<E> mergeSort(ArrayListKB<E> array) {
        if (array.size() <= 1) {
            return array;
        }

        int mid = array.size() / 2;

        ArrayListKB<E> left = new ArrayListKB<>();
        ArrayListKB<E> right = new ArrayListKB<>();

        for (int i = 0; i < array.size(); i++) {
            (i < mid ? left : right).add(array.get(i));
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    ArrayListKB<E> merge(ArrayListKB<E> left, ArrayListKB<E> right) {

        ArrayListKB<E> merged = new ArrayListKB<>();

        int l = 0;
        int r = 0;

        while (l < left.size() || r < right.size()) {
            if(l == left.size()){
                merged.add(right.get(r++));
            } else if(r == right.size()){
                merged.add(left.get(l++));
            } else if(left.get(l).compareTo(right.get(r)) < 0) {
                merged.add(left.get(l++));
            } else { merged.add(right.get(r++)); }
        }

        return merged;
    }

    ArrayListKB<E> quickSort(ArrayListKB<E> arr) {
        if (arr.size() <= 1) return arr;

        E pivot = arr.get(arr.size() - 1);
        ArrayListKB<E> left = new ArrayListKB<>();
        ArrayListKB<E> right = new ArrayListKB<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            E temp = arr.get(i);
            if (pivot.compareTo(temp) > 0) {
                left.add(temp);
            } else {
                right.add(temp);
            }
        }

        return mergePivot(quickSort(left), E pivot, quickSort(right));
    }

    ArrayListKB<E> mergePivot(ArrayListKB<E> left, E pivot, ArrayListKB<E> right) {

        ArrayListKB<E> merged = new ArrayListKB<>();

        for (int i = 0; i < left.size(); i++) {
            merged.add(left.get(i));
        }
        merged.add(pivot);
        for (int i = 0; i < right.size(); i++) {
            merged.add(right.get(i));
        }
        return merged;
    }


    //make a Selection sort method


}






}
