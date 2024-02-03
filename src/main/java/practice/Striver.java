package practice;
import java.util.*;
import java.util.stream.Collectors;

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

class MinStack {

    private Stack<Integer> mainStack = null;
    private Stack<Integer> minStack = null;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(!mainStack.isEmpty()){
            if(mainStack.peek().equals(minStack.peek())){
                minStack.pop();
            }
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        /*int min = Integer.MAX_VALUE;
        for(int i =0;i<stack.size();i++){
            min = Math.min(min, stack.get(i));
        }*/
        if(!minStack.isEmpty()){
            return minStack.peek();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

}

class RecentCounter {

    private Queue<Integer> requests;
    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Remove requests that are outside time frame [t-3000, t]
        while(!requests.isEmpty() && requests.peek() < t - 3000){
            requests.poll();
        }
        requests.add(t);
        // Return number of requests in timeframe.
        return requests.size();
    }
}

// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
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
 class problem7 {
     public void sort012(int a[], int n) {
         // code here
         int count0 = 0;
         int count1 = 0;
         int count2 = 0;
         for (int i = 0; i < n; i++) {
             if (a[i] == 0) count0++;
             if (a[i] == 1) count1++;
             if (a[i] == 2) count2++;
         }
         for (int i = 0; i < count0; i++) {
             a[i] = 0;
         }
         for (int i = count0; i < count0 + count1; i++) {
             a[i] = 1;
         }
         for (int i = count0 + count1; i < n; i++) {
             a[i] = 2;
         }
         for (int i = 0; i < n; i++) {
             System.out.println(a[i]);
         }
     }

