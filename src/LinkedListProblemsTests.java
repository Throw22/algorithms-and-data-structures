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
}
