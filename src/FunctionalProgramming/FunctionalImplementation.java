package FunctionalProgramming;

public class FunctionalImplementation {
    public static void main(String[] args){
        SampleFunctionalInterface sfi = (x)->x+1;
        int y = sfi.modify(1);
        System.out.println("y="+y);
        Thread t = new Thread(()->{for(int i=0;i<500;i++) System.out.println(i);});
        t.start();
    }
}
