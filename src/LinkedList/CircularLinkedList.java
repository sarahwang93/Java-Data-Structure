package LinkedList;

public class CircularLinkedList<E> extends LinkedList<E> {

    @Override
    public Node<E> appendFirst(E value){
        Node<E> newNode = super.appendFirst(value);
        last.next = first;
        return newNode;
    }

    @Override
    public  Node<E> appendLast(E value){
        Node<E> newNode = super.appendLast(value);
        last.next = first;
        return newNode;
    }

    @Override
    public Node<E> removeFirst(){
        Node<E> newNode = super.removeFirst();
        last.next=first;
        return newNode;
    }

    public void rotate(){
        last = first;
        first = first.next;
    }

    public static void main(String[]  args){
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.rotate();
        for(int i=0;i<30;i++){
            System.out.println(i);
        }
    }
}
