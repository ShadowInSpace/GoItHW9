
import java.util.Objects;

public class MyHashMap {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Node[] body = new Node[DEFAULT_INITIAL_CAPACITY];
    private int size=0;

    public int size(){
        return size;
    }


    static int hash(Object key) {
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
        Node bucket = body[normaliseIndex(key)];
        if(bucket==null){
            body[normaliseIndex(key)]=newNode;
        }else {
            while(notFound){
                if(newNode.equals(bucket)) {
                    size--;
                    notFound=false;
                } else if(bucket.getKey().equals(key)){
                    bucket.setValue(value);
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
        Node bucket = body[normaliseIndex(key)];
        boolean notFound = true;
        if(bucket!=null) {

            if (bucket.key.equals(key)) {
                if (bucket.next == null) {
                    body[normaliseIndex(key)] = null;
                } else {
                    body[normaliseIndex(key)] = bucket.next;
                }
                size--;


            } else {
                bucket = bucket.next;

                while (notFound) {

                    if (bucket.key.equals(key)) {
                        if (bucket.next == null) {
                            bucket = null;
                        } else {
                            bucket = bucket.next;
                        }
                        size--;
                        notFound = false;
                    } else {
                        if(bucket.next==null) return;
                        bucket = bucket.next;
                    }
                }
            }
        }
    }
    public void clear(){
        body = new Node[DEFAULT_INITIAL_CAPACITY];
        size=0;
    }

    public Object get(Object key)throws IllegalArgumentException{
        Node bucket = body[normaliseIndex(key)];
        boolean notFound = true;
        Object answer=null;
        while (notFound){
            if(bucket==null)throw new IllegalArgumentException();
            if(bucket.getKey().equals(key)){
                notFound=false;
                answer = bucket.getValue();
            } else {
                bucket=bucket.next;
            }
        }
        return answer;
    }

    private int normaliseIndex(Object key){
        int notNormaliseIndex=hash(key)%DEFAULT_INITIAL_CAPACITY;
        if(notNormaliseIndex<0){
            return notNormaliseIndex*(-1);
        } else{
            return notNormaliseIndex;
        }
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

        public final void setValue(Object newValue) {
            value = newValue;
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

}
