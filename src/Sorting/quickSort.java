package Sorting;


import java.util.Comparator;
import java.util.Arrays;

import static Sorting.selectionSorting.swap;

public class quickSort {
    public static <E> void quicksort(E[] array, int start, int end, Comparator<E> comparator){
        if(end-start <= 0){
            return;
        }
        int pivotIndex = (int)((end-start)*Math.random()) + start;
        swap(array, pivotIndex, end-1);
        int i = start;
        int j = end-1;
        boolean movingI = true;
        while(i<j){
            if(comparator.compare(array[i],array[j])>0) {
                swap(array,i,j);
                movingI = !movingI;
            }else{
                if (movingI) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        quicksort(array,start,i,comparator);
        quicksort(array,i+1,end,comparator);
    }

    public static <E> void quicksort(E[] array, Comparator<E> comparator){
        quicksort(array, 0, array.length, comparator);
    }

    public static void main(String[] args){
        Integer[] array =
                new Integer[]{10, 5, 2, 3, 78, 53, 3, 1, 1, 24, 1, 35,
                        35, 2, 67, 4, 33, 30};

        quicksort(array, (a, b) -> a - b);
        System.out.println(Arrays.toString(array));
    }

}