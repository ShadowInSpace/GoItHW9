import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap {

    static class Node{
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
            return getKey().equals(node.getKey());
        }
    }
}
