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
		//hasAllUniqueChars()
		
		System.out.println("allUniqueChars (unique String): " 
				+ hasAllUniqueChars("abcdefghijklmnopqrstuvwxyz"));
		System.out.println("allUniqueChars (not unique String): " 
				+ hasAllUniqueChars("abcdefghijklmnopqrstuvwxyza"));
		System.out.println("allUniqueChars (String over 128 chars): " 
				+ hasAllUniqueChars(" !\"#$%&'()*+,-./0123456789:;<=>?@"
						+ "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnop"
						+ "qrstuvwxyz1234567890abcdefghijklmnopqrstuv"
						+ "wxyz[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~a"));
		System.out.println();
		
		//isPermutation()
		
		System.out.println("isPermutation (anagram): " 
				+ isPermutation("tccatt", "tatctc"));
		System.out.println("isPermutation (not an anagram): " 
				+ isPermutation("catttac", "acettac"));
		System.out.println("isPermutation (different lengths): " 
				+ isPermutation("cat", "acts"));
		System.out.println();


		//urlify()
		
		char[] url1 = {'J', 'o', 'h', 'n', ' ', 
				'S', 'a', 'm', ' ', 
				'D', 'o', 'e', 
				' ', ' ', ' ', ' '};
		char[] url2 = {'N', 'o', 'S', 'p', 'a', 'c', 'e'};
		char[] url3 = {' ', ' ', ' ', ' ', ' '};
		
		urlify(url1);
		urlify(url2);
		urlify(url3);
		
		System.out.println("urlify (\"John Sam Doe\"): " 
				+ Arrays.toString(url1));
		System.out.println("urlify (\"NoSpace\"): " 
				+ Arrays.toString(url2));
		System.out.println("urlify (\"     \"):" 
				+ Arrays.toString(url3));
		System.out.println();


		//isPalindromePermutation()
		
		System.out.println("isPalindromePermutation (permutation of palindrome, odd, no spaces): " 
				+ isPalindromePermutation("tcatacc"));
		System.out.println("isPalindromePermutation (permutation of palindrome, even, spaces): " 
				+ isPalindromePermutation("t ca ta c"));
		System.out.println("isPalindromePermutation (not permutation of palindrome): " 
				+ isPalindromePermutation("tccsfatace"));
		System.out.println();
		
		//compress()
		
		System.out.println("compress (compression makes shorter string): " 
				+ compress("aaaabbbccd"));
		System.out.println("compress (compression makes longer string): " 
				+ compress("abcd"));
		System.out.println();
	
		//isOneEditAway()
		
		System.out.println("isOneEditAway (one replacement): " 
				+ isOneEditAway("loveCats", "loveRats"));
		System.out.println("isOneEditAway (one addition): " 
				+ isOneEditAway("loveCat", "loveCats"));
		System.out.println("isOneEditAway (one deletion): " 
				+ isOneEditAway("loveCats", "loveCat"));
		System.out.println("isOneEditAway (two replacements): " 
				+ isOneEditAway("loveCats", "loveRags"));
		System.out.println("isOneEditAway (two additions): " 
				+ isOneEditAway("loveCats", "loveCactus"));
		System.out.println("isOneEditAway (two deletions): " 
				+ isOneEditAway("loveTaters", "loveTats"));
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
	
	public static boolean hasAllUniqueChars(String input) {
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
	
	/*
	 * Goal: given a char array with extra spaces at the end, update array
	 * to replace spaces between words with chars '%', '2', '0'
	 * Notes on thought process:
	 * 1) Will take O(N) time, just need to loop through array
	 * 2) Start from the back to avoid overwriting anything
	 * 3) (Personal taste) Two tracking variables would be easier to read
	 * than doing the math on position every time
	 */
	
	public static void urlify(char[] input) {
		int trackingIndex = input.length -1;
		int writingIndex = input.length - 1;
		
		while (trackingIndex >= 0 && input[trackingIndex] == ' ') trackingIndex--;
		
		for (/*trackingIndex*/; trackingIndex >= 0; trackingIndex--) {
			if (input[trackingIndex] != ' ') {
				input[writingIndex] = input[trackingIndex];
				writingIndex--;
			} else {
				input[writingIndex] = '0'; 
				input[writingIndex - 1] = '2';
				input[writingIndex - 2] = '%';
				writingIndex -= 3;
			}
		}
	}
	
	/*
	 * Goal: determine whether a String is a permutation of a palindrome (ignore spaces)
	 * Notes on thought process:
	 * 1) In order to be a palindrome the counts for each char except one has to
	 * be even
	 * 2) Sorting the String first would allow for looping over the String and
	 * keeping track of different char counts in order to flag for multiple odds
	 * without using more space, but sorting bottlenecks the task as O(N log N)
	 * 3) A HashMap would be great for tracking char counts and brings runtime
	 * down to O(N)
	 */
	
	public static boolean isPalindromePermutation(String input) {
		Map<Character,Integer> counts = new HashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == ' ') continue;
			
			if (counts.get(c) == null) {
				counts.put(c, 1);
			} else {
				counts.put(c, counts.get(c) + 1);
			}
		}
		
		boolean foundOdd = false;
		
		for (Map.Entry<Character,Integer> entry: counts.entrySet()) {
			if (entry.getValue() %2 != 0) {
				if (foundOdd) return false;
				foundOdd = true;
			}
		}
		
		return true;
	}
	
	/*
	 * Goal: Compress a String so that any consecutive chars are not shown,
	 * and every different character is followed by the count of consecutive chars,
	 * but return the original String if it's shorter than the compressed one
	 * Notes on thought process:
	 * 1) Should be easy to accomplish by just looping through String and
	 * tracking counts along the way
	 * 2) Using a StringBuilder can keep it to O(N) time, normal String
	 * concatenation would require a lot of repeated copying 
	 */
	
	public static String compress(String input) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			result.append(input.charAt(i));
			
			int repetitions = 1;
			boolean repeated = true;
			
			while (i + repetitions < input.length() && repeated) {
				if (input.charAt(i + repetitions) == input.charAt(i)) {
					repetitions++;
				} else {
					repeated = false;
				}
			}
			
			result.append(repetitions);
			i += repetitions - 1;
		}
		
		if (result.toString().length() >= input.length()) return input;
		
		return result.toString();
	}

	/*
	 * Goal: Determine if a String is one edit (or less) away from another String
	 * where an edit could be an added char, a removed char, or a changed char
	 * Notes on thought process:
	 * 1) Should be able to accomplish in O(N) time by comparing both Strings
	 * in order
	 * 2) If the Strings are same length can check for single replacement, if
	 * Strings are 1 length apart can check for insertion/deletion, otherwise
	 * we know Strings are more than 1 edit apart if lengths have greater diff
	 * 3) (Personal taste) Easier to read as multiple methods, even if it 
	 * would be more compact as a single method
	 */
	
	public static boolean isOneEditAway(String one, String two) {
		if (one.length() == two.length()) {
			return hasOneReplacement(one, two);
		} else if (one.length() + 1 == two.length()) {
			return hasOneInsertion(one, two);
		} else if (one.length() - 1 == two.length()) {
			return hasOneInsertion(two, one);
		} else {
			return false;
		}
	}
	
	private static boolean hasOneReplacement(String one, String two) {
		boolean hasDifference = false;
		
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i)) {
				if (hasDifference) return false;
				hasDifference = true;
			}
		}
		
		return true;
	}
	
	private static boolean hasOneInsertion(String one, String two) {
		int oneIndex = 0;
		int twoIndex = 0;
		
		while (oneIndex < one.length() && twoIndex < two.length()) {
			if (one.charAt(oneIndex) != two.charAt(twoIndex)) {
				if (oneIndex != twoIndex) return false;
				twoIndex++;
			} else {
				oneIndex++;
				twoIndex++;
			}
		}
		
		return true;
	}

}
