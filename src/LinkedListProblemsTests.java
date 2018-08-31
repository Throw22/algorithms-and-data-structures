import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListProblemsTests {
	/* removeDuplicates */
	
	@Test
	public void removeDuplicates_OneDuplicateAtEnd_RemovesDuplicate() {
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(2);
	    actual.add(3);
	    actual.add(4);
	    actual.add(1);
	    
	    LinkedListProblems.removeDuplicates(actual);
	    
	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeDuplicates_MultipleDuplicates_RemovesDuplicates() {
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(1);
	    actual.add(2);
	    actual.add(3);
	    actual.add(3);
	    actual.add(3);
	    actual.add(1);
	    actual.add(4);
	    actual.add(1);
	    actual.add(4);
	    
	    LinkedListProblems.removeDuplicates(actual);
	    
	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeDuplicates_NoDuplicates_DoesNothing() {
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(2);
	    actual.add(3);
	    actual.add(4);
	    
	    LinkedListProblems.removeDuplicates(actual);
	    
	    Assert.assertEquals(actual, expected);
	}
	
/* removeDuplicatesWithoutBuffer */
	
	@Test
	public void removeDuplicatesWithoutBuffer_OneDuplicateAtEnd_RemovesDuplicate() {
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(2);
	    actual.add(3);
	    actual.add(4);
	    actual.add(1);
	    
	    LinkedListProblems.removeDuplicatesWithoutBuffer(actual);
	    	    
	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeDuplicatesWithoutBuffer_MultipleDuplicates_RemovesDuplicates() {
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(2);
	    actual.add(3);
	    actual.add(3);
	    actual.add(1);
	    actual.add(4);
	    actual.add(1);
	    actual.add(4);
	    
	    LinkedListProblems.removeDuplicatesWithoutBuffer(actual);
	    	    
	    Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeDuplicatesWithoutBuffer_NoDuplicates_DoesNothing() {
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(2);
	    actual.add(3);
	    actual.add(4);
	    
	    LinkedListProblems.removeDuplicatesWithoutBuffer(actual);
	    	    
	    Assert.assertEquals(actual, expected);
	}
	
/* getKthFromLast */
	
	@Test
	public void getKthFromLast_KOf1_ReturnsLastElement() {
		final int expected = 4;
		
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		final int actual = LinkedListProblems.getKthFromLast(list,1);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getKthFromLast_KOf2_ReturnsSecondToLastElement() {
		final int expected = 3;
		
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		final int actual = LinkedListProblems.getKthFromLast(list,2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getKthFromLast_KOfLength_ReturnsFirstElement() {
		final int expected = 1;
		
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		final int actual = LinkedListProblems.getKthFromLast(list,4);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getKthFromLast_KOfMoreThanLength_ReturnsFirstElement() {
		final int expected = 1;
		
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		final int actual = LinkedListProblems.getKthFromLast(list,6);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class )
	public void getKthFromLast_KOfLessThan1_ThrowsException() {
		LinkedList list = new LinkedList();
		
		LinkedListProblems.getKthFromLast(list,0);
	}
	
	/* removeFromMiddle */
	
	@Test
	public void removeFromMiddle_NodeIsInMiddle_RemovesNode() {
		final LinkedList expected = new LinkedList();
		expected.add(1);
		expected.add(2);
		expected.add(4);

		final LinkedList actual = new LinkedList();
		actual.add(1);
		actual.add(2);
		actual.add(3);
		actual.add(4);
				
		LinkedListProblems.removeFromMiddle(actual.getNode(3));
		
		Assert.assertEquals(actual, expected);
	}
	
	/* partition */

	@Test
	public void partition_PIsMin_NoChanges() {
		final LinkedList expected = new LinkedList();
		expected.add(2);
		expected.add(1);
		expected.add(4);
		expected.add(3);

		final LinkedList actual = new LinkedList();
		actual.add(2);
		actual.add(1);
		actual.add(4);
		actual.add(3);

		LinkedListProblems.partition(actual, 1);

		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public void partition_PIsLessThanMin_NoChanges() {
		final LinkedList expected = new LinkedList();
		expected.add(2);
		expected.add(1);
		expected.add(4);
		expected.add(3);

		final LinkedList actual = new LinkedList();
		actual.add(2);
		actual.add(1);
		actual.add(4);
		actual.add(3);

		LinkedListProblems.partition(actual, 0);

		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public void partition_PIsGreaterThanMax_NoChanges() {
		final LinkedList expected = new LinkedList();
		expected.add(2);
		expected.add(1);
		expected.add(4);
		expected.add(3);

		final LinkedList actual = new LinkedList();
		actual.add(2);
		actual.add(1);
		actual.add(4);
		actual.add(3);
		
		LinkedListProblems.partition(actual, 5);

		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public void partition_PIsMax_MaxMovesToEnd() {
		final LinkedList expected = new LinkedList();
		expected.add(1);
		expected.add(3);
		expected.add(2);
		expected.add(4);

		final LinkedList actual = new LinkedList();
		actual.add(4);
		actual.add(1);
		actual.add(3);
		actual.add(2);

		LinkedListProblems.partition(actual, 4);

		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public void partition_PIsMid_MinMoveLeftMaxMoveRight() {
		final LinkedList expected = new LinkedList();
		expected.add(1);
		expected.add(2);
		expected.add(0);
		expected.add(7);
		expected.add(5);
		expected.add(4);
		expected.add(3);

		final LinkedList actual = new LinkedList();
		actual.add(7);
		actual.add(1);
		actual.add(5);
		actual.add(2);
		actual.add(4);
		actual.add(3);
		actual.add(0);

		LinkedListProblems.partition(actual, 3);

		Assert.assertEquals(actual, expected);		
	}
	
	/* reverse */

	@Test
	public void reverse_ListIsEmpty_NoChanges() {
		final LinkedList expected = new LinkedList();

		final LinkedList actual = new LinkedList();

		LinkedListProblems.reverse(actual);

		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public void reverse_SingleElementList_NoChanges() {
		final LinkedList expected = new LinkedList();
		expected.add(1);

		final LinkedList actual = new LinkedList();
		actual.add(1);

		LinkedListProblems.reverse(actual);

		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public void reverse_MultiElementList_GetsReversed() {
		final LinkedList expected = new LinkedList();
		expected.add(4);
		expected.add(3);
		expected.add(2);
		expected.add(1);

		final LinkedList actual = new LinkedList();
		actual.add(1);
		actual.add(2);
		actual.add(3);
		actual.add(4);

		LinkedListProblems.reverse(actual);

		Assert.assertEquals(actual, expected);		
	}
	
	/* sumLists */
	
	@Test
	public void sumLists_SameLengthsNoCarryOvers_CreatesSumList() {
		final LinkedList expected = new LinkedList();
		expected.add(2);
		expected.add(4);
		expected.add(6);
		
		final LinkedList test = new LinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void sumLists_DifferentLengthsNoCarryOvers_CreatesSumList() {
		final LinkedList expected = new LinkedList();
		expected.add(2);
		expected.add(4);
		expected.add(6);
		expected.add(4);
		expected.add(8);
		expected.add(0);
		expected.add(3);
		
		final LinkedList test = new LinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		
		final LinkedList test2 = new LinkedList();
		test2.add(1);
		test2.add(2);
		test2.add(3);
		test2.add(4);
		test2.add(8);
		test2.add(0);
		test2.add(3);
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void sumLists_BothEmpty_CreatesEmptyList() {
		final LinkedList expected = new LinkedList();
		
		final LinkedList test = new LinkedList();
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void sumLists_DifferentLengthsMultipleCarryOvers_CreatesSumList() {
		final LinkedList expected = new LinkedList();
		expected.add(5);
		expected.add(8);
		expected.add(7);
		expected.add(7);
		expected.add(8);
		expected.add(0);
		expected.add(3);
		
		final LinkedList test = new LinkedList();
		test.add(9);
		test.add(9);
		test.add(9);
		
		final LinkedList test2 = new LinkedList();
		test2.add(6);
		test2.add(8);
		test2.add(7);
		test2.add(6);
		test2.add(8);
		test2.add(0);
		test2.add(3);
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void sumLists_SameLengthsMultipleCarryOvers_CreatesLongerSumList() {
		final LinkedList expected = new LinkedList();
		expected.add(5);
		expected.add(8);
		expected.add(3);
		expected.add(1);
		
		final LinkedList test = new LinkedList();
		test.add(9);
		test.add(8);
		test.add(7);
		
		final LinkedList test2 = new LinkedList();
		test2.add(6);
		test2.add(9);
		test2.add(5);
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void sumLists_OneEmptyList_CreatesSumList() {
		final LinkedList expected = new LinkedList();
		expected.add(6);
		expected.add(9);
		expected.add(5);
		
		final LinkedList test = new LinkedList();
		
		final LinkedList test2 = new LinkedList();
		test2.add(6);
		test2.add(9);
		test2.add(5);
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void sumLists_DifferentLengthsMultipleZeros_CreatesSumList() {
		final LinkedList expected = new LinkedList();
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(1);
		
		final LinkedList test = new LinkedList();
		test.add(1);
		
		final LinkedList test2 = new LinkedList();
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(1);
		
		final LinkedList actual = LinkedListProblems.sumLists(test, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	/* isPalindrome */
	
	@Test
	public void isPalindrome_EmptyList_ReturnsTrue() {
		final boolean expected = true;
		
		final LinkedList test = new LinkedList();
		
		final boolean actual = LinkedListProblems.isPalindrome(test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindrome_SingleElementList_ReturnsTrue() {
		final boolean expected = true;
		
		final LinkedList test = new LinkedList();
		test.add(5);
		
		final boolean actual = LinkedListProblems.isPalindrome(test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindrome_OddNumberElementPalindrome_ReturnsTrue() {
		final boolean expected = true;
		
		final LinkedList test = new LinkedList();
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(6);
		test.add(5);
		
		final boolean actual = LinkedListProblems.isPalindrome(test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindrome_EvenNumberElementPalindrome_ReturnsTrue() {
		final boolean expected = true;
		
		final LinkedList test = new LinkedList();
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(7);
		test.add(6);
		test.add(5);
		
		final boolean actual = LinkedListProblems.isPalindrome(test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindrome_OddNumberElementNonPalindrome_ReturnsFalse() {
		final boolean expected = false;
		
		final LinkedList test = new LinkedList();
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(5);
		
		final boolean actual = LinkedListProblems.isPalindrome(test);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void isPalindrome_EvenNumberElementNonPalindrome_ReturnsFalse() {
		final boolean expected = false;
		
		final LinkedList test = new LinkedList();
		test.add(5);
		test.add(6);
		test.add(6);
		test.add(7);
		test.add(6);
		test.add(5);
		
		final boolean actual = LinkedListProblems.isPalindrome(test);
		
		Assert.assertEquals(actual, expected);
	}
	
	/* getIntersectingNode */
	
	@Test
	public void getIntersectingNode_BothListsEmpty_ReturnsNull() {
		final LinkedListNode expected = null;
		
		final LinkedList test1 = new LinkedList();		
		final LinkedList test2 = new LinkedList();
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getIntersectingNode_OneListEmpty_ReturnsNull() {
		final LinkedListNode expected = null;
		
		final LinkedList test1 = new LinkedList();		
		test1.add(5);
		
		final LinkedList test2 = new LinkedList();
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getIntersectingNode_NoIntersection_ReturnsNull() {
		final LinkedListNode expected = null;
		
		final LinkedList test1 = new LinkedList();		
		test1.add(1);
		test1.add(2);
		
		final LinkedList test2 = new LinkedList();
		test2.add(1);
		test2.add(2);
		test2.add(3);
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getIntersectingNode_IntersectAtStart_ReturnsIntersection() {
		final LinkedListNode expected = new LinkedListNode(1);
		
		final LinkedList test1 = new LinkedList();		
		test1.add(expected);
		
		final LinkedList test2 = new LinkedList();
		test2.add(expected);
		
		expected.next = new LinkedListNode(2);
		expected.next.next = new LinkedListNode(3);
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getIntersectingNode_SameLengthsIntersectAtEnd_ReturnsIntersection() {
		final LinkedListNode expected = new LinkedListNode(3);
		
		final LinkedList test1 = new LinkedList();	
		test1.add(1);
		test1.add(2);
		test1.add(expected);
		
		final LinkedList test2 = new LinkedList();
		test2.add(1);
		test2.add(2);
		test2.add(expected);
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getIntersectingNode_DifferentLengthsIntersectAtEnd_ReturnsIntersection() {
		final LinkedListNode expected = new LinkedListNode(3);
		
		final LinkedList test1 = new LinkedList();	
		test1.add(0);
		test1.add(1);
		test1.add(2);
		test1.add(expected);
		
		final LinkedList test2 = new LinkedList();
		test2.add(1);
		test2.add(2);
		test2.add(expected);
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getIntersectingNode_DifferentLengthsListsIntersectInMiddle_ReturnsIntersection() {
		final LinkedListNode expected = new LinkedListNode(5);
		
		final LinkedList test1 = new LinkedList();		
		test1.add(1);
		test1.add(2);
		test1.add(3);
		test1.add(4);
		test1.add(expected);

		final LinkedList test2 = new LinkedList();
		test2.add(1);
		test2.add(2);
		test2.add(expected);
		
		expected.next = new LinkedListNode(6);
		expected.next.next = new LinkedListNode(7);
		expected.next.next.next = new LinkedListNode(8);
		
		final LinkedListNode actual = LinkedListProblems.getIntersectingNode(test1, test2);
		
		Assert.assertEquals(actual, expected);
	}
}
