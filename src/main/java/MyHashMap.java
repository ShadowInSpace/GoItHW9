import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Node[] body = new Node[DEFAULT_INITIAL_CAPACITY];
    private int size=0;

    public int size(){
        return size;
    }

    static class Node {
        final int hash;
        final Object key;
        Object value;
        MyHashMap.Node next;

        Node(int hash, Object key, Object value, MyHashMap.Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final Object getKey()        { return key; }
        public final Object getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final Object setValue(Object newValue) {
           Object oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (hash != node.hash) return false;
            if (!getKey().equals(node.getKey())) return false;
            return getValue().equals(node.getValue());
        }

    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    private Node createNode(Object key, Object value){
        size++;
        return new Node(hash(key),key,value,null);
    }

    public void put (Object key, Object value){
        boolean notFound = true;
        Node newNode = createNode(key,value);
        Node bucket = body[newNode.hash%DEFAULT_INITIAL_CAPACITY];
        if(bucket==null){
            bucket=newNode;
        }else {
            while(notFound){
                if(newNode.equals(bucket)) {
                    size--;
                    notFound=false;
                }
                if(bucket.next==null){
                    bucket.next=newNode;
                    notFound=false;
                } else {
                    bucket=bucket.next;
                }

            }
        }
    }

    public void remove(Object key){
        Node bucket = body[hash(key)%DEFAULT_INITIAL_CAPACITY];
        boolean notFound = true;
        if(bucket!=null) {

            if (bucket.key.equals(key)) {
                if (bucket.next == null) {
                    body[hash(key) % DEFAULT_INITIAL_CAPACITY] = null;
                    size--;
                    notFound = false;
                } else {
                    body[hash(key) % DEFAULT_INITIAL_CAPACITY] = bucket.next;
                    size--;
                    notFound = false;
                }

            } else {
                bucket = bucket.next;

                while (notFound) {

                    if (bucket.key.equals(key)) {
                        if (bucket.next == null) {
                            bucket = null;
                            size--;
                            notFound = false;
                        } else {
                            bucket = bucket.next;
                            size--;
                            notFound = false;
                        }
                    } else {
                        if(bucket.next==null) return;
                        bucket = bucket.next;
                    }
                }
            }
        } else {
            return;
        }
    }



}