     public static void main(String[] args) {
         problem7 problem = new problem7();
         int[] arr = {0, 2, 1, 2, 0};
         int n = arr.length;
         //problem.sort012(arr,n);
         int[] arr1 = {1, 2, 3, 6, 8};
         int n1 = arr.length;
         //ArrayList<Integer> arrList = valueEqualToIndex(arr1,n1);
         //System.out.println(arrList);
         //System.out.println("Do they contain elements : "+hasArrayTwoCandidates(arr1,5,5));
         int N = 8;
         int[] A = {15, -2, 2, -8, 1, 7, 10, 23};
         // Given an array having both positive and negative integers.
         // The task is to compute the length of the largest subarray with sum 0.
         int maxLen1 = maxLen(A, N);
         //System.out.println("Max Length : "+maxLen1);
         int maxLen2 = maxLen2(A);
         // System.out.println("Max Length2 : "+maxLen2);
         // You are given an array of prices where prices[i] is the price of a given stock on an ith day.
         // You want to maximize your profit by choosing a single day to buy one stock
         // and choosing a different day in the future to sell that stock.
         // Return the maximum profit you can achieve from this transaction.
         // If you cannot achieve any profit, return 0.
         int[] prices = {7, 1, 5, 3, 6, 4};
         //System.out.println("Max Profit by stock : "+maxProfit(prices));
         int[] prices1 = {7, 6, 4, 3, 1};
         //System.out.println("Max Profit by stock : "+maxProfit(prices1));
         int[] prices2 = {1, 2};
         //System.out.println("Max Profit by stock optimised: "+maxProfit1(prices));
         //System.out.println("Max Profit by stock optimised: "+maxProfit1(prices1));
         //System.out.println("Max Profit by stock optimised: "+maxProfit1(prices2));
         // Sort an array of 0s, 1s and 2s
         // Problem Statement: Given an array consisting of only 0s, 1s, and 2s.
         // Write a program to in-place sort the array without using inbuilt sort functions.
         // ( Expected: Single pass-O(N) and constant space)
         int[] nums = {2, 0, 2, 1, 1, 0};
         //sortColors(nums);
         ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(4);
         ListNode middleNode = middleNode(head);
        /*
        if(middleNode == null)
            System.out.println("List is empty");
        else
            System.out.println("LinkedList middleNode value : "+middleNode.val);

         */
         String s = "the sky is blue";
         // Output: "blue is sky the"
         String s1 = "  hello world  ";
         //Output: "world hello"
         //String reverseWords = reverseWords(s);
         //String reverseWords1 = reverseWords(s1);
         //System.out.println("Reversed Words: "+reverseWords);
         //System.out.println("Reversed Words1: "+reverseWords1);

         // Longest Palindromic Substring
         // Given a string s, return the longest palindromic substring in s.
         System.out.println("longestPalindrome : " + longestPalindrome("babad"));
         System.out.println("longestPalindrome1 : " + longestPalindrome("cbbd"));
         //Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
         //You must do it in place.
         int[][] matrix = new int[3][3];
         matrix[0][0] = 0;
         matrix[0][1] = 1;
         matrix[0][2] = 2;
         matrix[1][0] = 3;
         matrix[1][1] = 4;
         matrix[1][2] = 5;
         matrix[2][0] = 6;
         matrix[2][1] = 7;
         matrix[2][2] = 8;
         setZeroes(matrix);
         // Given the head of a singly linked list, reverse the list, and return the reversed list.
         ListNode head1 = new ListNode(5);
         head1.next = new ListNode(4);
         head1.next.next = new ListNode(3);
         head1.next.next.next = new ListNode(2);
         head1.next.next.next.next = new ListNode(1);
         ListNode reverseNode = reverseList(head1);
         System.out.println("Reversed LinkedList : ");
         for (; reverseNode != null; reverseNode = reverseNode.next) {
             System.out.println(" " + reverseNode.val);
         }
         // Repeat and Missing Number Array
         int[] A1 = {3, 1, 2, 5, 3};
         int[] B = repeatedNumber(A1);

         //Write a function to find the longest common prefix string amongst an array of strings.

         // Given an array of N integers.
         // Every number in the array except one appears twice.
         // Find the single number in the array.
         // Input: nums = [1,1,2,3,3,4,4,8,8]
         // Output: 2

         // Max meetings that can be accomodated
         // There is one meeting room in a firm.
         // There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
         // What is the maximum number of meetings that can be accommodated in the meeting room
         // when only one meeting can be held in the meeting room at a particular time?
         int N1 = 6;
         int start[] = {1, 3, 0, 5, 8, 5};
         int end[] = {2, 4, 6, 7, 9, 9};
         int meetings = maxMeetings(start, end, n);
         System.out.println("Meetings : " + meetings);

         // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
         // You have to rotate the image in-place,
         // which means you have to modify the input 2D matrix directly.
         // DO NOT allocate another 2D matrix and do the rotation.
         int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
         printMatrix(matrix);
         rotate90Clockwise(matrix);
         System.out.println("Rotated matrix : ");
         printMatrix(matrix);
         // Given an integer array nums, find the subarray with the largest sum, and return its sum.
         int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
         int largestSum = maxSubArray(nums1);
         System.out.println("LargestSum : " + largestSum);
         TreeNode root = new TreeNode(3);
         int val = 3;
         //TreeNode node = searchBST(root, val);

         // Write a function to find the longest common prefix string amongst an array of strings.
         //If there is no common prefix, return an empty string "".
         //Input:
         String[] strs = {"flower", "flow", "flight"};
         //Output: "fl"
         String output = longestCommonPrefix(strs);
         System.out.println("LongestCommonPrefix Output : " + output);
         String output1 = longestCommonPrefix1(strs);
         System.out.println("LongestCommonPrefix Output : " + output1);
         //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
         //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
         // typically using all the original letters exactly once.
         String s3 = "anagram", t = "nagaram";
         boolean b = isAnagram(s3, t);
         System.out.println("Anagram : " + b);
         boolean b1 = isAnagram1(s3, t);
         //System.out.println("Anagram1 : "+b1);
         // Longest Palindromic Substring
         String given2 = "babad";
         //String longestPalindrome1 = longestPalindrome(given2) ;
         // Given an array nums of size n, return the majority element.

         // Majority Element
         // The majority element is the element that appears more than ⌊n / 2⌋ times.
         // You may assume that the majority element always exists in the array.
         int[] nums4 = {2, 2, 1, 1, 1, 2, 2};
         //System.out.println("Majority Element: "+majorityElement(nums4));
         ListNode listnode = new ListNode();
         ListNode list1 = new ListNode();
         list1 = new ListNode(1);
         list1.next = new ListNode(2);
         list1.next.next = new ListNode(4);
         ListNode list2 = new ListNode();
         list2 = new ListNode(1);
         list2.next = new ListNode(3);
         list2.next.next = new ListNode(4);
         //mergeTwoLists( list1, list2);
         // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
         //System.out.println("Majority Element List: "+majorityElement2(nums4));
         int[] nums5 = {1, 2};
         //System.out.println("Majority Element List: "+majorityElement2(nums5));
         int[] nums6 = {3, 2, 3};
         //System.out.println("Majority Element List: "+majorityElement2(nums6));

         // You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
         // and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
         // Merge nums1 and nums2 into a single array sorted in non-decreasing order.
         // The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
         // To accommodate this, nums1 has a length of m + n,
         // where the first m elements denote the elements that should be merged,
         // and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

         // Given the head of a linked list, remove the nth node from the end of the list and return its head.
         //ListNode ln = removeNthFromEnd(head, 2);
         //System.out.println("removeNthFromEnd: "+ln.val);

         // Given an integer array nums where the elements are sorted in ascending order,
         // convert it to a height-balanced binary search tree.
         int[] nums3 = {-10, -3, 0, 5, 9};
         //TreeNode bst = sortedArrayToBST(nums3);
         //System.out.println("sortedArrayToBST: "+bst.val);

         // You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
         // and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
         //Merge nums1 and nums2 into a single array sorted in non-decreasing order.
         //The final sorted array should not be returned by the function,
         // but instead be stored inside the array nums1.
         // To accommodate this, nums1 has a length of m + n,
         // where the first m elements denote the elements that should be merged,
         // and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
         //int[] nums10 = {0, 1, 6};
         //int m1 = nums10.length;
         int[] nums11 = {2, 3, 3, 8};
         int m2 = nums11.length;
         //merge(nums10, m1, nums11, m2);
         int[] nums7 = {1, 3, 4, 2, 2};
         System.out.println("Duplicate : " + findDuplicate(nums7));
         int[] nums8 = {3, 1, 3, 4, 2};
         System.out.println("Duplicate1 : " + findDuplicate(nums8));
         int[] nums9 = {2, 2, 0, 2, 2};
         System.out.println("Duplicate2 : " + findDuplicate(nums9));
         // Find the Index of the First Occurrence in a String
         // Given two strings needle and haystack,
         // return the index of the first occurrence of needle in haystack,
         // or -1 if needle is not part of haystack.
         String haystack = "sadbutsad", needle = "sad";
         System.out.println("First Occurence : " + strStr(haystack, needle));
         String haystack1 = "leetcode", needle1 = "leeto";
         System.out.println("First Occurence : " + strStr(haystack1, needle1));
         String haystack2 = "hello", needle2 = "ll";
         System.out.println("First Occurence : " + strStr(haystack2, needle2));

         // Given two strings a and b,
         // return the minimum number of times you should repeat string a so that string b is a substring of it.
         // If it is impossible for b to be a substring of a after repeating it, return -1.
         //Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
         String a = "abcd", b2 = "cdabcdab";
         System.out.println("Min no of times matching : " + repeatedStringMatch(a, b2));

         // Roman to Integer

         //  Pattern Searching Using Z-Algorithm
         String s4 = "aabdchabd";
         String pattern = "abd";
         List<Integer> li = search(s4, pattern);
         System.out.println("Search:");
         if (li == null)
             System.out.println("Search: No");
         else {
             for (int i : li)
                 System.out.println(i);
         }

         // Given a string A. The only operation allowed is to insert characters at the beginning of the string.
         //Find how many minimum characters are needed to be inserted to make the string a palindrome string.
         String abc = "abc";
         System.out.println("Min_Characters: " + solve(abc));
         // Given a list arr of N integers, return sums of all subsets in it.
         ArrayList<Integer> arr2 = new ArrayList<>();
         arr2.add(2);
         arr2.add(3);
         ArrayList<Integer> intarr = subsetSums(arr2, 2);
         //Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
         //The solution set must not contain duplicate subsets. Return the solution in any order.
         int[] numss = {1, 2, 2};
         subsetsWithDup(numss);
         // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
         System.out.println("Roman to Int : " + romanToInt("MCMXCIV"));
         // Kth Largest Element in an Array
         // Given an integer array nums and an integer k, return the kth largest element in the array.
         //Note that it is the kth largest element in the sorted order, not the kth distinct element.
         //Can you solve it without sorting?
         int[] nums12 = {3, 2, 1, 5, 6, 4};
         int k = 2;
         int k1 = findKthLargest(nums, k);
         // Given an integer array, find the equilibrium index in it.
         //For an array A consisting of n elements, index i is an equilibrium index
         // if the sum of elements of subarray A[0…i-1] is equal to the sum of elements of subarray A[i+1…n-1]. i.e.
         //(A[0] + A[1] + … + A[i-1]) = (A[i+1] + A[i+2] + … + A[n-1]), where 0 < i < n-1
         //Similarly, 0 is an equilibrium index if A[1] + A[2] + … + A[n-1] sums to 0 and
         // n-1 is an equilibrium index if A[0] + A[1] + … + A[n-2] sums to 0.

         // Given an array nums of distinct integers, return all the possible permutations.
         // You can return the answer in any order.
         int[] nums13 = {1, 2, 3};
         List<List<Integer>> permutations = permute(nums);
         for (List<Integer> permutation : permutations) {
             System.out.println(permutation);
         }
         int[] nums15 = new int[]{3, 2, 2, 3};
         //System.out.println("Remove Duplicates : "+removeDuplicates(nums15));
         // Given an integer array nums and an integer val,
         // remove all occurrences of val in nums in-place.
         // The order of the elements may be changed.
         // Then return the number of elements in nums which are not equal to val.
         // Consider the number of elements in nums which are not equal to val be k, to get accepted,
         // you need to do the following things:
         // Change the array nums such that the first k elements of nums contain the elements
         // which are not equal to val.
         // The remaining elements of nums are not important as well as the size of nums.
         // Return k.
         //System.out.println(removeElement({3,2,2,3}, 3) ;
         String ransomNote = "aa";
         String magazine = "aab";
         System.out.println("canConstruct: "+canConstruct( ransomNote, magazine));

         // Given two strings s and t, determine if they are isomorphic.
         // Two strings s and t are isomorphic if the characters in s can be replaced to get t.
         // All occurrences of a character must be replaced with another character
         // while preserving the order of characters.
         // No two characters may map to the same character, but a character may map to itself.
         System.out.println(isIsomorphic("paper","title"));

         // Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
         // A subsequence of a string is a new string that is formed from the original string
         // by deleting some (can be none) of the characters
         // without disturbing the relative positions of the remaining characters.
         // (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
         System.out.println("isSubsequence: "+isSubsequence("ace","tabcde"));
         System.out.println("isSubsequence: "+isSubsequence("axc","ahbgdc"));

         // Given a pattern and a string s, find if s follows the same pattern.
         // Here follow means a full match, such that there is a bijection between
         // a letter in pattern and a non-empty word in s.
         System.out.println(" " + wordPattern("",""));

         // Contains Duplicate II
         // Given an integer array nums and an integer k,
         // return true if there are two distinct indices i and j in the array such that
         // nums[i] == nums[j] and abs(i - j) <= k.

        ListNode ln3 = addTwoNumbers(list1, list2);
        int left = 1, right = 3;
        printList(reverseBetween( head,  left,  right));
        int[] digits = new int[]{9};
        int[] arr11 = plusOne(digits) ;
        for(int i : arr11){
            System.out.print(i+" ");
        }
        //String[] strs1 = "";
        //List<List<String>> arr10 = groupAnagrams(strs1) ;
         System.out.print("sqrt : "+mySqrt(8));
        // Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
         double x = 2.10000;
         int n2 = 3;
         System.out.println(-5/2);
         System.out.println("\n Power of x to n : "+myPow(x,n2));
         TreeNode tn = new TreeNode();
         countNodes(tn);

         // Search in Rotated Sorted Array
         int[] nums10 = {4,5,6,7,0,1,2};
         int target = 0;
         System.out.println("***searchInRotatedSortedArray : "+searchInRotatedSortedArray(nums10, target));

         ListNode givenList = new ListNode(1);
         givenList.next = new ListNode(2);
         givenList.next = new ListNode(3);
         givenList.next = new ListNode(4);
         ListNode ln = reverseLinkedList(head);
         System.out.println("Reversed Linked List : ");
         printList(ln);
         int[] nums33 = {1,2,3};
         int[] nums2 = {2,4,6};
         List<List<Integer>> lol = findDifference(nums33, nums2);
         printList(list1);
         ListNode list3 = deleteMiddle(list1);
         printList(list3);
         detectCycle(head);
         int[] nums35 = new int[]{1, 7, 3, 6, 5, 6};
         System.out.println("\n Pivot :"+pivotIndex(nums35));
         // Merge Strings Alternately
         System.out.println("Merge Strings : "+mergeAlternately( "Muthoot", "Bajaj") );
         System.out.println("Sum : "+sumNumbers(root));
         int[] preorder = {3,9,20,15,7};
         int[] inorder = {9,3,15,20,7};
         TreeNode tn2 = buildTree( preorder, inorder);
         int[] flowerbed = new int[]{1,0,0,0,1};
         int n36 = 1;
         System.out.println("canPlaceFlowers: "+canPlaceFlowers(flowerbed, n36));
         String s10 = "hello";
         System.out.println("reverseVowels: "+reverseVowels(s));
         TreeNode root1 = new TreeNode();
         TreeNode root2 = new TreeNode();
         TreeNode tn1 = mergeTrees( root1, root2);
         System.out.println("HashMap: ");
          HashMap<Integer, String> hm = new HashMap<>();
          hm.put(1,"Eicher");
          hm.put(2,"Tata");
          hm.put(2,"Hero");
          System.out.println(hm.values());
          for(Map.Entry<Integer, String> map : hm.entrySet()){
            System.out.println(map.getKey() + " "+ map.getValue());
          }

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
     public static void printTree(TreeNode root){
         if(root != null) {
             System.out.println(root.val);
             printTree(root.left);
             printTree(root.right);
         }
     }
     public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return original;
     }
     public static TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
         if(node1 == null)
             return node2;
         if(node2 == null)
             return node1;
         TreeNode mergedRoot = new TreeNode(node1.val + node2.val);
         mergedRoot.left = mergeTrees(node1.left, node2.right);
         mergedRoot.right = mergeTrees(node1.right, node2.right);
         return mergedRoot;
     }
     public static String reverseVowels(String s) {
        String reverse = "";
        int len = s.length();
        for(int i =0;i<len;i++){
            if(s.charAt(i) == s.charAt(len-1) && (s.charAt(i) == 'a' ||
                    s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i' ||
                    s.charAt(i) == 'o' ||
                    s.charAt(i) == 'u') ) {
                char c = s.charAt(i);
                //s.charAt(i) = s.charAt(len - i);
                //s.charAt(s.length() - i) = c;
            }
        }
        return reverse;
     }

