package lpenap.hr.challenges.ctci_connected_cell_in_a_grid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Problem statement:
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 * 
 * Solution approach: Perform a recursive DFS over the matrix for each position,
 * skipping empty and already visited cells.
 * 
 * @author lpenap
 *
 */

class Node {
	boolean bit;
	boolean visited;

	Node(boolean bit) {
		this.visited = false;
		this.bit = bit;
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
