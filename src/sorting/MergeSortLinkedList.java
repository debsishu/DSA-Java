package sorting;

public class MergeSortLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;

		middle.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);
		Node sortedList = merge(left, right);
		return sortedList;
	}

	// You can use any of the merging techniques discussed in MergeTwoSortedLL.java
	private Node merge(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.data < head2.data) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}

	private Node getMiddle(Node head) {
		if (head == null) {
			return head;
		}
		Node slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
