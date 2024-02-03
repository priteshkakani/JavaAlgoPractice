package practice;

import java.util.*;
import java.util.stream.Collectors;

//Longest Palindrome in a String
public class HashMap1 {
    static String longestPalin(String S){
        // code here

        return S;
    }

    public static HashMap<String, Integer> sortValue(HashMap<String, Integer> hm){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // put data from sorted list to hashmap
        HashMap<String,Integer> temp = new LinkedHashMap<String,Integer>();
        for (Map.Entry<String, Integer> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static HashMap<String, Integer> sortValue1(HashMap<String, Integer> hm){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));
        // put data from sorted list to hashmap
        HashMap<String,Integer> temp = new LinkedHashMap<String,Integer>();
        for (Map.Entry<String, Integer> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static HashMap<String, Integer> sortValue2(HashMap<String, Integer> hm){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));
        // put data from sorted list to hashmap
        HashMap<String,Integer> temp = new LinkedHashMap<String,Integer>();
        for (Map.Entry<String, Integer> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static HashMap<String, Integer> sortValue3(HashMap<String, Integer> hm){
        HashMap<String,Integer> temp = hm.entrySet().stream().sorted((i1,i2)->i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        return temp;
    }

    public static void printFreq(int[] arr){
        HashMap<Integer,Integer> hm5 = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            Integer c = hm5.get(arr[i]);
            if(hm5.get(arr[i]) == null)
                hm5.put(arr[i],1);
            else
                hm5.put(arr[i],++c);
        }
        for(Map.Entry entry : hm5.entrySet())
            System.out.println("Frequency of " + entry.getKey() + " is " + entry.getValue());
    }

    public static void printFreq1(int[] arr){
        TreeMap<Integer,Integer> hm5 = new TreeMap<>();
        for(int i = 0;i<arr.length;i++){
            Integer c = hm5.get(arr[i]);
            if(hm5.get(arr[i]) == null)
                hm5.put(arr[i],1);
            else
                hm5.put(arr[i],++c);
        }
        for(Map.Entry entry : hm5.entrySet())
            System.out.println("Frequency of " + entry.getKey() + " is " + entry.getValue());
    }

    public static void main(String[] args){
        String s = "aaaabbaa";
        System.out.println( HashMap1.longestPalin(s));
        // Java Program to sort hashmap by values
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        hm.put("Networking", 81);
        hm.put("Networking", 82);
        hm.put(null, 82);
        //Map<String,Integer> hm1 =sortValue(hm);
        //Map<String,Integer> hm2 =sortValue1(hm);
        //Map<String,Integer> hm3 =sortValue2(hm);
        Map<String,Integer> hm4 =sortValue3(hm);
        // print sorted HashMap
      /*  for (Map.Entry<String,Integer> en: hm1.entrySet()){
            System.out.println("Key = "+ en.getKey() + ", Value :"+ en.getValue());
        }
        for (Map.Entry<String,Integer> en: hm2.entrySet()){
            System.out.println("Key = "+ en.getKey() + ", Value :"+ en.getValue());
        }
        for (Map.Entry<String,Integer> en: hm3.entrySet()){
            System.out.println("Key = "+ en.getKey() + ", Value :"+ en.getValue());
        }*/
       /* for (Map.Entry<String,Integer> en: hm4.entrySet()){
            System.out.println("Key = "+ en.getKey() + ", Value :"+ en.getValue());
        }*/

        /* Java program to print frequencies of all elements using HashMap */
        int[] arr = {10,5,6,5,10,10};
        printFreq(arr);
        printFreq1(arr);

    }
}
