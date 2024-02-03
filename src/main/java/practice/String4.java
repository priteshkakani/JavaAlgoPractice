package practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Valid Palindrome
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
// and removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
public class StreamBasics {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        boolean flag = true;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                flag = false;
                break;
            }
        return flag;
    }

    static void reverseWords(String str) {
        Stack<Character> st = new Stack<Character>();

        // traverse given string and push all characters to stack until we see space
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ')
                st.push(str.charAt(i));
            else {
                // when we see space, we print contents of stack.
                while (st.empty() == false) {
                    System.out.print(st.pop());
                }
                System.out.print(" ");
            }
        }
        // Since there may not be space after last word.
        while (st.empty() == false) {
            System.out.print(st.pop());
        }
    }

    static void reverseWords1(String str) {
        String word;
        StringTokenizer iss = new StringTokenizer(str);
        while(iss.hasMoreTokens()){
            word = iss.nextToken();
            System.out.print(new StringBuilder(word).reverse().toString() + " ");
        }
    }

    static void reverseWords2(String str) {
        String result = Arrays.asList(str.split(" "))
                .stream()
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    static void reverseWords3(String str) {
        StringBuffer s = new StringBuffer(str);
        str = s.reverse().toString();
        String[] rev = str.split(" ");
        StringBuffer reverse = new StringBuffer();
        for(int i = rev.length -1 ;i>=0;i--){
            reverse.append(rev[i]).append(" ");
        }
        System.out.println(reverse);
    }

    static void reverseWords4(String str) {

    }

    static int fib(int n) {
        int a = 0, b = 1, c;
        if (n==0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    static int fib1(int n){
        if (n <= 1)
            return n;
        return fib1(n-1)+ fib1(n-2);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        StreamBasics streamBasics = new StreamBasics();
        //System.out.println("IsPalindrome : " +streamBasics.isPalindrome(s));
        
        //Given string str, we need to print the reverse of individual words.
       /* reverseWords("Eicher Motors");
        System.out.println();
        reverseWords1("Motherson Sumi");
        System.out.println();
        reverseWords2("Mahindra Mahindra");
        System.out.println();
        reverseWords3("Bajaj Auto");
        System.out.println();
        reverseWords3("Hero Auto");


        HashMap<String, List<Integer>> map = new HashMap<>();

        map.put("mango", new ArrayList<Integer>(Arrays.asList(0, 4, 8, 9, 12)));

        List<Integer> test = map.get("mango");
        test.remove(0);
        System.out.println(map.toString());*/
        /*String[] arr = {"aB","Bc","CB","Cb","cb","ab","AB","Rv","vr"};
        Map<String, Integer> mp = new HashMap<String, Integer>();
        for(int i = 0;i<arr.length;i++){
            if (mp.containsKey(arr[i].toLowerCase()))
            {
                mp.put(arr[i].toLowerCase(), (mp.get(arr[i].toLowerCase())) + 1 );
            }
            else
            {
                mp.put(arr[i].toLowerCase(), 1 );
            }
        }
        for (int i =0;i<mp.size();i++)
            System.out.println(mp.get(i));*/
       /* List<Integer> a = Arrays.asList(5,7,9,10,16);
        List<Integer> b = a .stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(b);
        List<Integer> c = a.stream().filter(i->i>10).collect(Collectors.toList());
        System.out.println(c);
        Stream<Object> emptyStream = Stream.empty();
        String names[] = {"Varun B", "HUL", "ITC"};
        Stream<String> streamNames = Stream.of(names);
        streamNames.forEach(e -> {
            System.out.println(e);
        });

        List<String> names2 = List.of("Sun Pharma","Cipla","Dr Reddys");
        List<String> names1 = names2.stream().filter(e-> e.startsWith("C")).collect(Collectors.toList());
        System.out.println(names1);

        Stream<Object> so =  Stream.builder().build();
        IntStream is = Arrays.stream(new int[]{1,4,3});
        //Stream is1 = (Stream) Arrays.stream(new int[]{1,4,3});

        List<Integer> numbers1 = List.of(23,1,6,9,50);
        List<Integer> numbers2 = numbers1.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println(numbers2);

        names2.stream().forEach(
                e -> {
                    System.out.println(e);
                }
        );

        names1.stream().forEach(System.out::println);

        numbers1.stream().sorted().forEach(System.out::println);

        Integer int1 = numbers1.stream().min((x,y)->x.compareTo(y)).get();
        System.out.println(int1);

        Integer int2 = numbers1.stream().max((x,y)->x.compareTo(y)).get();
        System.out.println(int2);*/

        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(1,"NCS");
        hm.put(2,"TCS");
        hm.put(3,"Infosys");
        hm.put(4,"Cognizant");
        System.out.println(hm.keySet()+ " " + hm.values());
        for (Map.Entry<Integer,String> entry : hm.entrySet())
            System.out.println(entry.getKey() +  " "+ entry.getValue());
        /*for(int index=0;index<hm.size();index++)
            Set<Integer> keys = hm.keySet();

            System.out.println(hm.keySet().+ " "+ hm.get(index).);*/

       // identity provider
        // transactional annotation
        // authorisation
        // authentication
        // concurrent hashmap
        int n = 9;
        System.out.println(fib(n));
        System.out.println(fib1(n));
        //System.out.println(fib2(n));


    }

}
