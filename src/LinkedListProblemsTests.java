import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ExpectedExceptionsHolder;

public class LinkedListProblemsTests {
	/* removeDuplicates */
	
	@Test
	public void removeDuplicates_OneDuplicateAtEnd_RemovesDuplicate() {
	    final boolean expectedEquals = true;
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
	    
	    final boolean actualEquals = expected.equals(actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void removeDuplicates_MultipleDuplicates_RemovesDuplicates() {
	    final boolean expectedEquals = true;
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(3);
	    actual.add(2);
	    actual.add(3);
	    actual.add(1);
	    actual.add(4);
	    actual.add(1);
	    actual.add(4);
	    
	    LinkedListProblems.removeDuplicates(actual);
	    
	    final boolean actualEquals = expected.equals(actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void removeDuplicates_NoDuplicates_DoesNothing() {
	    final boolean expectedEquals = true;
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
	    
	    final boolean actualEquals = expected.equals(actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
/* removeDuplicatesWithoutBuffer */
	
	@Test
	public void removeDuplicatesWithoutBuffer_OneDuplicateAtEnd_RemovesDuplicate() {
	    final boolean expectedEquals = true;
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
	    
	    final boolean actualEquals = expected.equals(actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void removeDuplicatesWithoutBuffer_MultipleDuplicates_RemovesDuplicates() {
	    final boolean expectedEquals = true;
		final LinkedList expected = new LinkedList();
	    expected.add(1);
	    expected.add(2);
	    expected.add(3);
	    expected.add(4);
	    
	    final LinkedList actual = new LinkedList();
	    actual.add(1);
	    actual.add(3);
	    actual.add(2);
	    actual.add(3);
	    actual.add(1);
	    actual.add(4);
	    actual.add(1);
	    actual.add(4);
	    
	    LinkedListProblems.removeDuplicatesWithoutBuffer(actual);
	    
	    final boolean actualEquals = expected.equals(actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
	}
	
	@Test
	public void removeDuplicatesWithoutBuffer_NoDuplicates_DoesNothing() {
	    final boolean expectedEquals = true;
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
	    
	    final boolean actualEquals = expected.equals(actual);
	    
	    Assert.assertEquals(actualEquals, expectedEquals);
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
