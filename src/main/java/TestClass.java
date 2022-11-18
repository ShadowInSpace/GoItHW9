import java.util.HashMap;
import java.util.Queue;

public class TestClass {
    public static void main(String[] args) {

       MyHashMap myHashMap = new MyHashMap();
       myHashMap.put("123r","sdfag");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.remove("123r");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.clear();
        System.out.println("myHashMap.size() = " + myHashMap.size());
    }
}
