package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    //start points to start of the first part
    //mid stores index of the start of second part/end of first part
    //end is the end of second part
    private static <E> void merge(E[] array, int start, int mid, int end, E[] targetArray, Comparator<E> comparator) {
        int i = start;
        int j = mid;
        int k = start;
        while (k < end) {
            if (i == mid) { //first source array exhausted
                targetArray[k] = array[j];
                j++;
            } else if (j == end) { //second source array exhausted
                targetArray[k] = array[i];
                i++;
            } else if (comparator.compare(array[i], array[j]) > 0) {
                targetArray[k] = array[j];
                j++;
            } else {
                targetArray[k] = array[i];
                i++;
            }
            k++;
        }
    }

    public static <E> void mergeSort(E[] sourceArray, int start, int end, E[] tempArray, Comparator<E> comparator) {
        if (start >= end - 1) {
            return;
        }
        int mid = (start + end) / 2;
        //iteration call
        mergeSort(sourceArray, start, mid, tempArray, comparator);
        mergeSort(sourceArray, mid, end, tempArray, comparator);
        merge(sourceArray, start, mid, end, tempArray, comparator);
        System.arraycopy(tempArray, start, sourceArray, start, end - start);
    }

    private static <E> void merge(E[] arrayL, E[] arrayR, int start, int mid, int end, E[] targetArray, Comparator<E> comparator) {
        int i = start;
        int j = mid;
        int k = start;
        while (k < end) {
            if (i == mid) {
                targetArray[k] = arrayR[j];
                j++;
            } else if (j == end) {
                targetArray[k] = arrayL[i];
                i++;
            } else if (comparator.compare(arrayL[i], arrayR[j]) > 0) {
                targetArray[k] = arrayR[j];
                j++;
            } else {
                targetArray[k] = arrayL[i];
                i++;
            }
            k++;
        }
    }

    public static <E> E[] mergeSortNoCopy(E[] sourceArray, int start, int end, E[] tempArray, Comparator<E> comparator){
        if(start >= end -1 ){
            return sourceArray;
        }
        int mid = (start+end)/2;
        E[] sortedPart1 = mergeSortNoCopy(sourceArray,start,mid,tempArray,comparator);
        E[] sortedPart2 = mergeSortNoCopy(sourceArray,mid,end,tempArray,comparator);
        if (sortedPart2 == sortedPart1){
            if (sortedPart1 == sourceArray){
                merge(sortedPart1,sortedPart2,start,mid,end,tempArray,comparator);
                return tempArray;
            } else{
                merge(sortedPart1,sortedPart2,start,mid,end,sourceArray,comparator);
                return sourceArray;
            }
        } else {
            merge(sortedPart1, sortedPart2, start, mid, end, sortedPart2, comparator);
            return sortedPart2;
        }
    }

    public static void main(String[] args){
        Integer array[] = {1,3,2,35,5,33,4,30,2,5,2,10};
        Integer[] anotherArray = new Integer[array.length];
        array = mergeSortNoCopy(array,0,array.length,anotherArray,(a,b)->a-b);
        System.out.println(Arrays.toString(array));
    }
}
