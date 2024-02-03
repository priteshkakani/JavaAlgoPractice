package practice;

public class problem4 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        int flag = 1;
        for(int i =0;i<len;i++)
            if (s.charAt(i) != s.charAt(len-1-i))
                flag = 0;
        if(flag==1)
            return true;
        return false;
    }

    public static void main(String[] args){
        problem4 p = new problem4();
        int x = 171;
        System.out.println(p.isPalindrome(x));
    }
}
