package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class Node{
        int key;
        Node next;
        public Node(int key){
            this.key = key;
            next = null;
        }
}

class TryWithResources {
    public static void main(String args[]){
        try(    FileOutputStream fileOutputStream=
                        new FileOutputStream("/home/irfan/scala-workspace/java7-new-features/src/abc.txt")){
            // -----------------------------Code to write data into file--------------------------------------------//
            String msg = "Welcome to javaTpoint!";
            byte byteArray[] = msg.getBytes();  // Converting string into byte array
            fileOutputStream.write(byteArray);  // Writing  data into file
            System.out.println("Data written successfully!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            System.out.println("Finally executes after closing of declared resources.");
        }
    }
}

public class LinkedList1 {

    public class MyIterable implements Iterable<String>{

        private String[] elements;

        @Override
        public Iterator<String> iterator() {
            return new MyIterator();
        }
        private class MyIterator implements Iterator<String>{
            private int index =0;

            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public String next() {
                return elements[index++];
            }
        }
    }


    public static Node newNode(int key){
        return new Node(key);
    }
    interface MyFunction {
        int apply(int x, int y);
    }
    public static void main(String[] s) {

        // AuxiliaryGiven two sorted linked lists consisting of N and M nodes respectively.
        // The task is to merge both of the lists (in place) and return the head of the merged list.
        Node a = new Node(5);
        a.next = new Node(10);
        a.next.next = new Node(15);
        a.next.next.next = new Node(40);

        Node b = new Node(2);
        b.next = new Node(3);
        b.next.next = new Node(20);

        List<Integer> v = new ArrayList<>();
        while(a != null){
            v.add(a.key);
            a = a.next;
        }
        while(b != null){
            v.add(b.key);
            b = b.next;
        }
        Collections.sort(v);
        Node result = new Node(-1);
        Node temp = result;
        for(int i = 0;i<v.size();i++){
            result.next = new Node(v.get(i));
            result = result.next;
        }
        temp = temp.next;
        System.out.println("Resultant merged linked list is : ");
        while(temp != null){
            System.out.println(temp.key + " ");
            temp = temp.next;
        }

        List<String> names = Arrays.asList("ACE","KEI ind","Ramkrishna forgings");
        names.stream().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Integer[] array = numbers.stream().toArray(Integer[]::new);
        //int a1 =2,b1=9;
        Optional<Integer> sum = numbers.stream().reduce((i,j) -> i+j);
        System.out.println("sum: "+sum);

        List<String> uppercasedNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        long numberofNames = names.stream().count();

        boolean anyMatch = numbers.stream().anyMatch(n->n>3);
        Optional<String> firstElement = names.stream().findFirst();
        Optional<String> element = names.stream().findAny();
        System.out.println("firstElement: "+firstElement);

        int[] numbers1 = {1,2,3,4,5,6,7,8,9,10};
        int[] evenNumbers = Arrays.stream(numbers1).filter(n -> n%2 ==0).toArray();

        String[] words = {"idfc first","rbl bank","au bank"};
        String[] upperCasedWords = Arrays.stream(words).map(String::toUpperCase).toArray(String[]::new);

        int[] sortedNumbers = Arrays.stream(numbers1).sorted().toArray();

        int[] distinctNumbers = Arrays.stream(numbers1).distinct().toArray();

        int sum1 = Arrays.stream(numbers1).reduce(0,(i,j)->i+j);

        long count = Arrays.stream(numbers1).count();

        String inputString = "Titan";
        Map<Character,Long> charCountMap = countDuplicates(inputString);
        charCountMap.forEach((character1,count1) -> {
            if(count1 > 1){
                System.out.println("Character : "+ character1 + ", Count: "+count1);
            }
        });

        HashMap<String, Integer> hm = new HashMap();

        for(Map.Entry<String, Integer> entry: hm.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        for(String key: hm.keySet()){
            System.out.println("Key: "+key);
        }
        for(Integer value : hm.values()){
            System.out.println("Value: "+value);
        }
        hm.replace("A",10);
        hm.containsKey("A");
        hm.containsValue(10);
        int val = hm.getOrDefault("A",0);
        hm.isEmpty();

        Runnable runnable = () -> System.out.println("Hello, Lambda!");
        // Using lambda expression with the Comparator interface
        Collections.sort(names, (a1,b1) -> a1.compareTo(b1));

        // Using parallel stream for parallel processing
        int sum2 = numbers.parallelStream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();

        // Using lambda expression with the Stream API
        names.stream().filter(s1 -> s1.startsWith("A")).forEach(System.out::println);

        // Using a lambda expression to implement the functional interface
        MyFunctionalInterface functionalInterface = () -> System.out.println("Executing myMethod");

        // Using the Streams API to perform operations on the collection
        int sum3 = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();

        Optional<String> name = Optional.ofNullable("");

        // Using Optional to handle potentially null values
        String result1 = name.orElse("Unknown");

        List<String> filteredNames = names.stream().filter(name1 -> name1.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(filteredNames);

        List<Integer> nameLengths = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println(nameLengths);

        //// Sort names alphabetically
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());

        List<String> result2 = names.stream()
                .filter(name2 -> name2.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        String concatenatedNames = names.stream().collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);

        long count2 = names.stream().count();
        System.out.println("Count : "+count2);

        boolean anyStartsWithA = names.stream().anyMatch(name2 -> name2.startsWith("A"));

        boolean allLengthGreaterThanTwo = names.stream().anyMatch(name2 -> name2.length() >2);

        boolean noneStartsWithZ = names.stream().noneMatch(name1 -> name1.startsWith("Z"));

        System.out.println(anyStartsWithA + ", " + allLengthGreaterThanTwo + ", " + noneStartsWithZ);

        List<String> words2 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        Map<Character, List<String>> groupedNames = words2.stream().collect(Collectors.groupingBy(name2 -> name2.charAt(0)));

        System.out.println(groupedNames);

        //You want to maximize your profit by choosing a single day to buy one stock
        // and choosing a different day in the future to sell that stock.
        //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

        //Example 1:
        //
        //Input: prices = [7,1,5,3,6,4] Output: 5
        //
        //Explanation: Buy on day 2 (price = 1) and
        //
        //sell on day 5 (price = 6), profit = 6-1 = 5.
        //
        //Note: That buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        //
        //Example 2:
        //
        //Input: prices = [7,6,4,3,1]Output: 0Explanation: In this case, no transactions are
        //
        //done and the max profit = 0.
        int[] prices = {7,1,5,3,6,4};
        int[] prices1 = {5,1};
        int[] prices2 = {1,5};
        int[] prices3 = {7,6,4,3,1};
        System.out.println("Max profit : "+maxProfit(prices));
        System.out.println("Max profit : "+maxProfit(prices1));
        System.out.println("Max profit : "+maxProfit(prices2));
        System.out.println("Max profit : "+maxProfit(prices3));
        int[] arr = {4,4,4,4,4,5,6,7,0,1,1,1,1,1,1,1,2,2,2,2,2,2};
        System.out.println("MIN ELEMENT : "+search(arr));
        // Given a sorted array of distinct integers and a target value,
        // return the index if the target is found.
        // If not, return the index where it would be if it were inserted in order.
        // You must write an algorithm with O(log n) runtime complexity.

    }

    public int searchInsert(int[] nums, int target) {
        return 0;
    }

    public static int search(int[] arr){
        int left = 0, right = arr.length-1;
        while(left < right){
            int mid = (left +right)/2;
            if(arr[mid] > arr[right])
                left = mid+1;
            else
                right = mid;
        }
        return arr[left];
    }
   /* public static int search(int[] arr, int left, int right, minElement){
        if(left > right)
            return minElement;
        System.out.println("Inside solution");
        int middle = (left+right)/2;
        int minElement = Integer.MAX_VALUE;
        int element1 = Integer.MAX_VALUE;
        int element2 = Integer.MAX_VALUE;
        if(arr==null || arr.length ==0)
            return minElement;
        if(arr.length == 1)
            return arr[0];

    //if(middle > 0 && arr[middle] < arr[middle-1])
    //	return arr[middle];
            if(arr[left] > arr[right]){
            element1 = search(arr, left, middle-1, minElement);
            } else {
            element2 = search(arr, middle+1, right, minElement);
        }
        minElement = Math.min(element1, minElement);
        minElement = Math.min(element2, minElement);
    }
    return minElement;
    }*/
    static int maxProfit(int[] arr){
        if (arr == null || arr.length < 2)
            return 0;
        int maxProfit = 0;
        int buyIndex = 0, sellIndex = 1;
        for(int i =1;i<arr.length;i++){
            if(arr[i] < arr[buyIndex] || arr[i] >= arr[sellIndex]){
                if(arr[i] < arr[buyIndex])
                    buyIndex = i;
                if(arr[i] > arr[sellIndex])
                    sellIndex = i;
                maxProfit = arr[sellIndex] - arr[buyIndex];
            }
        }
        return maxProfit;
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        void myMethod();
    }

    int calculate(MyFunction function, int a, int b) {
        return function.apply(a, b);
    }
    // While Java is not inherently immutable, functional programming encourages immutability.
    // You can achieve immutability by using the final keyword for variables and creating immutable classes.
    final class ImmutablePerson {
        private final String name;

        public ImmutablePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static Map<Character,Long> countDuplicates(String input){
        return input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}

