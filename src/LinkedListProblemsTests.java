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
}
