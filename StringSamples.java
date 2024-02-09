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
		// TODO Auto-generated constructor stub
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

}
