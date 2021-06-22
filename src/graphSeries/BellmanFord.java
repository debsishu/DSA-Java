package graphSeries;

import java.util.*;

public class BellmanFord {
	public static void main(String[] args) {
		int n = 6;
		ArrayList<Node> adj = new ArrayList<>();

		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

		bellmanFord(adj, n, 0);
	}

	static void bellmanFord(ArrayList<Node> adj, int N, int src) {
		int distance[] = new int[N];
		Arrays.fill(distance, 100000000);
		distance[src] = 0;

		// Relax the edges N - 1 times
		for (int i = 1; i <= N - 1; i++) {
			for (Node n : adj) {
				if (distance[n.u] + n.weight < distance[n.v]) {
					distance[n.v] = distance[n.u] + n.weight;
				}
			}
		}

		boolean flag = false;
		// Relax one more time to check if their is a negative cycle
		for (Node n : adj) {
			if (distance[n.u] + n.weight < distance[n.v]) {
				flag = true;
				System.out.println("Negative cycle detected");
				break;
			}
		}

		if (!flag) {
			for (int i = 0; i < N; i++) {
				System.out.println(i + " -- " + distance[i]);
			}
		}
	}

	static class Node {
		int u;
		int v;
		int weight;

		Node(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
}
