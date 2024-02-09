package Algo;

import java.util.HashMap;

public class ArraySamples {

	public ArraySamples() {
		
	}

	public static void main(String[] args) {
		int[] a = {1,3,5,7,9,10,2,4,6};
		int[] b = {1,3,5,7,9,10,2,4,1,2,2};
		findMissingNumber(a);
		findDuplicateNumber(b);
		findDuplicateNumberUsingHashMap(b);
		
	}
	
	static void findMissingNumber(int[] a) {
		// Time Complexity : O(n) 
		// Space complexity : O(1)
		int n = (a.length+2) * (a.length+1) /2;
		System.out.println(" n : "+n);
		int sum = 0;
		for(int i = 0 ; i < a.length ; i++)
			sum = sum + a[i];
		int miss = n - sum;
		System.out.println("/n Missing number : " + miss );
	}
	
	static void findDuplicateNumber(int[] b) {
		System.out.println("\n Find Duplicate Number ");
		for(int i = 0 ; i < b.length ; i++)
			for(int j = i+1 ; j < b.length ; j++)
			{
				if(b[i] == b[j])
					System.out.print(" "+b[j]);
			}
	}
	
	static void findDuplicateNumberUsingHashMap(int[] b) {
		System.out.println("\n Find Duplicate Number Using Hashmap");
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < b.length ; i++)
			if (hm.containsKey(b[i])) {
				System.out.println(" " + b[i]);
			}
			else 
			{
				//int value = (int) hm.get(b[i]);
				hm.put(b[i], 1);
			}
		//for(int i =0;i<b.length;i++)
			// If not in hashmap, insert number
	}
	
	
}
