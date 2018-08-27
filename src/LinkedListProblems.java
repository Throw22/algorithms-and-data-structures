import java.util.*;

/* Written by Nicholas Romeo
 * 
 * The following are possible solutions to a variety of 
 * programming problems involving Linked Lists, along
 * with some thoughts about the problems along the way.
 */

public class LinkedListProblems {
	
	/*
	 * Goal: Remove all duplicates from a LinkedList.
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
		
		if (current != null) {
			seen.add(current.data);
		}
		
		while (current.next != null) {
			if (seen.contains(current.next.data)) {
				current.next = current.next.next;
			} else {
				seen.add(current.next.data);
				current = current.next;
			}
		}
	}
	
	public static void removeDuplicatesWithoutBuffer(LinkedList list) {
		LinkedListNode current = list.head;
		LinkedListNode advance = list.head;
				
		while (current != null && current.next != null) {
			advance = current;
			while (advance != null && advance.next != null) {
				if (current.data == advance.next.data) {
					advance.next = advance.next.next;
				} else {
					advance = advance.next;
				}
			}
			current = current.next;
		}
		
	}
	
	/*
	 * Goal: Return kth element from end of LinkedList
	 * Notes on thought process: 
	 * 1) LinkedList won't allow for indexing, but ArrayList would,
	 * could add all values to ArrayList to get value in O(N) time
	 * 2) If cannot use additional data structure, could use two
	 * references to Nodes that are k elements apart so that when
	 * one hit the end of the list the other would be on the kth to
	 * last, also O(N) time
	 */
	
	public static int getKthFromLast(LinkedList list, int k) {
		if (k < 1) throw new IllegalArgumentException("k is less than 1: " + k);
		
		LinkedListNode front = list.head;
		LinkedListNode kthBack = list.head;
		
		while (front != null && k > 1) {
			front = front.next;
			k--;
		}
		
		while (front != null && front.next != null) {
			front = front.next;
			kthBack = kthBack.next;
		}
		
		return kthBack.data;
	}
	
	/*
	 * Goal: Delete a given node in the middle of a list without
	 * any additional references
	 * Notes on thought process: 
	 * 1) Since we don't have access to the head of the list can't
	 * iterate from beginning
	 * 2) A normal removal method just redirects past the node to
	 * be deleted so nothing is pointing to it, could do that by
	 * copying the next node onto the one to be deleted and deleting
	 * the old next instead
	 * 3) Won't work for last node, and breaks current 
	 * implementation of LinkedList if used on first node (can't
	 * set head to next node)
	 */
	
	public static void removeFromMiddle(LinkedListNode node) {
		if (node == null || node.next == null) return;
		
		node.data = node.next.data;
		node.next = node.next.next;
	}
}
