package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HashExample {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Hello", "one");
        hm.put("Hi", "two");
        hm.put("Hey", "Three");
        hm.put("Hmmm", "Four");


        //Option : 1
        for (Map.Entry<String, String> map : hm.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }
        //Option : 2
        Iterator ite=hm.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry entry = (Map.Entry) ite.next();
            System.out.println(entry.getKey() +" : "+entry.getValue());
        }
        //Option : 3
        System.out.println("Option 3");
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("Key : " + key + " value : " + hm.get(key));
        }
        //Option : 4
        hm.forEach((id, name) -> {
            System.out.println("Key : " + id + " value : " + name);
        });

        System.out.println("Floor Key testing :::::");
        for (int i = 1; i<= 100; i++) {
            System.out.println(i+"\t =\t "+toRoman(i));
        }
    }
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        System.out.println("Floor Key : " + l);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
}
