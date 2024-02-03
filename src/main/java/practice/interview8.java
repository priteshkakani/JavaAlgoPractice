package practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Given a String You have to find the first and Last index of Longest Substring with Identical chars in the string
input: aaaaaaaaaddfsgsgsgwwww
output : 0, 8
* */
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}

public class interview8 {
    interview8 interview8;
    // Functional interface with a single abstract method

    private int countString(String a, String b){
        int sub = 0;
        while (a.contains(b)) {
            sub++;
            a = a.replaceFirst(b, " ");
        }
        return sub;
    }

    public static void main(String[] args){
        String s = "aaaaaaaaaddfsgsgsgwwwwa";
        List<Character> t = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        // Convert into HashMap

        // Find Value Array

        // Find Key corresponding to that value.

        // Search that key in Array and find 1rst and

        // a9d2f1s1g1w4a1
        // index : 0,8
        for(int i =0, count1=0;i<s.length();i++) {
            //t.add(s[i]);
            count.add(++count1);
        }
        List<Integer> prices = Arrays.asList(1750,1850,1000);
        Stream<Integer> pricesStream = prices.stream();
        System.out.println(pricesStream.count());
        Stream<Integer> pricesStream1 = prices.stream();
        pricesStream1.forEach(n -> System.out.println(n));

        List<String> words = Arrays.asList("apple", "banana", "orange");

        // Using lambda expression
        words.forEach(word -> System.out.println(word));
        
        // Using static method reference
        words.forEach(System.out::println);

        // Using instance method reference
        words.forEach(String::length);

        List<String> uppercasedNames = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Filter names with length greater than 3
        List<String> filteredNames = words.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        // Map names to their lengths
        List<Integer> nameLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        Optional<String> firstElement = words.stream().findFirst();

        long numberOfNames = words.stream().count();

        // Using lambda expression
        Predicate<String> startsWithA = s1 -> s1.startsWith("A");

        // Using instance method reference
        Predicate<String> startsWithARef = "Apple"::startsWith;

        System.out.println(startsWithA.test("Apple"));        // Output: true
        System.out.println(startsWithARef.test("Apple"));     // Output: true

        // Using lambda expression
        Supplier<String> supplier = () -> new String();

        // Using constructor reference
        Supplier<String> supplierRef = String::new;

        // Using lambda expression to implement the abstract method
        MyFunctionalInterface myLambda = () -> System.out.println("Lambda implementation");

        // Calling the method through the functional interface
        myLambda.myMethod();

        int sum = Arrays.stream(new int[]{1, 2, 3})
                .filter(i -> i >= 2)
                .map(i -> i * 3)
                .sum();

        System.out.println("Sum : "+sum);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> sum1 = numbers.stream().reduce((a, b) -> a + b);

        Integer[] array = numbers.stream().toArray(Integer[]::new);

        boolean anyMatch = numbers.stream().anyMatch(n -> n > 3);

        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<List<String>> listOfLists = List.of(
                List.of("apple", "orange"),
                List.of("banana", "grape"),
                List.of("pear", "kiwi")
        );

        // FlatMap to a single stream of fruits
        List<String> fruits = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        // Distinct numbers
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // Sorted numbers
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        // Print each name before converting to uppercase
        List<String> uppercasedNames1 = words.stream()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> uniqueLetters = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDateTime start = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2023, 12, 31, 23, 59);
        Duration duration = Duration.between(start, end);
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 1);
        Period period = Period.between(startDate, endDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        interview8 interview81 = new interview8();
        interview8 interview82 = new interview8();
        interview81.interview8 = interview81;
        interview82.interview8 = interview82;
        interview81 = null;
        interview82 = null;
        // System.gc();
        Runtime.getRuntime().gc();
        System.out.println("Main method is done");


        List<String> input = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        input.add("ahmedabad");
        input.add("ahmednagar");
        input.add("ahmed");
        /*HashMap<String, List<String>> dictionary = new HashMap<>();
        dictionary.put("a");
        dictionary.put("ah",);
        dictionary.put("ahm",);
        dictionary.put("ahme",);
        dictionary.put("ahmed",);
        dictionary.put("ahmedn",);
        dictionary.put("ahmeda",);*/
        int flag = -1;
        String inputUser = "ahm";
        /*for(int j=0;j<inputUser.length();j++) {
            for(int i=0;i<input.size();i++){
                if((input.get(i).charAt(j)) == (inputUser.charAt(j))) {
                    tempList.add(input.get(i));
                    dictionary.put(String.valueOf(inputUser.charAt(j)), tempList);
                }
            }

        }*/
        System.out.println("check : "+check());

    }

    private static int check(){
        try{
            return 1;
        } finally {
            return 3;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method is called.");
    }
}
