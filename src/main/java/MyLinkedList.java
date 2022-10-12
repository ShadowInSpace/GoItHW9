import java.util.LinkedList;

public class MyLinkedList {
    private int size = 0;
    private static class Node {
        Object item;
        MyLinkedList.Node next;
        MyLinkedList.Node prev;

        Node(MyLinkedList.Node prev, Object element, MyLinkedList.Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node first;
    private Node last;

    void add(Object o) {
        final MyLinkedList.Node l = last;
        final MyLinkedList.Node newNode = new MyLinkedList.Node(l, o, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    public MyLinkedList() {
    size=0;
    }
    public void remove(int index){
    MyLinkedList.Node next;
    MyLinkedList.Node prev = first;
    if(index>=size) throw new IllegalArgumentException();

    for(int i=0; i<index; i++){
    next = prev.next;

    }

    }

    public Object get(int index){
        MyLinkedList.Node next;
        MyLinkedList.Node prev = first;

    }
}
