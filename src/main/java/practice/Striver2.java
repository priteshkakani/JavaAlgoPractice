package practice;

class NeedleHaystack {
    public int strStr(String haystack, String needle) {
        int occurence = -1;
        int haystacklength = haystack.length();
        int needlelength = needle.length();
        for(int j=0;j<haystacklength;j++){
            for(int i=0;i<needlelength;i++){
                System.out.println("i: "+i);
                System.out.println("j: "+j);
                if (needle.charAt(i) == haystack.charAt(i)) {
                    if (i == needlelength - 1)
                        occurence = j;
                    System.out.println("occurence: "+occurence);
                }
                else
                    break;
            }
            if(occurence!=-1)
                break;
        }
        return occurence;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        NeedleHaystack needleHaystack = new NeedleHaystack();
        System.out.println("isAnagram : " +needleHaystack.strStr(haystack,needle));
    }
}
