package practice;
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
//Input: s = "anagram", t = "nagaram"
//Output: true

public class String1 {

    public static boolean isAnagram(String s, String t) {
        //HashMap hm = new HashMap<Character, >();
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for(int i=0;i<s.length();i++)
            s.charAt(i);

        for(int i =0;i<s.length();i++)
            s.charAt(i);
        return false;
    }

    public static String addStars(String s, int stars[]){
        String ans = "";
        int j = 0;
        for (int i = 0;i<s.length();i++){
                if(j<stars.length && i == stars[j]){
                    ans += '*';
                    j++;
                }
                ans += s.charAt(i);
            }

        return ans;
    }

    public static String tryCatchTrial(){
        try{
            //return "1";
            throw new ArithmeticException("Throws");
        } finally{
            return "3";
        }
    }

    public static String equalsCheckMethod(String s, String t){
        if(s.equals(t))
            return "true";
        return "false";
    }

    public static String equalsCheckOperator(String s, String t){
        if( s == t)
            return "true";
        return "false";
    }

    public static void removeChar(String s, char c){
        int j, count = 0, n = s.length();
        char[] t = s.toCharArray();
        for(int i=j=0; i<n;i++)
        {
          if(t[i] != c)
              t[++j] = t[i];
          else
              count++;
        }
        while(count>0){
            t[j++] = '\0';
            count --;
        }
    }

    public static void main(String[] args) {
        String s = "anagram";
        char c = 'a';
        String t = "anagram ";
        //String1 problem12 = new String1();
        //System.out.println("isAnagram : " +problem12.isAnagram(s,t));
        System.out.println(equalsCheckMethod(s,t));
        System.out.println(equalsCheckOperator(s,t));
        String str = "geeksforgeeks";
        int chars[] = {1,5,7,9};
        //String ans = addStars(str, chars);
        //System.out.println(ans);

        //String tryCatch = tryCatchTrial();
        //System.out.println(tryCatch);
        //removeChar(str, c);

    }
}
