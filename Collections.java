import java.util.*;

public class Collections {
    public static void main(String[] args) {
        // HashSet implements Set
        HashSet<String> hashSet = new HashSet<String>();
        System.out.println(hashSet.add("foo"));
        System.out.println(hashSet.add("bar"));
        System.out.println(hashSet.add("bar"));

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        System.out.println(hashMap.put(1, "one"));
        System.out.println(hashMap.put(2, "two"));
        System.out.println(hashMap.put(1, "three"));

        System.out.println(hashMap.containsValue("two"));

        System.out.println(hashMap.size());
        for(Integer i : hashMap.keySet()) {
            System.out.println(i + ": " + hashMap.get(i));
        }
    }
}