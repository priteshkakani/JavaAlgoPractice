package practice;

public class OptionalPractice {
    public static void main(String args[]){
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if(checkNull.is)
        String word = words[5].toLowerCase();
        System.out.print(word);
    }
}
