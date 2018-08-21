/* Written by Nicholas Romeo
 * 
 * The following is a basic Linked List implementation
 * for testing a variety of programming problems.
 */

public class LinkedList {
	LinkedListNode head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public void add(int data) {
		LinkedListNode current = head;
		
		if (current == null) current = new LinkedListNode(data);
		
		while (current.next != null) current = current.next;
		
		current.next = new LinkedListNode(data);
	}
	
	public void remove(int data) {
		LinkedListNode current = head;
		
		if (current.data == data) head = current.next;
		
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
			}
			current = current.next;
		}
	}
	
	public boolean equals(LinkedList other) {
		LinkedListNode current1 = this.head;
		LinkedListNode current2 = other.head;
				
		while (current1 != null && current2 != null) {
			if (current1.next == null && current2.next != null) return false;
			if (current2.next == null && current1.next != null) return false;
			if (current1.data != current2.data) return false;
		}
		
		return true;
	}
}
