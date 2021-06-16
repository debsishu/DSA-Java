package graphSeries;

import java.util.*;

public class PrimsAlgoGFG {
	public static void main(String[] args) {

	}

	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		int key[] = new int[V];
		int parent[] = new int[V];
		boolean mst[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			mst[i] = false;
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());

		key[0] = 0;
		pq.add(new Node(key[0], 0));

		while (!pq.isEmpty()) {
			int node = pq.poll().v;
			mst[node] = true;

			for (ArrayList<Integer> it : adj.get(node)) {
				if (!mst[it.get(0)] && it.get(1) < key[it.get(0)]) {
					parent[it.get(0)] = node;
					key[it.get(0)] = it.get(1);
					pq.add(new Node(it.get(0), key[it.get(0)]));
				}
			}
		}

		int result = 0;
		for (int e : key) {
			result += e;
		}
		return result;
	}

	static class Node implements Comparator<Node> {
		int v;
		int weight;

		Node() {
		}

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compare(Node node1, Node node2) {
			if (node1.weight < node2.weight) {
				return -1;
			} else if (node1.weight > node2.weight) {
				return 1;
			}
			return 0;
		}
	}
}
