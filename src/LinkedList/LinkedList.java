package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

interface Visualizable{

}

//If the program does not have any loops, all operations would be one-time operations, hence everything is completed in constant time
//Define E as Integer or String or Double, E is the type of elements in linkedlist(any kind)
public class LinkedList<E> implements Iterable<E>,Visualizable{
    int length = 0;
    protected static class Node<E> {
        protected E value;
        protected Node next;
        public String toString() {
            return value.toString();
        }
    }

    Node<E>[] lastModifiedNode;
    Node<E> first;
    Node<E> last;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    protected Node<E> getNewNode(){
        Node<E> node = new Node<>();
        lastModifiedNode = new Node[]{node};
        return node;
    }

    public Node<E> appendLast(E value){
        Node node=getNewNode();
        node.value=value;
        if (last!=null){
            last.next=node;
        }
        last=node;
        if(first == null){
            first=node;
        }
        length++;
        return node;
    }

    public Node<E> appendFirst(E value){
        Node node = getNewNode();
        node.value=value;
        node.next=first;
        first=node;
        if(length == 0)
            last=node;
        length++;
        return node;
    }

    //insert at an arbitrary position
    public Node<E> insert(int index, E value){
        Node<E> node=getNewNode();
        if (index<0 || index>length){
            throw new IllegalArgumentException("Invalid index for insertion");
        } else if (index == length){
            return appendLast(value);
        } else if (index==length){
            return appendLast(value);
        } else if (index==0){
            return appendFirst(value);
        } else {
            Node<E> result=first;
            while (index > 1){
                index --;
                result=result.next;
            }
            node.value = value;
            node.next=result.next;
            result.next = node;
            length++;
            return node;
        }
    }

    //Remove element at First
    public Node<E> removeFirst(){
        if(length==0){
            throw new NoSuchElementException();
        }
        Node<E> origFirst=first;
        first=first.next;
        length--;
        if(length == 0){
            last=null;
        }
        return origFirst;
    }

    //Remove element from linkedlist arbitrory position
    //worst case complexity O(n)
    protected Node<E> removeAtIndex(int index){
        if(index>=length || index<0){
            throw new NoSuchElementException();
        }
        if(index == 0){
            Node<E> nodeRemoved = first;
            removeFirst();
            return nodeRemoved;
        }
        Node justBeforeIt = first;
        while(--index>0) {
            justBeforeIt = justBeforeIt.next;
        }
        Node<E> nodeRemoved = justBeforeIt.next;
        if( justBeforeIt.next == last){
            last = justBeforeIt.next.next;
        }
        justBeforeIt.next = justBeforeIt.next.next;
        length--;
        return nodeRemoved;
    }

    //return the length of linkedlist
    protected int getLength(){
        return length;
    }

    //return the first element of linkedlist
    protected E getFirst(){
        if(length==0){
            throw new NoSuchElementException();
        }
        return first.value;

    }

    protected class ListIterator implements Iterator<E>,Visualizable {
        protected Node<E> nextNode = first;

        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            Node<E> nodeToReturn = nextNode;
            nextNode = nextNode.next;
            return nodeToReturn.value;
        }

        public Iterator<E> iterator() {
            return new ListIterator();
        }

    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        for(Object x : linkedList){
            System.out.println(x);

        }
    }
}

