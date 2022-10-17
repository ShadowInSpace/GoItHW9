import java.util.LinkedList;

public class MyLinkedList {
    private int size;
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

    public int size(){
        return size;
    }

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

    public void remove(int index) {
        final MyLinkedList.Node x = getNode(index);
        final MyLinkedList.Node prev = x.prev;
        final MyLinkedList.Node next = x.next;

        if (prev == null) {
            //if x first element;
            first = next;
            next.prev = null;
            x.prev = null;
        } else if (next == null) {
            //if x last element
            last = x.prev;
            last.next = null;
            x.next = null;
        } else {
            //x not first nor last
            prev.next = next;
            next.prev = prev;
            x.next = x.prev = null;
        }
        size--;


    }
    public Object get(int index){
        return getNode(index).item;
    }

    public void clear(){
        for (MyLinkedList.Node x = first; x != null; ) {
            MyLinkedList.Node next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private MyLinkedList.Node getNode(int index){
        if(index>=size) throw new IllegalArgumentException();
        MyLinkedList.Node nodeA = first;
        MyLinkedList.Node nodeB;

        for(int i=0; i<index; i++){
            nodeB = nodeA.next;
            nodeA = nodeB;
        }
        return nodeA;
    }

    }


