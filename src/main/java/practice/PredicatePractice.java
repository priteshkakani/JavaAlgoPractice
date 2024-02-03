package practice;
import java.util.function.Predicate;
public class PredicatePractice {

    static void pred(int number, Predicate<Integer> predicate){
        if(predicate.test(number)){
            System.out.println("Number"+number);
        }
    }
    public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.length() > 10;
        }
    };
    public static void predicate_or(){
        Predicate<String> containsLetterA = p -> p.contains("A");
        String containsA = "And";
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
        System.out.println(outcome);
    }

    public static void main(String[] args){
      /*  Predicate<Integer> lesserthan = i -> (i<18);
        System.out.println(lesserthan.test(10));
        Predicate<Integer> lessthan1 = i -> (i<17);
        System.out.println(lesserthan.test(9));
        Predicate<Integer> lessthan2 = i -> (i<16);
        System.out.println(lessthan2.test(7));
        Predicate<Integer> lessthan3 = i -> (i<15);
        System.out.println(lessthan3.test(14));

        Predicate<Integer> lessthan4 = i -> (i<13);
        System.out.println(lessthan4.test(12));*/

        Predicate<Integer> greaterThanTen = (i) -> i>10;
        Predicate<Integer> lowerThanTwenty = (i) -> i<20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
        // Passing predicate to function
        pred(10,(i)->i>7);
        predicate_or();
    }
}
