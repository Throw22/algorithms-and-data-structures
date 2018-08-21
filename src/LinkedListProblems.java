import java.util.*;

/* Written by Nicholas Romeo
 * 
 * The following are possible solutions to a variety of 
 * programming problems involving Linked Lists, along
 * with some thoughts about the problems along the way.
 */

public class LinkedListProblems {
	
	/*
	 * Goal: remove all duplicates from a LinkedList.
	 * Notes on thought process: 
	 * 1) Sets are great for weeding out duplicates, tracking all
	 * values in a HashSet would allow for removal in O(N) time
	 * 2) If no extra data structures are allowed, can use two nodes
	 * to track both the current value and check ahead for duplicates,
	 * but this would run in O(N^2) time
	 */
	
	public static void removeDuplicates(LinkedList list) {
		LinkedListNode current = list.head;
		Set<Integer> seen = new HashSet<>();
		
		if (current != null) seen.add(current.data);
		
		while (current != null && current.next != null) {
			if (seen.contains(current.next.data)) {
				current.next = current.next.next;
			} else {
				seen.add(current.next.data);
			}
			current = current.next;
		}
	}
	
	public static void removeDuplicatesWithoutBuffer(LinkedList list) {
		LinkedListNode current = list.head;
		LinkedListNode advance = list.head;
		
		if (current == null) return;
		
		while (current.next != null) {
			advance = current;
			while (advance.next != null) {
				if (current.data == advance.next.data) {
					advance.next = advance.next.next;
				}
				advance = advance.next;
			}
			current = current.next;
		}
	}
}
