package lpenap.hr.challenges.ctci_find_the_running_median;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Solution order: O(n^2). Problem:
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 * 
 * Solution approach: Keep two heaps (PriorityQueues) ordered at each insertion
 * and use the heads to calculate the median.
 * 
 * @author lpenap
 *
 */
public class Solution {
	protected void shiftQueues(PriorityQueue<Integer> low,
		PriorityQueue<Integer> high) {
		while (!high.isEmpty() && !low.isEmpty()
			&& (low.peek() > high.peek())) {
			Integer toHigh = low.poll();
			Integer toLow = high.poll();
			low.add(toLow);
			high.add(toHigh);
		}
	}

	protected double getMedian(PriorityQueue<Integer> low,
		PriorityQueue<Integer> high) {
		double median = 0;
		if (low.size() == high.size()) {
			median = (low.peek() + high.peek()) / 2.0;
		} else {
			median = low.peek();
		}
		return median;
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);
		int n = scan.nextInt();

		PriorityQueue<Integer> low = new PriorityQueue<Integer>(
			Comparator.reverseOrder());
		PriorityQueue<Integer> high = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			PriorityQueue<Integer> smallerQueue = low.size() <= high
				.size() ? low : high;
			smallerQueue.add(scan.nextInt());
			shiftQueues(low, high);
			System.out.println(getMedian(low, high));
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
