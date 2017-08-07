package lpenap.hr.challenges.ctci_making_anagrams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution order: O(n) . Problem statement:
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 * 
 * Solution approach: Maintain a map with character counts,
 * adding while circling through the first string, and subtracting
 * while circling through the second string.
 * 
 * @author lpenap
 *
 */
public class Solution {

	public int numberNeeded(String first, String second) {
		HashMap<Character, Integer> marks = new HashMap<Character, Integer>();

		for (int i = 0; i < first.length(); i++) {
			Character c = first.charAt(i);
			if (marks.containsKey(c)) {
				marks.put(c, marks.get(c) + 1);
			} else {
				marks.put(c, 1);
			}
		}

		int overflow = 0;
		for (int i = 0; i < second.length(); i++) {
			Character c = second.charAt(i);
			if (marks.containsKey(c)) {
				marks.put(c, marks.get(c) - 1);
			} else {
				overflow++;
			}
		}

		for (Map.Entry<Character, Integer> entry : marks.entrySet()) {
			overflow += Math.abs(entry.getValue());
		}
		return overflow;

	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
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
