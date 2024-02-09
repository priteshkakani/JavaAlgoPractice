package practice;

import java.util.*;
import java.util.stream.Collectors;

public class FruitJuiceMix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int friends = scanner.nextInt();

        for (int friend = 0; friend < friends; friend++) {
            int m = scanner.nextInt();
            int[] calories = new int[m];
            Map<Character, Integer> calorieMap = new HashMap<>();

            for (int i = 0; i < m; i++) {
                calories[i] = scanner.nextInt();
            }

            String fruits = scanner.next();
            for (int i = 0; i < m; i++) {
                calorieMap.put(fruits.charAt(i), calories[i]);
            }

            int targetCalories = scanner.nextInt();

            List<Character> result = findFruitJuiceMix(calorieMap, targetCalories);

            if (result.isEmpty()) {
                System.out.println("SORRY, YOU JUST HAVE WATER");
            } else {
                for (char fruit : result) {
                    System.out.print(fruit);
                }
                System.out.println();
            }
        }
    }

    private static List<Character> findFruitJuiceMix(Map<Character, Integer> calorieMap, int targetCalories) {
        List<Character> result = new ArrayList<>();
        backtrack(calorieMap, targetCalories, result, new StringBuilder(), 'a');
        return result;
    }

    private static void backtrack(Map<Character, Integer> calorieMap, int targetCalories, List<Character> result, StringBuilder current, char currentFruit) {
        if (targetCalories == 0) {
            result.addAll(current.toString().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
            return;
        }

        if (currentFruit > 'z') {
            return;
        }

        for (int i = 0; i <= targetCalories / calorieMap.get(currentFruit); i++) {
            for (int j = 0; j < i; j++) {
                current.append(currentFruit);
            }

            backtrack(calorieMap, targetCalories - i * calorieMap.get(currentFruit), result, current, (char) (currentFruit + 1));

            for (int j = 0; j < i; j++) {
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
