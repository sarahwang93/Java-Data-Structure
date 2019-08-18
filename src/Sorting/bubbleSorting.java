package Sorting;

import java.util.Arrays;

//condition is scan through the entire array does not have a single pair
//Inversion
//the most number of scan time is n
public class bubbleSorting {

    public static <E extends Comparable<E>> void bubbleSort(E[] array){
        boolean sorted =  false;
        while(!sorted){
            sorted = true;
            for(int i=0;i<array.length-1;i++){
                if(array[i].compareTo(array[i+1])>0){
                    selectionSorting.swap(array,i,i+1);
                    sorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args){
        Integer[] array = new Integer[]{10,5,2,3,78,53,3};
        bubbleSort(array);
    }
}
