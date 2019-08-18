package Searching;

public class binarySearch {

    private static <E extends Comparable<E>,
            F extends E> int binarySearch( E[] sortedValues,
                                           F valueToSearch, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int midIndex = (end + start) / 2;
        int comparison = sortedValues[midIndex].compareTo(valueToSearch);
        if (comparison == 0) {
            return midIndex;
        } else if (comparison > 0) {
            return binarySearch(sortedValues, valueToSearch, start, midIndex);
        } else {
            return binarySearch(sortedValues, valueToSearch, midIndex + 1, end);
        }
    }


        public static <E extends Comparable<E>,F extends E > int binarySearch (E[]sortedValues, F valueToSearch){
            return binarySearch(sortedValues, valueToSearch, 0, sortedValues.length);
        }

        public static void main(String[] args) {
            int arraySize = 100000000;
            Long array[] = new Long[arraySize];
            array[0] = (long)(Math.random()*100);
            for(int i=1;i<array.length;i++)
            {
                array[i] = array[i-1] + (long)(Math.random()*100);
            }         //let us look for an element using linear and binary search
            long start = System.currentTimeMillis();
            ArraySearcher arraySearcher  = new ArraySearcher();
            arraySearcher.linearSearch(array, (int)31232L);
            long linEnd = System.currentTimeMillis();
            binarySearch(array, 31232L);
            long binEnd = System.currentTimeMillis();
            System.out.println("linear search time :=" + (linEnd -start));
            System.out.println("binary search time :=" + (binEnd -linEnd));
        }

}
