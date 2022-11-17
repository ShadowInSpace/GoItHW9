

import java.util.Objects;

public class MyHashMapOld {
    private MyHashMapOld.Node first;
    private MyHashMapOld.Node last;
    private int size;

    static class Node {
        final int hash;
        final Object key;
        Object value;
        MyHashMapOld.Node next;


        Node(int hash, Object key, Object value, MyHashMapOld.Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final Object getKey() {
            return key;
        }

        public final Object getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (hash != node.hash) return false;
            return getKey().equals(node.getKey());
        }
//
//        }
    }

    public MyHashMapOld() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void put(Object key, Object value) {
        if (checkExist(key)) {
            getNode(key).value = value;
        } else {
            int keyHash = key.hashCode();
            Node newNode = new Node(keyHash, key, value, null);
            size++;
            if (first != null) {
                last.next = newNode;
                last = newNode;
            } else {
                first = last = newNode;
            }
        }

    }

    private boolean checkExist(Object key) {
        boolean didExist = false;
        MyHashMapOld.Node cNode = first;
        while (cNode != null) {
            didExist = cNode.key.equals(key);
            if (didExist) break;
            cNode = cNode.next;
        }
        return didExist;
    }

    private MyHashMapOld.Node getNode(Object key) {
        //Node must exist
        int keyHash = key.hashCode();
        MyHashMapOld.Node n = first;
        while (n != null) {
            if (n.hash==keyHash) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    public Object get(Object key) {
        return getNode(key).value;
    }

    public void remove(Object key) {
        int keyHash = key.hashCode();
        if (first.key.equals(key)) {
            first.value = null;
            first = first.next;
            size--;
        } else {
            MyHashMapOld.Node prev = first;
            MyHashMapOld.Node iter = first;
            while (iter != null) {
                if (iter.hash == keyHash) {
                    if (iter.next == null) last = prev;
                    prev.next = iter.next;
                    iter.value = null;
                    size--;
                    break;
                }
                prev = iter;
                iter = iter.next;
            }

        }

    }

    public void clear() {
        for (MyHashMapOld.Node x = first; x != null; ) {
            MyHashMapOld.Node next = x.next;
            x.value = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
}
