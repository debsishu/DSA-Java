package sorting;

public class MergeTwoSortedLL {
	public static void main(String[] args) {

	}

	Node merge(Node head1, Node head2) {
		Node newHead = new Node(0);
		Node tail = newHead;

		while (true) {
			if (head1 == null) {
				tail.next = head2;
				break;
			}
			if (head2 == null) {
				tail.next = head1;
				break;
			}
			if (head1.data <= head2.data) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		return newHead.next;
	}

	@SuppressWarnings("unused")
	Node merge2(Node head1, Node head2) {
		Node head = new Node(0);
		Node temp = head;

		while (head1 != null || head2 != null) {
			if (head1.data < head2.data) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		if (head1 != null) {
			temp.next = head1;
		}
		if (head2 != null) {
			temp.next = head2;
		}
		return head.next;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
