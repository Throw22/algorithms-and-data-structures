import java.util.HashSet;

/* Written by Nicholas Romeo
 * 
 * The following are possible solutions to a variety of 
 * programming problems involving Arrays and/or Strings,
 * along with some thoughts about the problems along the
 * way.
 */

public class ArrayAndStringProblems {

	public static void main(String[] args) {
		// Quick demo/tests for allUniqueChars()
		System.out.println("allUniqueChars: unique String: " 
				+ allUniqueChars("abcdefghijklmnopqrstuvwxyz"));
		System.out.println("allUniqueChars: not unique String: " 
				+ allUniqueChars("abcdefghijklmnopqrstuvwxyza"));
		System.out.println("allUniqueChars: String over 128 chars: " 
				+ allUniqueChars(" !\"#$%&'()*+,-./0123456789:;<=>?@"
						+ "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnop"
						+ "qrstuvwxyz1234567890abcdefghijklmnopqrstuv"
						+ "wxyz[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~a"));
	}
	
	/*
	 * Goal: determine if a String has all unique characters
	 * Notes on thought process: 
	 * 1) Brute force method is straightforward--for each char
	 * compare to every following char, but would take O(N^2) time
	 * 2) If the Strings were sorted first (O(N log N) time to sort)
	 * then would only need to iterate over String once to find any
	 * repeated chars
	 * 3) Can get down to O(N) time by looping over String once to 
	 * add chars to a HashSet and checking for duplicates along the way
	 * 4) If using ASCII then any String over 128 length can't have
	 * all unique chars so we can save time checking
	 */
	
	public static boolean allUniqueChars(String input) {
		if (input.length() > 128) return false;
		
		HashSet<Character> unique = new HashSet<Character>();
		
		for (int i = 0; i < input.length(); i++) {
			if (unique.contains(input.charAt(i))) return false;
			unique.add(input.charAt(i));
		}
		
		return true;
	}
	
}
