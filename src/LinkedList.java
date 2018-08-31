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
	
	public LinkedListNode getNode(int data) {
		LinkedListNode current = head;
		
		while (current != null) {
			if (current.data == data) return current;
			current = current.next;
		}
		
		return null;
	}
	
	public void add(int data) {
		LinkedListNode current = head;
		
		if (current == null) {
			head = new LinkedListNode(data);
			return;
		}
		
		while (current.next != null) current = current.next;
		
		current.next = new LinkedListNode(data);
	}
	
	public void add(LinkedListNode node) {
		LinkedListNode current = head;
		
		if (current == null) {
			head = node;
			return;
		}
		
		while (current.next != null) current = current.next;
		
		current.next = node;
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
	
	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof LinkedList)) return false;
		
		LinkedList list = (LinkedList) other;
		
		LinkedListNode current1 = this.head;
		LinkedListNode current2 = list.head;
		
		while (current1 != null && current2 != null) {
			if (current1.data != current2.data) return false;
			current1 = current1.next;
			current2 = current2.next;
		}
		
		if (current1 != null || current2 != null) return false;
		
		return true;
	}
	
	public int hashCode() {
		LinkedListNode current = this.head;
		int hash = 0;
		int multiplier = 7;
		
		while (current != null) {
			hash += current.data * multiplier;
			multiplier+=3;
		}
		
		return hash;
	}
}
