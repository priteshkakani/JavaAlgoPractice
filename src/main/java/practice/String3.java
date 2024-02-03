package practice;

//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"

import java.util.Arrays;

public class problem2 {
    public static String reverseWords(String s) {

        StringBuilder input1 = new StringBuilder();
        String[] arr = s.split(" ");
        String answer = new String();
        for(String s1: arr)
        {
            StringBuilder s2 = new StringBuilder(s1);
            s2.reverse();
            answer = answer + s2 + " ";
        }
        answer = answer.trim();
        return answer;
    }
    public static void main(String[] args){
        String input = "Let's take LeetCode contest";
        reverseWords(input);
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
