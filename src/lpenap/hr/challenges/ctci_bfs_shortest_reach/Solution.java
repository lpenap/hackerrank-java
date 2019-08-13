package lpenap.hr.challenges.ctci_bfs_shortest_reach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem statement:
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 * 
 * Solution approach: Build graph with the given n nodes and arcs (edges) given.
 * Perform a BFS over the given graph, calculating the distances.
 * 
 * @author lpenap
 *
 */

class Node {
	protected int id;
	protected List<Integer> neighbors;

	public Node(int id) {
		this.id = id;
		this.neighbors = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "" + id;
	}
}

class Graph {
	public static final int ARC_DISTANCE = 6;
	public static final int NOT_CONNECTED = -1;
	protected Node[] nodes;

	public Graph(int capacity) {
		nodes = new Node[capacity];
		for (int i = 0; i < capacity; i++) {
			nodes[i] = new Node(i);
		}
	}

	protected Node getNode(int id) {
		return nodes[id];
	}

	public void addArc(int first, int second) {
		nodes[first].neighbors.add(second);
	}

	public int[] getShortestDistancesFrom(int nodeId) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(nodeId);

		int[] distances = new int[nodes.length];
		Arrays.fill(distances, NOT_CONNECTED);
		distances[nodeId] = 0;

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			for (int neighbor : nodes[currentNode].neighbors) {
				if (distances[neighbor] == NOT_CONNECTED) {
					//System.out.println("adding");
					distances[neighbor] = ARC_DISTANCE
						+ distances[currentNode];
					queue.add(neighbor);
				}
			}
		}
		return distances;
	}

	/**
	 * Debug only method.
	 */
	@Override
	public String toString() {
		String string = "";
		for (Node node : nodes) {
			string += " " + node.toString() + "[";
			for (int i : node.neighbors) {
				string += " " + nodes[i].toString();
			}
			string += "]";
		}
		return string;
	}
}

public class Solution {
	public void printDistances(int[] distances) {
		boolean first = true;
		for (int j = 0; j < distances.length; j++) {
			if (distances[j] != 0) {
				if (first) {
					first = false;
					System.out.print(distances[j]);
				} else {
					System.out.print(" " + distances[j]);
				}
			}
		}
		System.out.println();
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			Graph graph = new Graph(n);
			for (int j = 0; j < m; j++) {
				int firstNode = scan.nextInt() - 1;
				int secondNode = scan.nextInt() - 1;
				//System.out.println("add "+ firstNode +  " " + secondNode);
				graph.addArc(firstNode, secondNode);
			}
			int startingNode = scan.nextInt() - 1;
			printDistances(graph.getShortestDistancesFrom(startingNode));
		}
		scan.close();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.runSolution();
	}

	public BufferedReader inputFromHackerrank(boolean fromHackerrank) {
		String DIR_SEP = "/";
		if (fromHackerrank) {
			return new BufferedReader(new InputStreamReader(System.in));
		} else {
			return new BufferedReader(
				new InputStreamReader(
					getClass().getResourceAsStream(DIR_SEP
						+ getClass().getPackage().getName()
							.replaceAll("\\.", DIR_SEP)
						+ DIR_SEP + "input.txt")));
		}
	}
}
