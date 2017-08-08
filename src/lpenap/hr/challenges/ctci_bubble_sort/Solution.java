package lpenap.hr.challenges.ctci_bubble_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Solution order: O(n^2). Problem:
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 * 
 * Solution approach: Accumulate number of swaps and build an instance of a
 * summary class with the required values.
 * 
 * @author lpenap
 *
 */
public class Solution {
	protected class Result {
		int numSwaps;
		int first;
		int last;

		protected void print() {
			System.out.printf("Array is sorted in %d swaps.\n", numSwaps);
			System.out.printf("First Element: %d\n", first);
			System.out.printf("Last Element: %d", last);
		}
	}

	protected Result bubbleSort(int a[], int n) {
		Result result = new Result();
		result.numSwaps = 0;
		for (int i = 0; i < n; i++) {
			int numberOfSwaps = 0;
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
					numberOfSwaps++;
				}
			}
			result.numSwaps += numberOfSwaps;
			if (numberOfSwaps == 0) {
				break;
			}
		}
		result.first = a[0];
		result.last = a[n - 1];
		return result;
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		scan.close();
		bubbleSort(a, n).print();
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
