package Searching;

public class LinearSearch {

    public static <E,F extends E> int linearSearch(E[] values, int valueToLookup){
        for (int i=0; i<values.length;i++){
            if(values[i].equals(valueToLookup)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Integer[] integers = new Integer[]{232,54,1,213,654,23,6,72,21};
        System.out.println(ArraySearcher.linearSearch(integers,5));
        System.out.println(ArraySearcher.linearSearch(integers,23));
    }
}
