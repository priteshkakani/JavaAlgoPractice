package practice;

import java.util.ArrayList;
import java.util.List;

public class Interview4 {
    public static void main(String[] args){
        String givenString = "asjbalksjdfhbbhagnbasfdbgabfb";
        String givenString1 = "abbabbaba";
        Character givenChar = 'b';
        Character givenChar1 = 'a';
        int sum = 0;
        float averageGap =0;
        List<Integer> repeatedIndexes = new ArrayList<>();
        List<Integer> differenceRepeatedIndexes = new ArrayList<>();
        for(int i =0;i<givenString1.length();i++){
            if(givenString1.charAt(i) == givenChar1){
                repeatedIndexes.add(i);
            }
        }
        for(int i =1;i<repeatedIndexes.size();i++){
            differenceRepeatedIndexes.add(repeatedIndexes.get(i)-repeatedIndexes.get(i-1)-1);
        }
        for(int i =0;i<differenceRepeatedIndexes.size();i++){
            sum += differenceRepeatedIndexes.get(i);
        }
        averageGap = (float) sum/differenceRepeatedIndexes.size();
        System.out.println("averageGap: "+averageGap);


    }
}
