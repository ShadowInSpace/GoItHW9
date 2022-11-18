

public class TestClass {
    public static void main(String[] args) {

       MyHashMap myHashMap = new MyHashMap();
       myHashMap.put("123r","sdfag");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.remove("123r");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.clear();
        System.out.println("myHashMap.size() = " + myHashMap.size());

        myHashMap.put("test1","dfcz dfsf");
        myHashMap.put("test1","test12");
        System.out.println("myHashMap.get(\"test1\") = " + myHashMap.get("test1"));
    }
}
