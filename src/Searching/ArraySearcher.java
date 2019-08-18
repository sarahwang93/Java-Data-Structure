package Searching;

public class ArraySearcher{
    static String[] students = new String[]{"Tom","Harry","Merry","Aisha","Abdullah"};
    static int[] marks = new int[]{63,70,65,85,72};

        public void ArraySearcher(){
            System.out.println("linear Search start");
        }

        public static <E,F extends E> int linearSearch(E[] values, int valueToLookup){
            for (int i=0; i<values.length; i++){
                if(values[i].equals(valueToLookup)){
                    return i;
                }
            }
            return -1;
        }


         public static <E,F extends E> int linearSearch_student(E[] values, String valueToLookup){
             for (int i=0; i<values.length; i++){
                 if(values[i].equals(valueToLookup)){
                    return i;
                 }
             }
            return -1;
        }


        public static Integer marksForName(String name){

            int index = linearSearch_student(students, name);
            if(index>=0){
                 return marks[index];
            }else{
                 return null;
            }
         }

         public static void main(String[] args){
            Integer[] integers = new Integer[]{232,54,1,213,654,23,6,72,21};
            System.out.println(ArraySearcher.linearSearch(integers,5));
            System.out.println(ArraySearcher.linearSearch(integers,23));
            ArraySearcher arraySearcher = new ArraySearcher();
            System.out.println(arraySearcher.marksForName("Merry"));
        }

}
