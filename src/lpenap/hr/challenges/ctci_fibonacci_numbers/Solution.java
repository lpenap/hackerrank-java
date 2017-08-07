package lpenap.hr.challenges.ctci_fibonacci_numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Solution order: O(2^n) . Problem statement:
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers
 * 
 * Solution approach: Implement recursive fibonacci.
 * 
 * @author lpenap
 *
 */
public class Solution {

	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		int n = in.nextInt();
		in.close();
		System.out.println(fibonacci(n));
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
			return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(DIR_SEP
					+ getClass().getPackage().getName().replaceAll("\\.", DIR_SEP) + DIR_SEP + "input.txt")));
		}
	}
}
