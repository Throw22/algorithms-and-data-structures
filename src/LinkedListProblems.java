import java.util.*;

import org.testng.Assert;

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
	
	/*
	 * Goal: Move all nodes less than a given value to left of partition,
	 * all nodes more than or equal to value to right of partition
	 * Notes on thought process: 
	 * 1) Each side of partition can be its own new list, just need to
	 * keep track of where they start and end so can be pieced together
	 * 2) Should only require going through original list once, O(N) time
	 */
	
	public static void partition(LinkedList list, int p) {
		LinkedListNode lessThanP = null;
		LinkedListNode pOrGreater = null;
		LinkedListNode startOfPartition = null;
		LinkedListNode current = list.head;
		
		while (current != null) {
			if (current.data < p) {
				if (lessThanP != null) {
					lessThanP.next = current;
					lessThanP = lessThanP.next;
				} else {
					lessThanP = current;
					list.head = current; 
				}
			} else {
				if (pOrGreater != null) {
					pOrGreater.next = current;
					pOrGreater = pOrGreater.next;
				} else {
					pOrGreater = current;
					startOfPartition = current;
				}
			}
			
			current = current.next;
		}
		
		if (lessThanP == null) {
			list.head = startOfPartition;
		} else {
			lessThanP.next = startOfPartition;
		}
		
		if (pOrGreater != null) pOrGreater.next = null;
	}
	
	/*
	 * Goal: Reverse a LinkedList in place
	 * Notes on thought process: 
	 * 1) Can be done in O(N) time by keeping track of the previous
	 * node in the list as we go through and setting its original
	 * next to that previous node and updating as we go
	 */
	
	public static void reverse(LinkedList list) {
		LinkedListNode current = list.head;
		LinkedListNode previous = null;
		LinkedListNode next = null;
		
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		list.head = previous;
	}
	
	/*
	 * Goal: Given two lists of integers that represent a larger integer,
	 * return their sum as its own list of integers
	 * Notes on thought process: 
	 * 1) Each node is a digit, so just add them together to create 
	 * node for new list and keep track of any overflow to be added,
	 * should run in O(N + M) time 
	 */
	
	public static LinkedList sumLists(LinkedList one, LinkedList two) {
		LinkedList sum = new LinkedList();
		LinkedListNode current1 = one.head;
		LinkedListNode current2 = two.head;
		int carryOver = 0;
		
		while (current1 != null || current2 != null) {
			int data1 = current1 != null ? (current1.data) : 0;
			int data2 = current2 != null ? (current2.data) : 0;
			int amountToAdd = (data1 + data2 + carryOver);
			
			if (amountToAdd >= 10) {
				carryOver = amountToAdd / 10;
				amountToAdd %= 10;
			} else {
				carryOver = 0;
			}
			
			sum.add(amountToAdd);
			
			if (current1 != null) current1 = current1.next;
			if (current2 != null) current2 = current2.next;
		}
		
		if (carryOver != 0) sum.add(carryOver);

		return sum;
	}
	
	/*
	 * Goal: Determine if a LinkedList is a palindrome
	 * Notes on thought process: 
	 * 1) If the list had a reference to its tail this would be trivial,
	 * so presumably it's a singly linked list
	 * 2) Moving all the data over to a new data structure would
	 * probably take too much time, even if it's easier to look for
	 * a palindrome in, say, an ArrayList
	 * 3) We only need to store the first half of the list since that's
	 * what should match the second half
	 * 4) A stack would allow us to save the first half of the list and
	 * then pop off in reverse to make comparisons against the back half,
	 * since the stack would lead to a perfect palindrome
	 * 5) Can get to the halfway point of the list using a runner node
	 * that moves twice the rate of the one adding values to our stack
	 */
	
	public static boolean isPalindrome(LinkedList list) {
		Stack<Integer> reversed = new Stack<Integer>();
		LinkedListNode current = list.head;
		LinkedListNode runner = list.head;
		
		while (runner != null && runner.next != null) {
			reversed.push(current.data);
			current = current.next;
			runner = runner.next.next;
		}
		
		if (runner != null) current = current.next;
				
		while (!reversed.isEmpty()) {
			if (reversed.pop() != current.data) return false;
			current = current.next;
		}
		
		return true;
	}
}
