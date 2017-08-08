package lpenap.hr.challenges.ctci_bfs_shortest_reach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem statement:
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 * 
 * Solution approach: Perform a BFS over the given graph, calculating
 * the distances.
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
}
class Graph {
	public static final int ARC_DISTANCE = 6;
	protected Node[] nodes;
	
	public Graph(int capacity) {
		nodes = new Node[capacity];
	}
	
	protected Node getNode(int id) {
		return nodes[id];
	}
	
	public void addArc (int first, int second) {
		nodes[first] = new Node(first);
		nodes[second] = new Node(second);
		
		nodes[first].neighbors.add(first);
		nodes[second].neighbors.add(first);
	}
	
	public int[] getShortestDistancesFrom (int nodeId) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
	}
}



public class Solution {
	public int findRegionSize(Node[][] matrix, int rows, int cols, int i,
		int j) {

		if (i < 0 || i >= rows || j < 0 || j >= cols) {
			return 0;
		}

		if (matrix[i][j].visited || !matrix[i][j].bit) {
			return 0;
		}

		int regionSize = 1;
		matrix[i][j].visited = true;

		for (int row = i - 1; row <= i + 1; row++) {
			for (int col = j - 1; col <= j + 1; col++) {
				regionSize += findRegionSize(matrix, rows, cols, row,
					col);
			}
		}
		return regionSize;
	}

	public int findLargestRegion(Node[][] matrix, int rows, int cols) {
		int largestRegionSize = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int regionSize = findRegionSize(matrix, rows, cols, i,
					j);
				if (regionSize > largestRegionSize) {
					largestRegionSize = regionSize;
				}
			}
		}
		return largestRegionSize;
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		Node[][] matrix = new Node[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = new Node(
					scan.nextInt() == 1 ? true : false);
			}
		}
		scan.close();
		System.out.println(findLargestRegion(matrix, rows, cols));
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
