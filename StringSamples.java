/**
 * 
 */
package Algo;
import java.util.*;
/**
 * @author pritesh
 *
 */
public class StringSamples {

	/**
	 * 
	 */
	public StringSamples() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String givenString = "ElonMusk";
		char[] givenArray = givenString.toCharArray();
		Arrays.sort(givenArray);
		System.out.print(givenArray);
		char[] sortedArray = new char[] {'h','s','e'};
		if(Arrays.equals(givenArray, sortedArray))
			System.out.println("Arrays not equal");
		char c = 'i';
		countCharacters(c);
		reverseString(givenString);
		String sentense = "I am the great programmer";
		reverseWordsinString(sentense);
		System.out.println("\n Longest Palindrome In String"+ longestPalindromeInString("aabbcc"));
		//System.out.println("System.out.println(\"Recursively Remove All Adjacent Duplicates " + recursivelyRemoveAllAdjacentDuplicates(s));
		
	}
	
	static void reverseWordsinString(String sentense) {
		
	}
	
	void firstNonrepeatedCharacter() {
		
	}
	
	static void countCharacters(Character c) {
		
	}
	
	void removeCharacter(String given) {
		
	}
	
	boolean isAnagrams(){
		return false;
		
	}
	
	boolean isPalindrome(){
		Boolean flag = false;
		
		return flag;
		
	}
	
	void permutations(){}
	
	static void reverseString(String s){}
	
	private static String recursivelyRemoveAllAdjacentDuplicates(String s) {
		
	    char last_removed  = '\0';
	    return removeUtil(s, last_removed);
	}
	
	// Recursively removes adjacent duplicates from str and  returns new string. last_removed is pointer to last removed character.
	static String removeUtil(String str, char last_removed) {
		
		if( str.length() == 0 || str.length() == 1)
			return str;
			
		// Remove leftmost same characters and recur for rest string
		if(str.charAt(0) == str.charAt(1)) {
			last_removed = str.charAt(0);
			while(str.length() > 1 || str.charAt(0) == str.charAt(1)){
				str = str.substring(1, str.length());
			str = str.substring(1, str.length());
			return removeUtil(str, last_removed);
			}
		}
		
		// At this point, first character is definitely different from its adjacent.
		// Ignore first character and recursively remove characters from remaining string.
		String rem_str = removeUtil(str.substring(1, str.length()), last_removed);
		
		// Check if first character of rem_string matches with the first character with original string
		if(rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0))
		{
			last_removed = str.charAt(0);
			return rem_str.substring(1, rem_str.length()); // Remove first character.
		}
		
		// If remaining string becomes empty and last removed character is same as first character of original string.
		// This is needed for string like "acbbcddc"
		if (rem_str.length() == 0 && last_removed == str.charAt(0))
		{
			return rem_str;
		}
		
		// If first 2 characters of str and rem_str doesn't match, append first character of str before first character of rem_str
		return (str.charAt(0) + rem_str);
		
	}
	
	// Utility function to print substring str [low..high]
	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high +1));
	}
	
	// Space complexity : O(1)
	// Time Complexity: O(n2)
	// This function prints longest palindrome string and returns length of longest palindrome.
	static int longestPalindromeInString(String str) {
		int maxLength = 1;
		int start = 0;
		int len = str.length();
		int low, high;
		
		//One by one consider every character as center point of even and odd length palindrome
		for( int i = 0 ; i < len ; i++) {
			low = i - 1;
			high = i;
			while(low >=0 && high < len && str.charAt(low) == str.charAt(high)){
				if(high-low+1>maxLength) {
					start = low;
					maxLength = high - low +1;
				}
				--low;
				++high;
			}
		
		//Find longest odd length palindrome with center point as i
		low = i - 1;
		high = i +1;
		while(low >=0 && high < len && str.charAt(low) == str.charAt(high))
		{
			if(high-low+1 > maxLength) {
				start = low;
				maxLength = high - low +1;
			}
			--low;
			++high;
		}
		}
		System.out.println("Longest palindrome substring is : ");
		printSubStr(str, start, start + maxLength -1 );
		return maxLength;
		
	}
}
