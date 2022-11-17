public class MainTest {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.put("key1","value1");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.put("key2","value2");
        myHashMap.put("key3","value3");
        myHashMap.put("key4","value4");
        System.out.println("put4  " + myHashMap.size());
        System.out.println("myHashMap.get(\"key1\") = " + myHashMap.get("key1"));
        myHashMap.remove("key2");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.get(\"key3\") = " + myHashMap.get("key3"));

    }


}
