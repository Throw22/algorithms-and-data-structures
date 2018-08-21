import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayAndStringProblemsTests {
	/* hasAllUniqueChars */
	
	@Test
	public void hasAllUniqueChars_Alphabet_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.hasAllUniqueChars("abcdefghijklmnopqrstuvwxyz");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void hasAllUniqueChars_EmptyString_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.hasAllUniqueChars("");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void hasAllUniqueChars_LongerThan128Chars_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.hasAllUniqueChars(" !\"#$%&'()*+,-./0123456789:;<=>?@"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnop"
				+ "qrstuvwxyz1234567890abcdefghijklmnopqrstuv"
				+ "wxyz[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~a");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void hasAllUniqueChars_RepeatedChar_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.hasAllUniqueChars("abcdefghijklmnopqrstuvwxyza");

	    Assert.assertEquals(actual, expected);
	}
	
	/* isPermutation */
	
	@Test
	public void isPermutation_Anagram_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPermutation("aaaaabbbbbccccc", "abcabcabcabcabc");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPermutation_EmptyStrings_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPermutation("", "");

	    Assert.assertEquals(actual, expected);
	}

	@Test
	public void isPermutation_SameLengthNonAnagram_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isPermutation("aaaaabbbbbccccc", "aaaaaabbbbbcccc");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPermutation_DifferentLengths_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isPermutation("aaaaabbbbbccccc", "aaaaabbbbbcccccc");

	    Assert.assertEquals(actual, expected);
	}
	
	/* urlify */
	
	@Test
	
	public void urlify_WithSpaces_ExpandsToFillArray() {
	    final char[] expected = {'J', 'o', 'h', 'n', '%', '2', '0', 
				'S', 'a', 'm', '%', '2', '0',  
				'D', 'o', 'e'};
	    
	    final char[] actual = {'J', 'o', 'h', 'n', ' ', 
				'S', 'a', 'm', ' ', 
				'D', 'o', 'e', 
				' ', ' ', ' ', ' '};
	    
	    ArrayAndStringProblems.urlify(actual);

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void urlify_NoSpaces_DoesNothing() {
	    final char[] expected = {'J', 'o', 'h', 'n',
				'S', 'a', 'm',  
				'D', 'o', 'e'};
	    
	    final char[] actual = {'J', 'o', 'h', 'n',
				'S', 'a', 'm', 
				'D', 'o', 'e'};
	    
	    ArrayAndStringProblems.urlify(actual);

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void urlify_AllSpaces_DoesNothing() {
	    final char[] expected = {' ', ' ', ' ', ' ',
				' ', ' ', ' ',  
				' ', ' ', ' '};
	    
	    final char[] actual = {' ', ' ', ' ', ' ',
				' ', ' ', ' ',  
				' ', ' ', ' '};
	    
	    ArrayAndStringProblems.urlify(actual);

	    Assert.assertEquals(actual, expected);
	}

	/* isPalindromePermutation */
	
	@Test
	public void isPalindromePermutation_NoSpacesEvenIsPalindrome_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("abcabcabcabc");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_NoSpacesOddIsPalindrome_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("abcabcabcabca");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_SpacesEvenIsPalindrome_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("   a bca bca   bc  abc  ");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_SpacesOddIsPalindrome_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("   a baca bca   bc  abc  ");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_Empty_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_AllSpaces_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("        ");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_NoSpacesEvenNotPalindrome_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("aaaabbbbcccd");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_NoSpacesOddNotPalindrome_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("aaaabbbbcccde");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_SpacesEvenNotPalindrome_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("  aa   aa bbb b  ccc d   ");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindromePermutation_SpacesOddNotPalindrome_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isPalindromePermutation("  aa   aa bbb b  ccec d   ");

	    Assert.assertEquals(actual, expected);
	}

	/* compress */
	
	@Test
	public void compress_CompressionShortensString_ReturnsCompressedString() {
	    final String expected = "a1b2c3d4e5";

	    final String actual = ArrayAndStringProblems.compress("abbcccddddeeeee");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void compress_CompressionLengthensString_ReturnsOriginalString() {
	    final String expected = "abcdefg";

	    final String actual = ArrayAndStringProblems.compress("abcdefg");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void compress_EmptyString_ReturnsEmptyString() {
	    final String expected = "";

	    final String actual = ArrayAndStringProblems.compress("");

	    Assert.assertEquals(actual, expected);
	}

	/* isOneEditAway */
	
	@Test
	public void isOneEditAway_OneAddition_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abcdef");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_OneSubtraction_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abcd");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_OneChange_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abcdf");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_SameString_ReturnsTrue() {
	    final boolean expected = true;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abcde");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_TwoAdditions_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abcdefg");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_TwoSubtractions_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abc");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_TwoChanges_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "abcfg");

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isOneEditAway_OneAdditionOneChange_ReturnsFalse() {
	    final boolean expected = false;

	    final boolean actual = ArrayAndStringProblems.isOneEditAway("abcde", "gbcdef");

	    Assert.assertEquals(actual, expected);
	}

	/* rotate90 */
	
	@Test
	public void rotate90_0By0_DoesNothing() {
	    final int[][] expected = new int[0][0];
	    
	    final int[][] actual = new int[0][0];
	    
	    ArrayAndStringProblems.rotate90(actual);

	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void rotate90_1By1_DoesNothing() {
	    final int[][] expected = new int[1][1];
	    expected[0][0] = 10;
	    
	    final int[][] actual = new int[1][1];
	    actual[0][0] = 10;
	     
	    final boolean expectedEquals = true;
	    
	    ArrayAndStringProblems.rotate90(actual);
	    
	    final boolean actualEquals = Arrays.deepEquals(expected, actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void rotate90_2By2_Rotates() {
	    final int[][] expected = new int[2][2];
	    expected[0][0] = 3; expected[0][1] = 1;
	    expected[1][0] = 4; expected[1][1] = 2;
	    
	    final int[][] actual = new int[2][2];
	    actual[0][0] = 1; actual[0][1] = 2;
	    actual[1][0] = 3; actual[1][1] = 4;
	     
	    final boolean expectedEquals = true;
	    
	    ArrayAndStringProblems.rotate90(actual);
	    
	    final boolean actualEquals = Arrays.deepEquals(expected, actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void rotate90_3By3_Rotates() {
	    final int[][] expected = new int[3][3];
	    expected[0][0] = 7; expected[0][1] = 4; expected[0][2] = 1;
	    expected[1][0] = 8; expected[1][1] = 5; expected[1][2] = 2;
	    expected[2][0] = 9; expected[2][1] = 6; expected[2][2] = 3;

	    
	    final int[][] actual = new int[3][3];
	    int count = 1;
	    for (int i = 0; i < actual.length; i++) {
	    	for (int j = 0; j < actual.length; j++) {
	    		actual[i][j] = count; 
	    		count++;
	    	}
	    }
	     
	    final boolean expectedEquals = true;
	    
	    ArrayAndStringProblems.rotate90(actual);
	    
	    final boolean actualEquals = Arrays.deepEquals(expected, actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void rotate90_4By4_Rotates() {
	    final int[][] expected = new int[4][4];
	    expected[0][0] = 13; expected[0][1] = 9;  expected[0][2] = 5; expected[0][3] = 1;
	    expected[1][0] = 14; expected[1][1] = 10; expected[1][2] = 6; expected[1][3] = 2;
	    expected[2][0] = 15; expected[2][1] = 11; expected[2][2] = 7; expected[2][3] = 3;
	    expected[3][0] = 16; expected[3][1] = 12; expected[3][2] = 8; expected[3][3] = 4;
	    
	    final int[][] actual = new int[4][4];
	    int count = 1;
	    for (int i = 0; i < actual.length; i++) {
	    	for (int j = 0; j < actual.length; j++) {
	    		actual[i][j] = count; 
	    		count++;
	    	}
	    }
	     
	    final boolean expectedEquals = true;
	    
	    ArrayAndStringProblems.rotate90(actual);
	    
	    final boolean actualEquals = Arrays.deepEquals(expected, actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
}
