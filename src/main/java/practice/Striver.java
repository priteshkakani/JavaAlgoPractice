package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

////Sort an array of 0s, 1s and 2s
////https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?page=1&sortBy=submissions
// GeeksforGeeks
/*Input:
        N = 5
        arr[]= {0 2 1 2 0}
        Output:
        0 0 1 2 2*/

class MyStack
{
    int top;
    int arr[] = new int[1000];

    MyStack()
    {
        top = -1;
    }

    //Function to push an integer into the stack.
    void push(int a)
    {
        int length = arr.length;
        arr[length] = a;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        int length = arr.length;

        return arr[length-1];
    }
}


 //Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class problem7 {
    public void sort012(int a[], int n)
    {
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i =0;i<n;i++) {
            if (a[i] == 0) count0++;
            if (a[i] == 1) count1++;
            if (a[i] == 2) count2++;
        }
        for(int i =0;i<count0;i++){
            a[i]=0;
        }
        for(int i =count0;i<count0+count1;i++){
            a[i]=1;
        }
        for(int i =count0+count1;i<n;i++){
            a[i]=2;
        }
        for(int i =0;i<n;i++) {
            System.out.println(a[i]);
        }
    }


    public static void main(String[] args){
        problem7 problem = new problem7();
        int[] arr = {0,2,1,2,0};
        int n = arr.length;
        //problem.sort012(arr,n);
        int[] arr1 = {1,2,3,6,8};
        int n1 = arr.length;
        ArrayList<Integer> arrList = valueEqualToIndex(arr1,n1);
        System.out.println(arrList);
        System.out.println("Do they contain elements : "+hasArrayTwoCandidates(arr1,5,5));
        int N = 8;
        int[] A = {15,-2,2,-8,1,7,10,23};
        // Given an array having both positive and negative integers.
        // The task is to compute the length of the largest subarray with sum 0.
        int maxLen1 = maxLen(A, N);
        System.out.println("Max Length : "+maxLen1);
        int maxLen2 = maxLen2(A);
        System.out.println("Max Length2 : "+maxLen2);
        // You are given an array of prices where prices[i] is the price of a given stock on an ith day.
        // You want to maximize your profit by choosing a single day to buy one stock
        // and choosing a different day in the future to sell that stock.
        // Return the maximum profit you can achieve from this transaction.
        // If you cannot achieve any profit, return 0.
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max Profit by stock : "+maxProfit(prices));
        int[] prices1 = {7,6,4,3,1};
        System.out.println("Max Profit by stock : "+maxProfit(prices1));
        int[] prices2 = {1,2};
        System.out.println("Max Profit by stock optimised: "+maxProfit1(prices));
        System.out.println("Max Profit by stock optimised: "+maxProfit1(prices1));
        System.out.println("Max Profit by stock optimised: "+maxProfit1(prices2));
        // Sort an array of 0s, 1s and 2s
        // Problem Statement: Given an array consisting of only 0s, 1s, and 2s.
        // Write a program to in-place sort the array without using inbuilt sort functions.
        // ( Expected: Single pass-O(N) and constant space)
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        ListNode head = new ListNode();
        ListNode middleNode = middleNode(head);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode middleNode = new ListNode();
        return middleNode;
    }

    static void sortColors(int[] nums) {
        System.out.println("Before sorting ");
        for(int i =0;i<nums.length;i++)
            System.out.println(" "+nums[i]);
       int[] sorted = new int[nums.length];
       int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i =0;i<nums.length;i++) {
           if(nums[i]==0)
               count0 ++;
           if(nums[i]==1)
               count1++;
           if(nums[i]==2)
               count2++;
        }
        for(int i =0;i<count0;i++) {
            nums[i] = 0;
        }
        for(int i =count0;i<count0+count1;i++) {
            nums[i] = 1;
        }
        for(int i =count0+count1;i<nums.length;i++) {
            nums[i] = 2;
        }
       System.out.println("After sorting: ");
        for(int i =0;i<nums.length;i++)
            System.out.println(" "+nums[i]);
        //Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
        //You must do it in place.
        int[][] matrix = new int[3][3];
        matrix[0][0]=0;
        matrix[0][1]=1;
        matrix[0][2]=2;
        matrix[1][0]=3;
        matrix[1][1]=4;
        matrix[1][2]=5;
        matrix[2][0]=6;
        matrix[2][1]=7;
        matrix[2][2]=8;
        setZeroes(matrix);
        String s = "the sky is blue";
        // Output: "blue is sky the"
        String s1 = "  hello world  ";
        //Output: "world hello"
        String reverseWords = reverseWords(s);
        String reverseWords1 = reverseWords(s1);
        System.out.println("Reversed Words: "+reverseWords);
        System.out.println("Reversed Words1: "+reverseWords1);
    }

    public static String reverseWords(String givenString) {
        String reverseWords = null;
        String[] splitGivenString = givenString.split("\\s+");
        for(String word:splitGivenString) {
            System.out.println(word);
            String reverseWord = reverseWord(word);
            System.out.println(reverseWord);
            reverseWords += reverseWord;
        }
        return reverseWords;
    }
    public static String reverseWord(String givenString) {
       StringBuilder input1 = new StringBuilder();
       input1.append(givenString);
       StringBuilder reverse = input1.reverse();
       return reverse.toString();
    }

    public static void setZeroes(int[][] matrix) {
        System.out.println("Before");
        for(int i =0;i<matrix.length;i++)
            for(int j =0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j] + ' ');
        System.out.println("");
        for(int i =0;i<matrix.length;i++)
            for(int j =0;j<matrix[0].length;j++)
                if(matrix[i][j]==0){

                }
        System.out.println("After");
        for(int i =0;i<matrix.length;i++)
            for(int j =0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j] + ' ');
    }
    static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i =0;i<arr.length;i++)
        {
            if(arr[i] == (i+1)) {
                System.out.println(arr[i]);
                arrList.add(arr[i]);
            }
        }
        return arrList;
    }

    static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashSet<Integer> complementSet = new HashSet<>();
        for(int num : arr){
            int complement = x - num ;
            if(complementSet.contains(complement))
            {
                return true;
            }
            complementSet.add(num);
        }
        return false;
    }

    static int maxLen(int arr[], int N)
    {
        int max_len = 0;
        for (int i =0;i<N;i++) {
            int curr_sum = 0;
            for (int j = i; j < N; j++) {
                curr_sum += arr[j];
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j-i+1);
            }
        }
        return max_len;
    }

    //int[] A = {15,-2,2,-8,1,7,10,23};
    static int maxLen2(int arr[]){
       HashMap<Integer, Integer> hm = new HashMap<>();
       int sum = 0;
       int max_len = 0;

       for (int i = 0;i<arr.length;i++){
           sum += arr[i];
           if(sum==0)
               max_len = i+1;
           //System.out.println(hm);
           // Look at this sum in hashtable.
           Integer prev_i = hm.get(sum);
           // If this sum is seen before, then update max_len if required.
           //System.out.println(prev_i);
           if(prev_i != null) {
               //System.out.println("max_len: " + max_len);
               //System.out.println("i-prev_i: " + (i-prev_i));
               max_len = Math.max(max_len, i - prev_i);
           }
           else // Else put this sum in hash table
               hm.put(sum,i);
       }
       return max_len;
    }
    static int maxProfit(int[] prices){
        int max_profit = 0;
        for(int i =0;i<prices.length-1;i++)
            for(int j =i;j<prices.length;j++)
                max_profit = Math.max(max_profit,prices[j]-prices[i]);
        return max_profit;
    }

    static int maxProfit1(int[] prices){
        if(prices == null || prices.length <= 1)
            return 0;
        int max_profit = 0;
        int minPrice = prices[0];
        for(int i =0;i<prices.length;i++) {
            int currentPrice = prices[i];
            if (currentPrice< minPrice)
                minPrice = currentPrice;
            int potentialProfit = currentPrice - minPrice;
            //System.out.println(potentialProfit);
            max_profit = Math.max(max_profit,potentialProfit);
            //max_profit = Math.max(max_profit,prices[j]-prices[i]);
        }
        return max_profit;
    }
}
