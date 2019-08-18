package FunctionalProgramming;

public interface FunctionalInterfaceWithDefaultMethod {
    int modify(int x);
    default int modifyTwice(int x ){
        return modify(modifyTwice(x));
    }
}
