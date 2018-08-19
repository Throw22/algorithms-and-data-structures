import java.util.*;

/* Written by Nicholas Romeo
 * 
 * The following are possible solutions to a variety of 
 * programming problems involving Arrays and/or Strings,
 * along with some thoughts about the problems along the
 * way.
 */

public class ArrayAndStringProblems {
	// For light testing/demonstration
	public static void main(String[] args) {
		//allUniqueChars()
		System.out.println("allUniqueChars (unique String): " 
				+ allUniqueChars("abcdefghijklmnopqrstuvwxyz"));
		System.out.println("allUniqueChars (not unique String): " 
				+ allUniqueChars("abcdefghijklmnopqrstuvwxyza"));
		System.out.println("allUniqueChars (String over 128 chars): " 
				+ allUniqueChars(" !\"#$%&'()*+,-./0123456789:;<=>?@"
						+ "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnop"
						+ "qrstuvwxyz1234567890abcdefghijklmnopqrstuv"
						+ "wxyz[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~a"));
		
		//isPermutation()
		System.out.println("isPermutation (anagram): " 
				+ isPermutation("tccatt", "tatctc"));
		System.out.println("isPermutation (not an anagram): " 
				+ isPermutation("catttac", "acettac"));
		System.out.println("isPermutation (different lengths): " 
				+ isPermutation("cat", "acts"));

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
		
		Set<Character> unique = new HashSet<>();
		
		for (int i = 0; i < input.length(); i++) {
			if (unique.contains(input.charAt(i))) return false;
			unique.add(input.charAt(i));
		}
		
		return true;
	}
	
	
	/*
	 * Goal: determine if two Strings are permutations of each other
	 * Notes on thought process:
	 * 1) Easy test for non-anagrams to save time--compare lengths
	 * 2) Can't be done any faster than linear time because in the
	 * worst case scenario would need to see every letter of both
	 * Strings
	 * 3) Using a HashMap for char counts keeps it in O(N) time with
	 * the possibility of early exits if we check along the way instead
	 * of comparing character counts for both at the end
	 */
	
	public static boolean isPermutation(String one, String two) {
		if (one.length() != two.length()) return false;
		
		Map<Character,Integer> counts = new HashMap<>();

		for (int i = 0; i < one.length(); i++) {
			char c = one.charAt(i);
			
			if (counts.get(c) == null) {
				counts.put(c, 1);
			} else {
				counts.put(c, counts.get(c) + 1);
			}
		}
		
		for (int i = 0; i < two.length(); i++) {
			char c = two.charAt(i);
			
			if (counts.get(c) == null) {
				return false;
			} else {
				counts.put(c, counts.get(c) - 1);
				if (counts.get(c) < 0) return false;
			}
		}
		
		return true;
	}
	
}
