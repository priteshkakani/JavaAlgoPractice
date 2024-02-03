package practice;
// Two number sum
// arr=[3,5,-4,8,11,1,-1,6]
// targetSum = 10
// algoexpert

public class problem8 {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        int n = array.length;
        int[] a = {};
        for(int i =0;i<a.length;i++) {
            System.out.println(a[i]);
        }
        for(int i = 0 ; i < n-1 ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if (array[i]+array[j] == targetSum){
                    a = new int[2];
                    a[0]=array[i];
                    a[1]=array[j];
                    break;
                }
            }
        }
        return a;
    }

    public static void main(String[] args){
        int[] arr = {3,5,-4,8,11,1,-1,6};
        int targetSum = 13;
        int[] answer = problem8.twoNumberSum(arr,targetSum);
        for(int i =0;i<answer.length;i++) {
            System.out.println(answer[i]);
        }
    }
}
