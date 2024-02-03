package practice;

import java.util.Arrays;

public class problem3 {
    public static void main(String[] s) {
        String[] s1 = {"flower", "flow", "flight"};
//        String str = new String();
//        int len = strs.length;
//        for (int i = 0; i < len - 2; i++) {
//            if (str.charAt(i) != str.charAt(i + 1))
//                break;
//            if (i + 1 == len) {
//                str = str + str.charAt(i);
//                break;
//            }
//        }
//        System.out.println(str);
        int size = s1.length;
        Arrays.sort(s);
        int end = Math.min(s1[0].length(), s1[size-1].length());
        int i =0;
        while(i<end && s1[0].charAt(i) == s1[size-1].charAt(i))
            i++;
        String pre = s1[0].substring(0,i);
        System.out.println(pre);
    }
}

