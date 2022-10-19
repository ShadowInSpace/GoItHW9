

import java.util.Objects;

public class MyHashMap {
private MyHashMap.Node First;
private int size;

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

    public MyHashMap() {
        this.size = 0;
    }
     public int size(){
        return size;
     }
     public void put(Object key, Object value){
    //якщо значення хеша є - перезаписати, якщо ні додати в кінець
         //написати ще метод щоб знайти значення по хешу.
     }
     private boolean checkExist(int hash){
        //перевірити чи є значення хеша
        return true;
     }
}
