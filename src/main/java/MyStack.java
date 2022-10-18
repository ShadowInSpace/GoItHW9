public class MyStack {
    //Код майже такий же як в лінкедліст але останній елемент вважаю першим
    private int size;
    private static class Node {
        Object item;
        MyStack.Node next;
        MyStack.Node prev;

        Node(MyStack.Node prev, Object element, MyStack.Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private MyStack.Node first;
    private MyStack.Node last;

    public int size(){
        return size;
    }

    void push(Object o) {
        final MyStack.Node l = last;
        final MyStack.Node newNode = new MyStack.Node(l, o, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    public MyStack() {
        size=0;
    }

    public void remove(int index) {
        final MyStack.Node x = getNode(index);
        final MyStack.Node prev = x.prev;
        final MyStack.Node next = x.next;

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
    public Object peek(){
        return last.item;
    }

    public Object pop(){
        Object o = last.item;
        final MyStack.Node x = last;
        final MyStack.Node prev = x.prev;
        final MyStack.Node next = x.next;
        last = x.prev;
        last.next = null;
        x.next = null;
        size--;
        return o;
    }

    public void clear(){
        for (MyStack.Node x = first; x != null; ) {
            MyStack.Node next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private MyStack.Node getNode(int index){
        if(index>=size) throw new IllegalArgumentException();
        MyStack.Node nodeA = last;
        MyStack.Node nodeB;

        for(int i=0; i<index; i++){
            nodeB = nodeA.prev;
            nodeA = nodeB;
        }
        return nodeA;
    }
    //todo check
}
