package org.example;

import java.util.*;

public class missingNumber {
    public static void main(String[] args){
       /* HashMap<String, String> hm = new HashMap<>();
        //String b1 = hm.put("Stock","Balkrishna ind");
        String b2 = hm.put("Stock","MRF");
        //hm.put("Stock1","M&M");
        System.out.println(hm);
        //System.out.println(b1);
        System.out.println(b2);

        HashSet hs = new HashSet();
        hs.add("sr");*/

      /*  "This was new string"
        Kth maximum occuring character
        suppose we give input k as 1 (first highest) ,output should be s
        k as 2 (second highest) - i or t*/

       /* HashMap
        T - 1
        h - 1
        s = 2*/
        String s = "This was new string";
        int input = 1;
        HashMap<Character, Integer > hm = new HashMap<>();
        for(Character c : s.toCharArray()) {
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            }
            else hm.put(c,1);
        }
        Collection<Integer> l = hm.values();
       // ArrayList<Integer> a = l.stream().sorted().toArray();
        //{3,2,2,1,1,1}
       // Character c = hm.getKey(l.get(input));
        //System.out.println(c);
    }
}
