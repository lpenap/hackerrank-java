package lpenap.hr.challenges.ctci_lonely_integer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Solution order: O(n) . Problem statement:
 * https://www.hackerrank.com/challenges/ctci-lonely-integer
 * 
 * Solution approach: Apply xor between all the numbers,
 * the remaining xor result will be the lonely integer.
 * 
 * @author lpenap
 *
 */
public class Solution {
	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		int n = in.nextInt();
		int a = 0;
		for (int a_i = 0; a_i < n; a_i++) {
			a ^= in.nextInt();
		}
		System.out.println(a);
		in.close();
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
