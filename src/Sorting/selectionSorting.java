package Sorting;

import java.util.Arrays;

public class selectionSorting {

    public static <E extends Comparable<E>> int findMin(E[] array, int start) {
        if (start == array.length - 1) {
            return start;
        }
        int restMinIndex = findMin(array,start+1);
        E restMin = array[restMinIndex];
        if(restMin.compareTo(array[start])<0){
            return restMinIndex;
        }else{
            return start;
        }
    }

    public static <E> void swap(E[] array, int i, int j){
        if(i==j)
            return;
        E temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }

    //call it self recursively
    public static <E extends Comparable<E>> void selectionSort(E[] array, int start){
        if(start>=array.length){
            return;
        }
        int minElement = findMin(array,start);
        swap(array,start,minElement);
        selectionSort(array,start+1);
    }

    public static <E extends Comparable<E>> void selectionSort(E[] array){
        selectionSort(array,0);
    }

    //insertion sorting
    public static <E extends Comparable<E>> void insertElementSorted(E[] array, int valueIndex){
        if(valueIndex >0 && array[valueIndex].compareTo(array[valueIndex-1])<0){
            swap(array,valueIndex,valueIndex-1);
            insertElementSorted(array,valueIndex-1);
        }
    }

    //In every step of the insertion sort, we consider a boundary in the array.
    public static <E extends Comparable<E>> void insertionSort(E[] array, int boundary){
        if(boundary==0){
            return;
        }
        insertionSort(array,boundary-1);
        insertElementSorted(array,boundary);
    }

    public static void main(String[] args){
        Integer[] array = new Integer[]{10, 5, 2, 3, 78, 53, 3};
        selectionSort(array);
        System.out.println("select:"+Arrays.toString(array));
        insertionSort(array,0);
        System.out.println("insertion:"+Arrays.toString(array));
    }

}
