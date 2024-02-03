package practice;

import java.util.Arrays;

public class practice13 {

    public static String validParentheses(String s) {
        //Stack

        return "";
    }

    //14. Longest Common Prefix
    public static String longestCommonPrefix(String[] strs) {
        String str = "";
        int len = strs.length;
        for(int i = 0;i <= strs.length-2;i++) {
            for(int j = 0;j <= len-2;j++) {
                str = str + strs[j].charAt(i-1);
                if(strs[j].charAt(i) == strs[j+1].charAt(i))
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

    public static void main(String[] args) {
        String s = "(){}[]";
        validParentheses(s);
        //14. Longest Common Prefix
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix(strs);
        longestCommonPrefix1(strs);
        longestCommonPrefix2(strs);
    }
}