     public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int i =0;
        while(i<flowerbed.length){
            if(flowerbed[i] == 0
                    && (i ==0 || flowerbed[i-1] ==0 )
                    && (i == flowerbed.length -1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                count++;
                i +=2;
            }
            i++;
        }
        return count >= n;
     }
     public static boolean canPlaceFlowers(int[] flowerbed, int n) {
         int newflowers = 0;
         /*for(int i =0;i<flowerbed.length;i=i+1){
             if(( i==0 || flowerbed[i-1] == 0 ) &&
                     flowerbed[i] == 0 &&
                     i == flowerbed.length-1 || flowerbed[i+1] == 0){
                 newflowers++;
                 flowerbed[i] = 1;
                 i=i+1;
             }
         }*/
         return n<=newflowers;
     }
     public static TreeNode buildTree(int[] preorder, int[] inorder){
         return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
     }

     private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexInorder = 0;
        for(int i = inStart;i <= inEnd; i++){
            if(inOrder[i] == rootValue){
                rootIndexInorder = i;
                break;
            }
        }
        int leftSubtreeSize = rootIndexInorder - inStart;
        root.left = buildTreeHelper(preorder, preStart+1, preStart+leftSubtreeSize,
                inOrder, inStart, rootIndexInorder-1);
        root.right = buildTreeHelper(preorder, preStart+leftSubtreeSize+1, preEnd, inOrder,
                rootIndexInorder+1, inEnd);
        return root;
     }
     public static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
     }

     private static int sumNumbersHelper(TreeNode node, int currentSum){
        if(node == null){
            return 0;
        }
        currentSum = currentSum * 10 + node.val;
        if(node.left == null && node.right == null){
            return currentSum;
        }
        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);
        return leftSum + rightSum;
     }
     public static String mergeAlternately(String word1, String word2) {
         StringBuilder merged = new StringBuilder();
         int i=0, j=0;
         while(i < word1.length() && j < word2.length())
         {
             merged.append(word1.charAt(i++));
             merged.append(word2.charAt(j++));
         }
         while(i < word1.length()){
             merged.append(word1.charAt(i++));
         }
         while(j < word2.length()){
             merged.append(word2.charAt(j++));
         }
         return merged.toString();
     }
     public static int pivotIndex(int[] nums) {
         int n = nums.length;
         int[] leftSum = new int[n];
         int[] rightSum = new int[n];
         leftSum[0] = 0;
         for(int i =1;i<=n-1;i++){
             leftSum[i] = leftSum[i-1] + nums[i-1];
         }
         System.out.println();
         for(int i =0;i<nums.length;i++) {
             System.out.print(" "+leftSum[i]);
         }
         rightSum[n-1] = 0;
         for(int i =n-2;i>=0;i--){
             rightSum[i] = rightSum[i+1] + nums[i+1];
         }
         System.out.println();
         for(int i =0;i<nums.length;i++) {
             System.out.print(" "+rightSum[i]);
         }
         for(int pivot=0;pivot<nums.length;pivot++){
             if(leftSum[pivot] == rightSum[pivot]){
                 return pivot;
             }
         }
         return -1;
     }
     public static boolean detectCycle(ListNode head) {
        return true;
     }
     public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode prev = null;
        ListNode middle = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = middle;
            middle = middle.next;
            fast = fast.next.next;
        }
        // Delete middle node (slow)
        if(prev != null) {
            prev.next = middle.next;
        } else {
            // If head itself is middle node
            head = head.next;
        }
        return head;
     }

     public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
         List<List<Integer>> lol = new ArrayList<>();
         HashSet<Integer> hs1 = new HashSet<>();
         HashSet<Integer> hs2 = new HashSet<>();
         for(int i:nums1)
             hs1.add(i);
         for(int i:nums2)
             hs2.add(i);
         List<Integer> li1 = new ArrayList<>();
         List<Integer> li2 = new ArrayList<>();
         for(int i : hs1){
             if(!hs2.contains(i)){
                 li1.add(i);
             }
         }
         for(int i : hs2){
             if(!hs1.contains(i)){
                 li2.add(i);
             }
         }
         lol.add(li1);
         lol.add(li2);
         return lol;
     }
     public static ListNode reverseLinkedList(ListNode head)
     {
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
     }
     public static int countNodes(TreeNode root) {
        return 0;
     }

     public static double myPow(double x, int n) {
         if(n==0)
             return 1;
        double half = myPow(x,n/2);
        if(n %2 ==0){
           return half*half;
        } else {
            if(n>0){
                return x*half*half;
            } else {
                return (half*half) / x;
            }
        }
     }
     public static int mySqrt(int x) {
        if (x==0 || x==1){
            return x;
        }
        long left =1, right = x, result = 0;
        while(left <= right){
            long mid = left + (right - left)/2;
            if (mid * mid <= x) {
                result = mid;
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
     }

     /*public static List<List<String>> groupAnagrams(String[] strs) {

     }*/
     public static int[] plusOne(int[] digits) {
         int n = digits.length;
         for(int i =n-1;i>=0;i--){
             digits[i]++;
             if(digits[i] == 10){
                 digits[i] = 0;
             } else {
                 break;
             }
         }
         if(digits[0] == 0){
             int[] result = new int[n+1];
             result[0] = 1;
             for(int i =0;i<digits.length;i++){
                 result[i+1] = digits[i];
             }
             return result;
         }
         return digits;
     }

     public static void printList(ListNode head){
         System.out.print("LinkedList: ");
         while(head != null){
             System.out.print(head.val + " ");
             head = head.next;
         }
         System.out.println();
     }
     public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i =1;i<left;i++){
            prev = prev.next;
        }
        ListNode current = prev.next;
        ListNode next = null;
        for(int i =0;i<right-left+1;i++){
            ListNode temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }
        prev.next.next = current;
        prev.next = next;
        System.out.println("LinkedList has been reversed from i to j");
        return dummy.next;
     }
     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummy = new ListNode(0);
         ListNode current = dummy;
         int carry = 0;

         while(l1 != null || l2 != null || carry != 0){
             int sum = carry;
             if(l1 != null){
                 sum += l1.val;
                 l1 = l1.next;
             }
             if(l2 != null){
                 sum += l2.val;
                 l2 = l2.next;
             }
            carry = sum / 10;
            current.next = new ListNode(sum%10);
            current = current.next;
        }
         return dummy.next;
     }
     public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length)
            return false;
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();
        for( int i =0;i<pattern.length();i++){
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            // check mapping from pattern to word
            if(patternToWord.containsKey(currentChar)) {
                if (!patternToWord.get(currentChar).equals(currentWord))
                    return false;
            } else
                    patternToWord.put(currentChar, currentWord);

            if(wordToPattern.containsKey(currentWord)) {
                if (wordToPattern.get(currentWord) != currentChar)
                    return false;
            }
                else
                    wordToPattern.put(currentWord, currentChar);
            }
        return true;
     }

     public static boolean isSubsequence(String s, String t) {
       int sPointer=0,tPointer=0;
       while(sPointer < s.length() && tPointer < t.length()){
           if(s.charAt(sPointer) == t.charAt(tPointer)){
               sPointer++;
           }
           tPointer++;
       }
        return sPointer == s.length();

     }
     public static boolean isIsomorphic(String s, String t) {

        return true;
     }
     public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> magazine_hs = new HashMap<>();

        for(char c : magazine.toCharArray())
            magazine_hs.put(c,magazine_hs.getOrDefault(c,0)+1);

        for(char c : ransomNote.toCharArray()) {
            if(!magazine_hs.containsKey(c) || magazine_hs.get(c) <=0)
                return false;
            magazine_hs.put(c,magazine_hs.get(c)-1);
         }
         return true;
     }

     public static int removeElement(int[] nums, int val) {
        int unique = 0;
         for(int i =0;i<nums.length-2;i++)
             if(nums[i] != val) {
                 nums[unique] = nums[i];
                 unique++;
             }
        return unique;
     }

     public static int removeDuplicates(int[] nums) {
        int unique = 1;
        for(int i =1;i<nums.length;i++) {
            if (nums[i] != nums[i - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
     }
     public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutations(nums, used, currentPermutation, result);
        return result;
     }

     private static void generatePermutations(int[] nums, boolean[] used,
                                              List<Integer> currentPermutation,
                                              List<List<Integer>> result){
        if(currentPermutation.size() == nums.length){
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(!used[i]){
                used[i] = true;

            }
        }

     }
     public static int findKthLargest(int[] nums, int k) {
        return -1;
     }
     public static int romanToInt(String s) {
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int n = s.length();
        int num = romanMap.get(s.charAt(n-1));
        for(int i=n-2;i>0;i--){
            if(romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i+1)))
                num += romanMap.get(s.charAt(i));
            else
                num -= romanMap.get(s.charAt(i));
        }
        return num;
     }
     public static List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
     }

     static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
         ArrayList<Integer> arr3 = new ArrayList<>();
         int start = 0;
         int end = arr.size()-1;
         int mid = (start+end)/2;
         //arr3.add(subsetSums(arr.subList(start,mid),mid-start));
         //arr3.add(subsetSums(arr.subList(mid+1,end),end-mid));
         return arr3;
     }
     public static int solve(String A) {
        return -1;
     }

     public static List< Integer > search(String s, String pattern){
         List<Integer> li = new ArrayList<>();
         if(s.length() == 0 || s == null || pattern.length() == 0 || pattern == null || s.length() < pattern.length())
            return null;
         for (int i =0;i<s.length()-pattern.length()+1;i++)
         {
             if(s.startsWith(pattern, i))
                li.add(i+1);
         }
         return li;
     }

     public static int repeatedStringMatch(String a, String b) {
        if(a == null || b == null || a.length() ==0 || b.length() ==0)
            return -1;
        int maxIterations = b.length()/a.length() + 2;
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<maxIterations;i++){
            sb.append(a);
            if(sb.toString().contains(b))
                return i;
        }
        return -1;
     }
     public static int strStr(String haystack, String needle) {
        for(int i =0;i<=haystack.length()-needle.length();i++) {
           // if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i ).equals(needle))
                    return i;
           // }
        }
        return -1;
     }
     public static int findDuplicate(int[] nums) {
        //int duplicate = 0;
        int len = nums.length;
       /* int sum = len*(len-1)/2;
        int array_sum = 0;
        for(int i =0;i<nums.length;i++)
            array_sum = array_sum+nums[i];
        duplicate = array_sum - sum;*/
         for(int num:nums){
            int num_abs = Math.abs(num);
            if(nums[num_abs] < 0)
                return num;
            nums[num_abs] = -nums[num_abs];
         }
        return -1;
     }

     public static void merge(int[] nums1, int m, int[] nums2, int n) {
         int i = m - 1;
         int j = n - 1;
         int k = m + n - 1;
         while (i >= 0 && j >= 0) {
             if (nums1[i] > nums2[j]) {
                 nums1[k--] = nums1[i--];
             } else {
                 nums1[k--] = nums2[j--];
             }
         }
             while (j >= 0) {
                 nums1[k--] = nums2[j--];
             }
         }

     public static ListNode removeNthFromEnd(ListNode head, int n) {
        //ListNode start = head;
        //if(n==0) return head;
        //if(n<0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        // Move first pointer n+1 steps ahead
        for(int i =0;i<=n;i++){
            first = first.next;
        }
       while(first != null){
           first = first.next;
           second = second.next;
       }
       second.next = second.next.next;
       return dummy.next;
     }
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null) {
            current.next = list1;
        }
        else {
            current.next = list2;
        }
        return dummy.next;
     }

     public static List<Integer> majorityElement2(int[] nums) {
         int max_count = 0, index =0;
         int n = nums.length;
         List<Integer> majorityList = new ArrayList<>();
         for(int i =0;i<nums.length;i++){
             int count = 0;
             for(int j=0;j<nums.length;j++){
                 if(nums[i] == nums[j]){
                     count++;
                 }
             }
             if(count > n/3 && !majorityList.contains(nums[i])){
                 majorityList.add(nums[i]);
             }
         }
         return majorityList;
     }

    static int majorityElement(int[] nums) {
        int n = nums.length;
        int maxCount = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    index = i;
                }
            }
            System.out.println(maxCount);
            if (maxCount > n / 2) {
                System.out.println(nums[index]);
                return nums[index];
            }
            else
                System.out.println("No majority element");
        }
        return nums[index];
    }



     /*public String longestPalindrome(String s) {
        String palindrome = "";
        return palindrome;
     }*/
     static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
                 return false;
         int NO_OF_CHARS = 256;
         int i = 0;
         int count1[] = new int[NO_OF_CHARS];
         Arrays.fill(count1,0);
         int count2[] = new int[NO_OF_CHARS];
         Arrays.fill(count2,0);
         char[] scharr = s.toCharArray();
         char[] tcharr = t.toCharArray();
         for ( i =0;i < scharr.length && i < tcharr.length;i++){
            count1[scharr[i]]++;
            count2[tcharr[i]]++;
         }
         for(i=0;i< NO_OF_CHARS ;i++)
             if(count1[i] != count2[i])
                 return false;
         return true;
     }

    static boolean isAnagram(String s, String t) {
        char[] scharr = s.toCharArray();
        char[] tcharr = t.toCharArray();
        Arrays.sort(scharr);
        System.out.println(scharr);
        Arrays.sort(tcharr);
        System.out.println(tcharr);
        if(Arrays.equals(scharr, tcharr))
            return true;
        return false;
     }

     static String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        String result = strs[0];
        //String longestCommonPrefix = "";
        int n = strs.length;
        for(int i =0;i<n;i++){
            while(strs[i].indexOf(result) != 0){
                result = result.substring(0,result.length()-1);
                if(result.isEmpty()){
                    return "-1";
                }
            }
        }
        return result;
     }

     static String longestCommonPrefix1(String[] strs) {
         int size = strs.length;
         Arrays.sort(strs);
         int end = Math.min(strs[0].length(), strs[size-1].length());
         int i =0;
         for(;strs[0].charAt(i) == strs[size-1].charAt(i);i++){

         }
         String longestCommonPrefix = strs[0].substring(0,i);
         return longestCommonPrefix;
     }

     static TreeNode sortedArrayToBST(int[] nums) {
           //TreeNode root = new TreeNode();
            if (nums == null || nums.length == 0)
                return null;
            return buildBST(nums,0,nums.length-1);
     }

    static TreeNode buildBST(int[] nums, int left, int right){
         if(left>right)
             return null;
         int mid = left + (right-left)/2;
         TreeNode root = new TreeNode(nums[mid]);
         root.left = buildBST(nums, left, mid-1);
         root.right = buildBST(nums, mid+1, right);
         return root;
    }
     public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return root;
        if(root.val == val)
            return root;
        else if(val < root.val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);
     }
    static int maxSubArray(int[] nums) {
        int largest_sum = 0;
        for(int i =0;i<nums.length;i++){
            for(int j =i;j<nums.length;j++){
                if (largest_sum > getSum(nums, i,j))
                {
                    largest_sum = getSum(nums, i,j);
                    System.out.println("Largest Sum : "+largest_sum);
                }
            }
        }
        return largest_sum;
    }

    static int getSum(int[] nums, int i,int j){
        int sum=0;
        for(int k = i ; k <= j ; k++)
            sum += nums[k];
        System.out.println("getSum : "+sum);
        return sum;
    }
    static void printMatrix(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
     public static void rotate90Clockwise(int[][] matrix) {
        int N = matrix.length;
        for(int i = 0 ; i < N/2 ; i++){
            for(int j = i ; j < N-1-i ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = temp;
            }
        }
     }

     public static int maxMeetings(int start[], int end[], int n)
     {
         int meetings = 0;

        return meetings;
     }

     public int singleNonDuplicate(int[] nums) {
        return 0;
     }

     public static int searchInRotatedSortedArray(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        if(target >= nums[0] && target <= nums[pivot]){
            return binarySearch(nums, target, 0,pivot);
        } else {
            return binarySearch(nums, target, pivot+1, nums.length -1);
        }
     }

     private static int findPivot(int[] nums){
         int low=0, high = nums.length -1;
         while(low < high){
             int mid = low + (high - low)/2;
             if(nums[mid] > nums[mid+1]) {
                 return mid; // Found pivot
             }
             else if (nums[mid] >= nums[low]) {
                 low = mid + 1;
             }
             else {
                 high = mid;
             }
         }
         return -1; // Array is not rotated.
     }

     private static int binarySearch(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return -1; // Target not found.
     }
     public static int[] repeatedNumber(int[] A) {
        int[] B = new int[2];
        int repeatedNumber = 0, missingNumber = 0;
        B[0] = repeatedNumber;
        B[1] = missingNumber;
        
        return B;
     }

     public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            System.out.println(prev.val);
        }
        return prev;
     }

    static String longestPalindrome(String s) {
        String longestPalindrome = "";

        return longestPalindrome;
    }

    public static ListNode middleNode(ListNode head) {
        //int middle=0;
        //ListNode middleNode = new ListNode();
        /*
        int length = length(head);
        if (length%2==0)
            middle = length/2;
        else
            middle = (length+1)/2;
        for(int i=0;i<middle;i++)
            ListNode.
            */
        ListNode slow = head, fast = head;
        //System.out.println("slow : "+slow.val);
        //System.out.println("fast : "+fast.val);
        //ListNode fast = head;
        if(head == null)
            return head;
        while(fast != null && fast.next != null){
            //System.out.println("slow : "+slow.val);
            //System.out.println("fast : "+fast.val);
            slow = slow.next;
            fast = fast.next.next;
            //System.out.println("slow : "+slow.val);
            //System.out.println("fast : "+fast.val);
        }
        return slow;
    }

    static int length(ListNode head){
        return 0;
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


    }

    public static String reverseWords(String givenString) {
        //System.out.println("Given String : "+givenString);
        String reverseWords = "";
        String reverseWord = "";
        String givenString1 = givenString.trim();
        String reverseWord1 = reverseWord(givenString1);
        //System.out.println("Reverse Word : "+reverseWord1);
        String[] splitGivenString = reverseWord1.split("\\s+");
        for(String word:splitGivenString) {
            //System.out.println(word);
            reverseWord = reverseWord(word);
            //System.out.println(reverseWord);
            reverseWords += reverseWord + " ";
        }
        reverseWords = reverseWords.trim();
        //System.out.println("Reversed word: "+reverseWords);
        return reverseWords;
    }
    public static String reverseWord(String givenString) {
       StringBuilder input1 = new StringBuilder();
       input1.append(givenString);
       StringBuilder reverse = input1.reverse();
       return reverse.toString();
    }

    public static void setZeroes(int[][] matrix) {
        System.out.println("Before Matrix: ");
        for(int i =0;i<matrix.length;i++)
            for(int j =0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            if(rows[i]){
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0 ; j < n ; j++){
            if(columns[j]){
                for(int i = 0 ; i < m ; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("After zeroes in Matrix : ");
        for(int i =0;i<matrix.length;i++)
            for(int j =0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");
        //int[] row = new int[];
        //int[] column = new int[];


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

     @Override
     protected void finalize() throws Throwable {
         super.finalize();
         System.out.println("Object is destroyed.");
     }
 }
