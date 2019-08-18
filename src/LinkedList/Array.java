package LinkedList;

public class Array {
    public static void printAllElements(int[] anIntArray){
        for(int i=0;i<anIntArray.length;i++){
            System.out.println(anIntArray[i]);
        }
    }

    public static void insertElementAtIndex(int[]array, int startIndex, int targetIndex){
        int value = array[startIndex];
        if(startIndex == targetIndex){
            return;
        } else if(startIndex < targetIndex){
            for(int i=startIndex+1;i<=targetIndex;i++){
                array[i-1]=array[i];
            }
            array[targetIndex]=value;
        }else{
            for(int i=startIndex-1;i>=targetIndex;i--){
                array[i+1]=array[i];
            }
            array[targetIndex]=value;
        }
    }

    public static int [] insertExtraElementAtIndex(int[] array, int index, int value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = value;
        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static int[] appendElement (int[] array, int value){
        return insertExtraElementAtIndex(array, array.length, value);
    }
}
