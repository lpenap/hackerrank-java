package lpenap.hr.challenges.ctci_ransom_note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution order: O(n) Problem statement:
 * https://www.hackerrank.com/challenges/ctci-ransom-note .
 * 
 * Solution approach: Create a hash to keep count of magazine words. Then
 * substract each word found on the hash form the ransom word. If all the words
 * from the ransom note can be decremented from the hash, then the answer is
 * Yes.
 * 
 * @author lpenap
 *
 */
public class Solution {

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		int m = in.nextInt();
		int n = in.nextInt();
		HashMap<String, Integer> magazine = new HashMap<String, Integer>();
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			String word = in.next();
			int count = 1;
			if (magazine.containsKey(word)) {
				count += magazine.get(word);
			}
			magazine.put(word, count);
		}

		boolean canWriteRansom = true;
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			String word = in.next();
			if (magazine.containsKey(word)) {
				int currentCount = magazine.get(word) - 1;
				if (currentCount > 0) {
					magazine.put(word, currentCount);
				} else {
					magazine.remove(word);
				}
			} else {
				canWriteRansom = false;
				break;
			}
		}
		if (canWriteRansom) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
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
