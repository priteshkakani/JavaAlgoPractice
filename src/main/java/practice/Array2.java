package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Array2 {
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

    static int linearSearch(int[] arr, int size, int key) {
        if (size == 0) {
            return -1;
        }
        else if(arr[size-1] == key){
            return size -1;
        }
        return linearSearch(arr,size-1,key);
    }

    static void findDuplicates(int[] arr1){

    }

    static int[] sortedSquaredArray(int[] arr2){
        int[] arr3 = new int[arr2.length];
        for(int i =0;i<arr2.length;i++)
            arr3[i] = arr2[i]*arr2[i];
        Arrays.sort(arr3);
        return arr3;
    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results){
        return "";
    }

    static int nonConstructibleChange(int[] arr2){
        if(arr2.length==0) return 1;
        Arrays.sort(arr2);
        for(int i = 0;i<arr2.length;i++){

        }
        return 0;
    }

    static int[][] transposeMatrix(int[][] arr2){
        int [][] matrix = new int[arr2.length][arr2.length];
        int height = arr2.length;
        //int width = arr2[0].
        return matrix;
    }

    /*static int[] searchRotatedArray(int[] arr2){

    }

    static int bestTimeToBuySellStock(int[] arr1){

    }*/

    static void zigZagFashion(int[] arr1, int n){
        // sort Array using sort function
        Arrays.sort(arr1);
        System.out.println("Sorted array for Zig Zag Fashion : ");
        for(int j=0;j<n;j++)
            System.out.print(" " + arr1[j]);
        // Traverse array from 1 to N-1
        for(int i = 1;i<= arr1.length-2;i=i+2){
            // swap current element with next element
            int temp = arr1[i];
            arr1[i] = arr1[i+1];
            arr1[i+1] = temp;
        }
        System.out.println("\n Zig Zag Fashion : ");
        for(int j=0;j<n;j++)
            System.out.print(" " + arr1[j]);
    }

    /*static void List<Integer[]> threeNumberSum(int[] array, int targetSum){
        return new 

    }*/

    // recursion
    static boolean check(int n, int[] arr, int target, ArrayList<Integer> triplet){
        if(target == 0 && triplet.size() == 3){
            System.out.println(triplet.get(0) + " "+ triplet.get(1) + " " +triplet.get(2));
            return true;
        }
        if(n==0 || target < 0 || triplet.size() == 3)
            return false;
        triplet.add(arr[n-1]);
        boolean a = check(n-1,arr,target - arr[n-1],triplet);
        triplet.remove(triplet.size() - 1);
        boolean b = check(n-1,arr,target,triplet);
        return a | b;
    }

    // returns true if there is triplet with sum equal to sum present in A[]
    // Also print the triplet.
    static boolean find3Numbers(int A[], int arr_size, int sum){
        for(int i =0;i<arr_size - 2;i++){
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i+1;j<arr_size;j++){
                if(s.contains(curr_sum - A[j])){
                    System.out.print("Triplet is "+ A[i] + ", " + A[j] + ", "+ (curr_sum - A[j]));
                    return true;
                }
                s.add(A[j]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        Array2 p = new Array2();
        int x = 171;
        System.out.println(p.isPalindrome(x));
        int arr[] = {5,15,6,9,4};
        int key = -2;
        //int index = linearSearch(arr,arr.length,key);
        //if(index != -1)
        //    System.out.println("The Element " + key +" is found at "+ index +" index of given array");
        //else
        //    System.out.println("The Element "+ key+" is not found");
        int arr1[] = {5,15,6,9,4};
        //findDuplicates(arr1);

        int arr2[] = {1,2,3,6,8,9};
        //int[] arr3 = sortedSquaredArray(arr2);
        //for(int i =0;i<arr3.length;i++)
        //    System.out.print(arr3[i]+" ");
        System.out.println();
        int arr21[] = {-3,-2,-1};
        //int[] arr31 = sortedSquaredArray(arr21);
        //for(int i =0;i<arr31.length;i++)
        //    System.out.print(arr31[i]+" ");

        // Tournament Winner
        /*ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.get(0).add()
                [
                ["HTML","C#"],["C#","Python"],["Python","HTML"]];

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        String winner = tournamentWinner(competitions,results);*/

        // Non Constructible change
        int[] coins = {5,7,1,1,2,3,22};
        //int ans = nonConstructibleChange(coins);
        //System.out.println("Non Constructible change : "+ans);

        // Transpose Matrix
        int [][] matrix = {{1,2},{3,4}};
        int[][] matrix1 = transposeMatrix(matrix);

        //searchRotatedArray();
        int[] arr5 = {7,1,5,3,6,4};
        //int profit = bestTimeToBuySellStock(arr1);
        //System.out.println(profit);
        int[] arr12 = {7,1,5,3,6,4};
        int n = arr12.length;
        //zigZagFashion(arr12,n);
        // 3 Number Sum
        int targetsum = 12;
        ArrayList<Integer> triplet = new ArrayList<>();
        //threeNumberSum(arr12, targetsum);
        if (!check(n,arr12,targetsum,triplet)){
            System.out.println("does not exist");
        }
    }
}
