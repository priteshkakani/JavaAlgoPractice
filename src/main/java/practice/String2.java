package practice;

import java.util.Arrays;

public class String2 {

    public static String validParentheses(String s) {
        //Stack

        return "";
    }

    //14. Longest Common Prefix
    public static String longestCommonPrefix(String[] input) {
        String str = "";
        int len = input.length;
        int slen = input[0].length();
        for(int i = 0;i < slen;i++) {
            for(int j = 0;j < len-1;j++) {
                //str = str + input[j].charAt(i);
                if(input[j].charAt(i) == input[j+1].charAt(i))
                    continue;
                else
                    return str;
            }
        }
        return str;
    }

    public static String longestCommonPrefix1(String[] strs) {
        int size = strs.length;
        if(size==0)
            return "";
        if(size==1)
            return strs[0];
        Arrays.sort(strs);
        int end = Math.min(strs[0].length(),strs[size-1].length());
        int i = 0;
        while ( i < end && strs[0].charAt(i) == strs[size -1].charAt(i))
            i++;
        String pre = strs[0].substring(0,i);
        return pre;
    }

    public static String longestCommonPrefix2(String[] arr) {
        int n = arr.length;
        String result = arr[0];
        for(int i =0;i<n;i++)
        {
            while(arr[i].indexOf(result) != 0)
            {
                result = result.substring(0,result.length()-1);
                if(result.isEmpty()){
                    return "-1";
                }
            }
        }
        return result;
    }

    public static String longestCommonPrefix3(String[] arr) {
        Arrays.sort(arr);
        String s1 = arr[0];
        String s2 = arr[arr.length-1];
        int index = 0;
        while(index < arr.length && index < s2.length()){
            if(s1.charAt(index) == s2.charAt(index)){
                index++;
            }
            else{
                break;
            }
        }
        return s1.substring(0,index);
    }

    public static void main(String[] args) {
        String s = "(){}[]";
        validParentheses(s);
        //14. Longest Common Prefix
        String[] strs = {"flower","flow","flight"};
        String lcp = longestCommonPrefix(strs);
        System.out.println(lcp);
        String lcp1 = longestCommonPrefix1(strs);
        System.out.println(lcp1);
        String lcp2 = longestCommonPrefix2(strs);
        System.out.println(lcp2);
        String lcp3 = longestCommonPrefix3(strs);
        System.out.println(lcp3);
    }
}
