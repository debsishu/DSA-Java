package sorting;

public class QuickSortLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static void quickSort(Node start, Node end) {
		if (start == null || start == end || start == end.next) {
			return;
		}

		Node pivot_prev = partitionLast(start, end);
		quickSort(start, pivot_prev);

		if (pivot_prev != null && pivot_prev == start) {
			quickSort(pivot_prev.next, end);
		} else if (pivot_prev != null && pivot_prev.next != null) {
			quickSort(pivot_prev.next.next, end);
		}
	}

	static Node partitionLast(Node start, Node end) {
		if (start == end || start == null || end == null) {
			return start;
		}

		Node pivot_prev = start;
		Node curr = start;
		int pivot = end.data;

		while (start != end) {
			if (start.data < pivot) {
				pivot_prev = curr;
				int temp = curr.data;
				curr.data = start.data;
				start.data = temp;
				curr = curr.next;
			}
			start = start.next;
		}

		int temp = curr.data;
		curr.data = pivot;
		end.data = temp;

		return pivot_prev;
	}

}
