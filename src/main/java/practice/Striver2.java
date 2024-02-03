package practice;

import java.beans.PropertyEditorSupport;
import java.util.*;


class Striver2 {

    private static volatile boolean flag10 = false;
    static class Singleton{
        private static Singleton instance;
        private Singleton(){
        }

        public static Singleton getInstance(){
            if(instance == null){
                synchronized (Singleton.class){
                    if(instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    public int strStr(String haystack, String needle) {
        int occurence = -1;
        int haystacklength = haystack.length();
        int needlelength = needle.length();
        for(int j=0;j<haystacklength;j++){
            for(int i=0;i<needlelength;i++){
                System.out.println("i: "+i);
                System.out.println("j: "+j);
                if (needle.charAt(i) == haystack.charAt(i)) {
                    if (i == needlelength - 1)
                        occurence = j;
                    System.out.println("occurence: "+occurence);
                }
                else
                    break;
            }
            if(occurence!=-1)
                break;
        }
        return occurence;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i =0;i<k;i++){
            minHeap.add(nums[i]);
        }
        for(int i =k;i<nums.length;i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static List<String> findPaths(int[][] maze, int N) {
        List<String> paths = new ArrayList<>();
        int n = maze.length;
        // Helper function to perform backtracking
        backtrack(maze,0,0,n,new StringBuilder(), paths);
        return paths;
    }

    private static void backtrack(int[][] maze,int row,int col,int n, StringBuilder path, List<String> paths ){
        // Base case : if rat reaches destination, add path to list
        if (row == n-1 && col == n-1){
            paths.add(path.toString());
            return;
        }
        // Mark current cell as visited
        maze[row][col] = 2;
        // Explore all possible directions : Up, Down, Left, Right
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        char[] directions = {'U','D','L','R'};
        for(int i =0;i<4;i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            // Check if new position is within bounds and cell is not visited or blocked
            if (isValid(newRow, newCol,n) && maze[newCol][newRow] ==1){
                path.append(directions[i]);
                //backtrack(maze,newRow,newCol,n,path,paths);
                path.deleteCharAt(path.length()-1);
            }
        }
        // Mark current cell as unvisited
        maze[row][col] = 1;
    }

    private static boolean isValid(int row, int col, int n){
        return row >=0 && row < n && col >=0 && col < n;
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
        for(int i =0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    private static void reverse(int[] nums, int i, int j){
        for(;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        }
        System.out.println("ThreeSum: ");
        for(int i =0;i<result.size();i++){
            for(int j = 0; j< result.get(i).size(); j++){
                System.out.print(" "+result.get(i).get(j)) ;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String  haystack = "hello";
        String needle = "ll";
        Striver2 needleHaystack = new Striver2();
        System.out.println("isAnagram : " + needleHaystack.strStr(haystack, needle));
        int nums[] = {5, 4, 2, 6};
        int nums1[] = {2, 1};
        int k = 2;
        System.out.println("findKthLargest: " + findKthLargest(nums, k));
        System.out.println("findKthLargest: " + findKthLargest(nums1, k));
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int N = 4;
        List<String> paths = findPaths(maze, N);
        System.out.println("All possible paths");
        for (String path : paths) {
            System.out.println(path);
        }
        // Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Reversed Array : ");
        rotate(nums2, k1);
        // Given an integer array nums, return all the triplets
        // [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        //Notice that the solution set must not contain duplicate triplets.
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7};
        List<List<Integer>> triplets = threeSum(nums4);
        System.out.println();
        System.out.println("ThreeSum: ");
        for (int i = 0; i < triplets.size(); i++) {
            for (int j = 0; j < triplets.get(i).size(); j++) {
                System.out.print(" " + triplets.get(i).get(j));
            }
        }
        // Given a pattern and a string s, find if s follows the same pattern.
        // Here follow means a full match,
        // such that there is a bijection between a letter in pattern and a non-empty word in s.
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println("Word Pattern : " + wordPattern(pattern, s));
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println("Construct from Ransom Note : " + canConstruct(ransomNote, magazine)); // giving wrong answer
        System.out.println("Construct from Ransom Note : " + canConstruct1(ransomNote, magazine));
        String word1 = "horse";
        String word2 = "ros";
        minDistance(word1, word2);
        // Given an integer array nums, find subarray
        // that has the largest product, and return the product.
        // The test cases are generated so that the answer will fit in a 32-bit integer.
        int nums10[] = {-2, 0, -1};
        System.out.println("Max Product in Subarray : " + maxProduct(nums10));
        // Given an integer array nums, return the length of the longest strictly increasing subsequence
        int[] nums11 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("lengthOfLIS: " + lengthOfLIS(nums11));
        // Given two strings text1 and text2, return the length of their longest common subsequence.
        // If there is no common subsequence, return 0.
        // A subsequence of a string is a new string generated from the original string with some characters
        // (can be none) deleted without changing the relative order of the remaining characters.
        // For example, "ace" is a subsequence of "abcde".
        // A common subsequence of two strings is a subsequence that is common to both strings.
        String text1 = "abcde", text2 = "ace";
        String text3 = "abc", text4 = "abc";
        System.out.println("longestCommonSubsequence: " + longestCommonSubsequence(text1, text2));
        // A thief is robbing a store and can carry a maximum weight of ‘W’ into his knapsack.
        // There are 'N' items available in the store and the weight and
        // value of each item is known to the thief.
        // Considering the constraints of the maximum weight that a knapsack can carry,
        // you have to find the maximum profit that a thief can generate by stealing items.
        //Note: The thief is not allowed to break the items.

        // Given a list arr of N integers, return sums of all subsets in it.
        List<Integer> arr = List.of(1, 2, 3);
        int N1 = 10;
        List<Integer> subsetSums = subsetSums(arr, N1);
        List<Integer> subsetSums1 = subsetSums1(arr, N1);
        System.out.println("Subsets by recursion: ");
        for (int i = 0; i < subsetSums.size(); i++) {
            System.out.print(subsetSums.get(i) + " ");
        }
        //subsetSums.forEach(System.out::println);
        System.out.println();
        System.out.println("Subsets by iteration: ");
        for (int i = 0; i < subsetSums1.size(); i++) {
            System.out.print(subsetSums1.get(i) + " ");
        }
        //subsetSums1.forEach(System.out::println);
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        // Given an integer numRows, return the first numRows of Pascal's triangle.
        List<List<Integer>> rows = generate(5);
        for (List<Integer> l : rows) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        // You are given an integer array nums.
        // You are initially positioned at the array's first index,
        // and each element in the array represents your maximum jump length at that position.
        // Return true if you can reach the last index, or false otherwise.
        int[] nums12 = {2, 3, 1, 1, 4};
        int[] nums13 = {3, 2, 1, 0, 4, 5, 8};
        int[] nums14 = {0};
        int[] nums15 = {1, 2};
        int[] nums16 = {1};
        int[] nums17 = {1, 2, 3};
        int[] nums18 = {0, 2, 3};
        int[] nums19 = {1, 0, 3};
        int[] nums20 = {3, 0, 8, 2, 0, 0, 1};
        System.out.println("Can Jump: " + canJump1(nums12));
        System.out.println("Can Jump: " + canJump1(nums13));
        System.out.println("Can Jump: " + canJump1(nums14));
        System.out.println("Can Jump: " + canJump1(nums15));
        System.out.println("Can Jump: " + canJump1(nums16));
        System.out.println("Can Jump: " + canJump1(nums17));
        System.out.println("Can Jump: " + canJump1(nums18));
        System.out.println("Can Jump: " + canJump1(nums19));
        System.out.println("Can Jump: " + canJump1(nums20));

        // Jump Game II
        // You are given a 0-indexed array of integers nums of length n.
        // You are initially positioned at nums[0].
        //Each element nums[i] represents the maximum length of a forward jump from index i.
        // In other words, if you are at nums[i], you can jump to any nums[i + j] where:
        //0 <= j <= nums[i] and
        //i + j < n
        //Return the minimum number of jumps to reach nums[n - 1].
        // The test cases are generated such that you can reach nums[n - 1].
        System.out.println("jump : " + jump(nums));
        // Best Time to Buy and Sell Stock II
        int[] prices = {7, 1, 5, 3, 6, 4};
        // You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
        //On each day, you may decide to buy and/or sell the stock.
        // You can only hold at most one share of the stock at any time.
        // However, you can buy it then immediately sell it on the same day.
        //Find and return the maximum profit you can achieve.
        System.out.println("maxProfit with single transaction : " + maxProfit(prices));
        System.out.println("maxProfit with multiple transaction : " + maxProfit1(prices));
        // Given an integer, convert it to a roman numeral.
        String roman = intToRoman(10);
        // Given the root of a binary tree, return the inorder traversal of its nodes' values.
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        List<Integer> inorderList = inorderTraversal(root);
        System.out.print("Inorder Traversal: ");
        for (int i = 0; i < inorderList.size(); i++)
            System.out.print(inorderList.get(i));
        // Max depth of binary tree
        System.out.println("\nMaxDepth: " + maxDepth(root));
        // Given the roots of two binary trees p and q, write a function to check if they are the same or not.
        System.out.println("\nisSameTree: " + isSameTree(root, root1));
        ListNode head = new ListNode(10);
        head.next = new ListNode(11);
        head.next.next = new ListNode(12);
        System.out.println("\nhasCycle: " + hasCycle(head));
        // Given a Binary Tree, return Left view of it.
        // Left view of a Binary Tree is set of nodes visible
        // when tree is visited from Left side.
        // The task is to complete the function leftView(),
        // which accepts root of the tree as argument.
        ArrayList<Integer> arrayList = leftView(root);

        // Given the root of a binary tree, invert the tree, and return its root.
        List<Integer> inorder_list = inorderTraversal(invertTree(root));
        System.out.print("Inorder Traversal of inverted tree: ");
        for (int i = 0; i < inorder_list.size(); i++) {
            System.out.print(" " + inorder_list.get(i));
        }
        // Given the root of a binary tree,
        // check whether it is a mirror of itself (i.e., symmetric around its center).
        System.out.print("\nSymmetric tree: " + isSymmetric(root));
        System.out.print("\nSymmetric tree: " + isSymmetric(root2));
        // Given the root of a binary tree and an integer targetSum,
        // return true if the tree has a root-to-leaf path such that
        // adding up all the values along the path equals targetSum.
        // A leaf is a node with no children.
        int target1 = 7;
        System.out.println("\nhasPathSum : " + hasPathSum(root, target1));

        // Given a string s, return the longest palindromic substring in s.
        String s1 = "cbabd";
        String s2 = "babad";
        String s3 = "bb";
        System.out.println("\nlongestPalindrome : " + longestPalindrome(s1));
        //System.out.println("\ncountNodes : "+longestPalindrome(s3));
        // Minimum Characters required to make a String Palindromic
        // Given a string A. The only operation allowed is to insert characters at the beginning of the string.
        // Find how many minimum characters are needed to be inserted to make the string a palindrome string.
        String A = "ABC";
        String A1 = "ABCB";
        String B = "AACECAAAA";
        String C = "BA";
        String D = "BABB";
        //System.out.println("insertinBeginningCountA : "+solve1(A));
        //System.out.println("insertinBeginningCountB : "+solve(B));
        //System.out.println("insertinBeginningCountC : "+solve1(C));
        //System.out.println("insertinBeginningCountD : "+solve1(D));
        // Given the root of a complete binary tree, return the number of the nodes in the tree.
        System.out.println("\ncountNodes : " + countNodes(root));
        // Valid Sudoku
        char[][] board = new char[1][1];
        System.out.println("\nisValidSudoku: " + board);
        // Top View of Binary Tree
        ArrayList<Integer> topView = topView(root);
        for (int i = 0; i < topView.size(); i++) {
            System.out.print(" " + topView.get(i));
        }
        ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(3, 6, 1, 4));
        ArrayList<Integer> weights = new ArrayList<Integer>(Arrays.asList(6, 1, 5, 3));
        int n = 4;
        int w = 4;
        System.out.println("01 Knapsack : " + maxProfitKnapsack(values, weights, n, w));
        // Palindrome Linked List
        // Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
        System.out.println("LinkedList_isPalindrome : " + isPalindrome(head));
        // Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K.
        // The task is to find the element that would be at the kth position of the final sorted array.
        int[] nums191 = {2, 3, 6, 7, 9};
        int[] nums201 = {1, 4, 8, 10};
        int k2 = 1;
        System.out.println("kthElement: " + kthElement(nums191, nums201, nums191.length, nums201.length, k2));
        //Isomorphic Strings
        String s21 = "egg";
        String t2 = "add";
        System.out.println("isIsomorphic0: " + isIsomorphic(s21, t2));
        String s22 = "badc";
        String t3 = "baba";
        System.out.println("isIsomorphic1: " + isIsomorphic(s22, t3));
        // You are given an m x n integer matrix with the following two properties:
        //Each row is sorted in non-decreasing order.
        //The first integer of each row is greater than the last integer of the previous row.
        //Given an integer target, return true if target is in matrix or false otherwise.
        //You must write a solution in O(log(m * n)) time complexity.
        int target2 = 3;
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[0][3] = 7;
        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 16;
        matrix[1][3] = 20;
        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;
        matrix[2][3] = 60;
        System.out.println("searchMatrix : " + searchMatrix(matrix, target));
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln = addTwoNumbers(ln1, ln2);
        // Given an array nums of n integers, return an array of all the unique quadruplets
        // [nums[a], nums[b], nums[c], nums[d]] such that:
        //0 <= a, b, c, d < n
        //a, b, c, and d are distinct.
        //nums[a] + nums[b] + nums[c] + nums[d] == target
        //You may return the answer in any order.
        int[] nums21 = {1, 0, -1, 0, -2, 2};
        int target21 = 0;
        List<List<Integer>> fourSum = fourSum(nums21, target21);
       /* for(int i =0;i<fourSum.size();i++){
            System.out.println(""+fourSum.get(i));
        }*/
        //System.out.println("fourSum: "+fourSum);

        int[] nums22 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target22 = -294967296;
        List<List<Integer>> fourSum1 = fourSum(nums22, target22);
        System.out.println("fourSum1: " + fourSum1);

        int[] nums23 = {-1, 0, -5, -2, -2, -4, 0, 1, -2};
        int target23 = -9;
        //List<List<Integer>> fourSum2 = fourSum( nums23, target23);
        //System.out.println("fourSum2: "+fourSum2);

        int[] nums24 = {-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
        int target24 = 0;
        //List<List<Integer>> fourSum3 = fourSum( nums24, target24);
        //System.out.println("fourSum3: "+fourSum3);

        // Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        // You must write an algorithm that runs in O(n) time.
        int[] nums26 = {100, 4, 200, 1, 3, 2};
        System.out.println("longestConsecutive : " + longestConsecutive(nums26));

        // Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
        int[] nums27 = {15, -2, 2, -8, 1, 7, 10, 23};
        int N2 = nums27.length;
        System.out.println("largest subarray with sum 0 : " + longestConsecutive(nums27));
        //Given an array having both positive and negative integers.
        // The task is to compute the length of the largest subarray with sum 0.
        int[] nums28 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("maxLen: " + maxLen(nums28, nums28.length));
        System.out.println("Hello, World!");
        String str = "JavaJavaEE";
        HashMap<Character, Integer> count = new HashMap<>();
        /*for(int i=0;i<str.length();i++){
            if(count.contains(str[i])){
                int countChar = count.get(str[i]);
                count.add(str[i], countChar+1);
            } else {
                count.add(str[i], 1);
            }
        }
        for(int i=0;i<count.length();i++){
            //if(count.get(str[i] > 1))
            //System.out.println(count.get(i)+" "+ " is "+ count.valueAt(count.get(i)) + " times");
        }*/
        // Sum 2 : input array is sorted.
        int[] numbers = {2, 7, 11, 15};
        int target3 = 9;
        int[] numbers2 = twoSum(numbers, target3);
        System.out.println("TwoSum: " + numbers2[0] +"  "+numbers2[1]);
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max Area : "+maxArea(height));
        // Given an array of positive integers nums and a positive integer target,
        // return the minimal length of subarray
        // whose sum is greater than or equal to target.
        // If there is no such subarray, return 0 instead.
        int[] nums30 = {2,3,1,2,4,3};
        int target5 = 7;
        int min = minSubArrayLen(target5, nums30);
        System.out.println("Minimum Size Subarray Sum : "+min);
        // Longest Substring Without Repeating Characters
        String s5 = "abcabcbb";
        System.out.println("lengthOfLongestSubstring: "+lengthOfLongestSubstring(s5));
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println("Sudoku : "+isValidSudoku(sudoku));
        int[] nums32 = {1,2,3,4};
        int[] nums31 = productExceptSelf(nums32);
        for(int i: nums31){
            System.out.print(" "+i);
        }
        System.out.println();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println("canCompleteCircuit startIndex: "+canCompleteCircuit( gas, cost));
        int n32 = 19;
        System.out.println(""+isHappy(n32));
        // Given an m x n matrix, return all elements of the matrix in spiral order.
        List<Integer> spiral = spiralOrder(matrix);
        System.out.println("***Spiral Order***");
        for(int i : spiral){
            System.out.print(" "+i);
        }
        System.out.println();

        String s34 = "()[]{}";
        System.out.println("isValid : "+isValid(s34));
        String path = "/home/";
        System.out.println("simplifyPath1: "+simplifyPath(path));
        String path1 = "/../";
        System.out.println("simplifyPath2: "+simplifyPath(path1));
        String path2 = "/home//foo/";
        System.out.println("simplifyPath3: "+simplifyPath(path2));
        int nums33[] = {1,2,3,1};
        findPeakElement(nums33);
        int n5 = 4, k5 =2;
        List<List<Integer>> lol = combine(n5, k5) ;
        System.out.println("List of Lists : "+lol);
        int nums34[] = {1,2,3,1,1,3};
        int number = numIdenticalPairs(nums);
        System.out.println(""+number);
        int[] arr1 = {3,4,1,6,2,5,7};
        mergeSort(arr1, n);


    }

    public static void mergeSort(int[] arr, int n) {
        // Write your code here.
    }
    public static int numIdenticalPairs(int[] nums) {
        int number = 0;

        return number;
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lol = new ArrayList<>();
        return lol;
    }
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    public static String simplifyPath(String path) {
        String s = "";
        return s;
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        while(matrix.length > 0 && matrix[0].length > 0){
            for(int num : matrix[0]){
                spiral.add(num);
            }
            matrix = rotate(matrix);
        }
        return spiral;
    }

    private static int[][] rotate(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] rotated = new int[column][row-1];
        for(int i =0;i<column;i++){
            for(int j=0;j<row-1;j++){
                rotated[i][j] = matrix[j+1][column-1-i];
            }
        }
        return rotated;
    }
    public static boolean isHappy(int n) {
        return false;
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int tank = 0;
        int start = 0;
        for(int i =0;i<n;i++){
            int diff = gas[i] - cost[i];
            sum += diff;
            tank += diff;
            if(tank <0){
                start = i+1;
                tank = 0;
            }
        }
        return (sum>=0) ? start : -1;
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];
        int leftProduct = 1;
        for(int i =0;i<nums.length;i++){
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for(int i = n-1;i>=0;i--){
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }
        for(int i =0;i<n;i++){
            result[i] = leftProducts[i] * rightProducts[i];
        }
        return result;
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        for(int start=0,end=0;end<n;end++){
            if(charIndexMap.containsKey(s.charAt(end))){
                start = Math.max(charIndexMap.get(s.charAt(end)) + 1, start);
            }
            charIndexMap.put(s.charAt(end),end);
            maxLength = Math.max(maxLength, end- start +1);
        }
        return maxLength;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while(right < nums.length){
            sum = sum + nums[right];
            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxWater = Math.max(maxWater,h*w);
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        return maxWater;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int sum = numbers[left]+numbers[right];
        if(sum == target){
            return new int[]{left+1, right+1};
        } else if (sum < target) {
            left++;
        } else {
           right--;
        }
       }
        // No solution found
        return new int[]{-1,-1};
    }
    public static int maxLen(int arr[], int n)
    {
        if(arr == null || arr.length ==0)
            return 0;
        int maxLength = 0,sum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            sum += arr[i];
            if(sum==0){
                // Sum becomes 0 from beginning to current index.
                maxLength = i+1;
            } else if (sumMap.containsValue(sum)){
                // Sum repeats, update maxLen
                maxLength = Math.max(maxLength, i-sumMap.get(sum));
            } else {
                // Store sum and its index
                sumMap.put(sum, i);
            }
        }
        for(int i =0;i<sumMap.size();i++){
            //System.out.println();
        }
        return maxLength;
    }
    public static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        if(nums == null || nums.length ==0)
            return 0;
        HashSet<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        for(int num: numSet){
            // check if sum is start of sequence
            if(!numSet.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;
                while(numSet.contains(currentNum +1)){
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        for(int i =0;i<nums.length-3;i++){
            if(i>0 && nums[i] == nums[i-1]) {
                //System.out.println("i's are equal");
                continue;
            }
            //System.out.println("\nnums[i] = "+nums[i]);
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) {
                    //System.out.println("j's are equal");
                    continue;
                }
                //System.out.println("\nnums[j] = "+nums[j]);
                int left = j+1;
                int right = nums.length - 1;
                while(left < right){
                    long sum =  (long ) nums[i] + nums[j] +nums[left] +nums[right];
                    //if (sum1 > Integer.MAX_VALUE)
                    //    break;
                    //int sum = nums[i] + nums[j] +nums[left] +nums[right];
                    //System.out.println("sum : "+sum);
                    //int sum2 = nums[i] + nums[j]+nums[left];
                    //System.out.println("sum2 : "+sum2);
                    if(sum == target){
                        //System.out.println("\ni = "+i);
                        //System.out.println("j = "+j);
                        //System.out.println("left:  "+left);
                        //System.out.println("right: "+right);
                        List<Integer> al = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if(!result.contains(al) && sum <= Integer.MAX_VALUE)
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //System.out.println("Added in result: ");
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left +1]) {
                            left++;
                            //System.out.println("left are equal");
                        }
                        while(left < right &&  nums[right] == nums[right-1]) {
                            right--;
                            //System.out.println("right are equal");
                        }

                    } else if(sum<target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValid(String s) {
        Stack<Character> leftSymbols = new Stack<>();
        for(char c : s.toCharArray()){
            if (c =='(' || c == '{' || c == '[')
                leftSymbols.push(c);
            else if (c ==')' && !leftSymbols.empty() && leftSymbols.peek() == '('){
                leftSymbols.pop();
            } else if (c =='}' && !leftSymbols.empty() && leftSymbols.peek() == '{'){
                leftSymbols.pop();
            } else if (c ==']' && !leftSymbols.empty() && leftSymbols.peek() == '['){
                leftSymbols.pop();
            } else {
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1!= null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!= null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dummy.next;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = rows*columns -1;
        while(left <= right){
            int mid = (left + right)/2;
            int midValue = matrix[mid/columns][mid % columns];
            if(midValue == target){
                return true;
            } else if (midValue < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
        Map stotmapping = new HashMap<Character, Character>();
        Map ttosmapping = new HashMap<Character, Character>();
        for(int i =0;i<s.length();i++){
            if(stotmapping.containsKey(s.charAt(i))){
                if (!stotmapping.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
            else{
                stotmapping.put(s.charAt(i), t.charAt(i));
            }
        }
        for(int i =0;i<t.length();i++){
            if(ttosmapping.containsKey(t.charAt(i))){
                if (!ttosmapping.get(t.charAt(i)).equals(s.charAt(i))){
                    return false;
                }
            }
            else{
                ttosmapping.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
    public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int i = 0 , j = 0;
        for( ; i < n && j < m ;){
            if(arr1[i] < arr2[j]){
                if(k==1) {
                    return arr1[i];
                }
                i++;
            } else {
                if(k==1) {
                    return arr2[j];
                }
                j++;
            }
            k--;
        }
        for(;i<n;i++,k--){
            if(k==1) {
                return arr1[i];
            }
        }
        for(;j<m;j++,k--){
            if(k==1)
                return arr2[j];
        }
        return -1;
    }
    public static boolean isPalindrome(ListNode head) {
        boolean isPalindrome = false;
        return isPalindrome;
    }
    public static int maxProfitKnapsack(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n+1][w+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= w ; j++){
                if(weights.get(i-1) <= j)
                    dp[i][j] = Math.max(values.get(i-1) + dp[i-1][j-weights.get(i-1)], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
        // time complexity : O(N*W)
        // space complexity : O(N*W)
    }
    public static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> ai = new ArrayList<>();
        return ai;
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i =0;i<9;i++){
            if(!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubBox(board, i)){
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRow(char[][] board, int row) {
        boolean[] used = new boolean[9];
        for(int i =0;i<9;i++){
            //char num
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int col) {
        return true;
    }

    private static boolean isValidSubBox(char[][] board, int box) {
        return true;
    }

    public static int solve1(String A) {
        int n = A.length();
        int[] dp = new int[n];
        for(int i =n-2;i>=0;i++){
            int prev = 0;
            for(int j=i+1;j<n;j++){
                int temp = dp[j];
                if (A.charAt(i) == A.charAt(j)){
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]+1);
                }
                prev = temp;
            }
        }
        return dp[n-1];
    }

    public static int solve(String A) {
        int len = A.length();
        int insertinBeginningCount = 0;
        int i =0;
        while(i< len){
            System.out.println("i: "+i);
            if(A.charAt(i) != A.charAt(len-1-i)){
                ++insertinBeginningCount;
                System.out.println("character: "+A.charAt(len-i-1));
                A = A.charAt(len-i-1)+A;
                System.out.println("A: "+A);
                solve(A);
            }
            else {
                ++i;
            }
        }
        return insertinBeginningCount;
    }
    public static String longestPalindrome(String s) {
        int maxlen = 0;
        String maxstring = "";
        if(s == null || s.length() <= 1)
            return s;
        for(int i =0;i<s.length()-1;i++){
            for(int j=i+maxlen;j<=s.length();j++){
                if(isPalindrome(s.substring(i,j))){
                    int len = s.substring(i,j).length();
                    if(len > maxlen){
                        maxlen = len;
                        maxstring = s.substring(i,j);
                    }
                }
            }
        }
        return maxstring;
    }

    public static boolean isPalindrome(String s1){
        int len = s1.length();
        for(int i =0;i< len/2;i++){
            if(s1.charAt(i) != s1.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    public static int countNodes(TreeNode root) {
        //TreeNode root = new TreeNode();`
        int count = 0;
        if(root == null)
            return countNodes(root, count);
        else if(root.left != null){
            return countNodes(root, count+1);
        }
        else if(root.right != null){
            return countNodes(root, count+1);
        }
        return count;
    }
    public static int countNodes(TreeNode root, int count) {
        //if(root!= null)
            //return countNodes(root, 1);
        return 0;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
       if(root == null)
           return false;
       if( root.left == null && root.right == null && root.val == targetSum)
            return true;
       return hasPathSum(root.left, targetSum- root.val) ||
            hasPathSum(root.right, targetSum - root.val);
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
       /* if(root.left != null && root.right != null && root.left.val != root.right.val)
            return false;
        isSymmetric(root.left);
        isSymmetric(root.right);*/
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static ArrayList<Integer> leftView(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root== null)
            return null;
        result.add(root.val);
        leftView(root.left);
        return result;
    }
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slowPointer = head, fastPointer = head.next;
        while(slowPointer != fastPointer)
        {
            if(fastPointer == null || fastPointer.next == null)
                return false;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return true; // There is a cycle.
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null)
            return true;
        if(p ==null || q == null)
            return false;
        return  (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftdepth = maxDepth(root.left);
        int rightdepth= maxDepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal1(root, inorder);
        return inorder;
    }
    public static void inorderTraversal1(TreeNode root, List<Integer> inorder) {
        if(root != null) {
            inorderTraversal1(root.left, inorder);
            inorder.add(root.val);
            inorderTraversal1(root.right, inorder);
        }
    }

    public static String intToRoman(int num) {
        return "";
    }
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price: prices){
            minPrice = Math.min(minPrice, price);
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
    public static int jump(int[] nums) {
        int jumps = 0;
        int currentMax = 0;
        int nextMax = 0;

        for (int i = 0; i < nums.length -1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == currentMax) {
                jumps++;
                currentMax = nextMax;
                if (currentMax >= nums.length - 1)
                    break;
            }
        }
        return jumps;
    }

    public static boolean canJump1(int[] nums) {
        int maxreach = 0;
        for(int i =0;i<nums.length;i++){
            if(i>maxreach)
                return false;
            maxreach = Math.max(maxreach, i+nums[i]);
            if(maxreach >= nums.length -1)
                return true;
        }
        return false;
    }

    // wrong solution
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length ==0)
            return false;
        int len = nums.length;
        if (len==1 && nums[0] >= 0) return true;
        for(int i =0;i<len-1;i++){
            if(i+nums[i] >= len-1) {
                System.out.println(""+nums[i]);
                return true;
            }
        }
        return false;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                } else{
                    int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    row.add(sum);
                }
            }
            result.add(row);
        }
        return result;
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if(target < 0)
            return;
        if(target == 0){
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        for(int i =start;i<candidates.length;i++){
            currentCombination.add(candidates[i]);
            backtrack(candidates, target - candidates[i],i,currentCombination, result);
            currentCombination.remove(currentCombination.size()-1);
        }
    }

    public static List<Integer> subsetSums(List<Integer> arr, int N){
        List<Integer> result = new ArrayList<>();
        generateSubsets(arr,0,0,result);
        return result;
    }

    public static List<Integer> subsetSums1(List<Integer> arr, int N){
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        int total = 1 <<n;
        for(int i =0;i<(1<<n);i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += arr.get(j);
                }
            }
            result.add(sum);
        }
        return result;
    }
    private static void generateSubsets(List<Integer> arr, int index, int currentSum, List<Integer> result){
        result.add(currentSum);
        for(int i =index;i<arr.size();i++){
            generateSubsets(arr,i+1,currentSum + arr.get(i), result);
            generateSubsets(arr,i+1,currentSum,result);
        }
    }

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        return 0;
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        System.out.println("LCS : "+dp[0][0]);
        for(int i =1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if( text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }
    /*public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = Math.max(text1.length(),text2.length());
        int i =0;
        String biggerString = null, smallerString = null;
        if(len1 == text1.length())
             biggerString = text1;
        else
             smallerString = text2;
        for(int j=0;j<len1 ;j++) {
            if ( i < smallerString.length() && j < biggerString.length() && smallerString.charAt(i) == biggerString.charAt(j)) {
                    ++i;
                    System.out.println("Increased");
                }
            }
        return i;
    }*/

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxlength = 1;
        for( int i = 1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxlength = Math.max(maxlength, dp[i]);
        }
        return maxlength;
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] maxEndingHere = new int[n];
        int[] minEndingHere = new int[n];
        maxEndingHere[0] = nums[0];
        minEndingHere[0] = nums[0];
        int maxProduct = nums[0];
        for(int i =1;i<n;i++){
            // Calculate min and max product ending at current position
            maxEndingHere[i] = Math.max(nums[i], Math.max(maxEndingHere[i-1]*nums[i], minEndingHere[i-1]*nums[i]) );
            minEndingHere[i] = Math.min(nums[i], Math.min(maxEndingHere[i-1]*nums[i], minEndingHere[i-1]*nums[i]) );
            // Update maximum product
            maxProduct = Math.max(maxProduct, maxEndingHere[i]);
        }
        return maxProduct;
    }
    public static int minDistance(String word1, String word2) {
        int product = 0;
        return product;
    }
    // giving wrong answer and not working.
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> magazine_hs = new HashMap<>();

        for(char c : magazine.toCharArray())
            magazine_hs.put(c,magazine_hs.getOrDefault(c,0)+1);

        for(char c : ransomNote.toCharArray()) {
            if(!magazine_hs.containsValue(c) || magazine_hs.get(c) <=0)
                return false;
            magazine_hs.put(c,magazine_hs.get(c)-1);
        }
        return true;
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] letterCounts = new int[26];
        for(int i =0;i<magazine.length();i++){
            letterCounts[magazine.charAt(i) - 'a']++;
        }
        for(int i =0;i<ransomNote.length();i++){
            if(--letterCounts[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i =0;i<pattern.length();i++){
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];
            // check if current character is already mapped to different word
            if(charToWord.containsKey(currentChar) && !charToWord.get(currentChar).equals(currentWord))
                return false;
            // check if current word is already mapped to different character
            if(wordToChar.containsKey(currentWord) && wordToChar.get(currentWord) != currentChar)
                return false;
            // Establish bijection
            charToWord.put(currentChar,currentWord);
            wordToChar.put(currentWord,currentChar);
        }
        return true;
    }
}
