package lpenap.hr.challenges.ctci_array_left_rotation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Solution order: O(n) Problem statement:
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation .
 * 
 * Solution approach: Make use of the already implemented Collections
 * java API to rotate to the right the equivalent amount of times.
 * 
 * @author lpenap
 *
 */
public class Solution {
	public void printArray(List<Integer> l, int n) {
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				System.out.print(" " + l.get(i));
			} else {
				System.out.print(l.get(i));
			}
		}
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		int n = in.nextInt();
		int k = in.nextInt();
		List<Integer> myList = new ArrayList<>(n);
		for (int a_i = 0; a_i < n; a_i++) {
			myList.add(in.nextInt());
		}
		Collections.rotate(myList, n - k);
		printArray(myList, n);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.runSolution();
	}

	public BufferedReader inputFromHackerrank(boolean fromHackerrank) {
		String DIR_SEP = "/";
		BufferedReader br = null;

		if (fromHackerrank) {
			return new BufferedReader(new InputStreamReader(System.in));
		} else {
			return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(DIR_SEP
					+ getClass().getPackage().getName().replaceAll("\\.", DIR_SEP) + DIR_SEP + "input.txt")));
		}
	}
}
