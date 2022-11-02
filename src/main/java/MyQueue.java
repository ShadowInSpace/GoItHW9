public class MyQueue {
    private int size;

    private static class Node {
        Object item;
        MyQueue.Node next;
        //MyQueue.Node prev;

        Node(Object element, MyQueue.Node next) {
            this.item = element;
            this.next = next;
            //this.prev = prev;
        }
    }

    private MyQueue.Node first;
    private MyQueue.Node last;

    public MyQueue() {
        size = 0;
    }

    public int size() {
        return size;
    }


    void add(Object o) {
        final MyQueue.Node l = last;
        final MyQueue.Node newNode = new MyQueue.Node(o, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private MyQueue.Node getNode(int index) {
        if (index >= size) throw new IllegalArgumentException();
        MyQueue.Node nodeA = first;
        MyQueue.Node nodeB;

        for (int i = 0; i < index; i++) {
            nodeB = nodeA.next;
            nodeA = nodeB;
        }
        return nodeA;
    }

    public void remove(int index) {
        final MyQueue.Node x = getNode(index);
        final MyQueue.Node next = x.next;

        if (x == first) {
            //if x first element;
            first = next;
            x.next = null;
        }
        if (next == null) {
            //if x last element
            last = getNode(index - 1);
            last.next = null;
        } else {
            //x not first nor last
            getNode(index - 1).next = next;
            x.next = null;
        }
        size--;
    }


    public void clear() {
        for (MyQueue.Node x = first; x != null; ) {
            MyQueue.Node next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public Object peek() {
        return first.item;
    }

    public Object poll() {

        MyQueue.Node ret = first;
        remove(0);
        size--;
        return ret.item;


    }
}
