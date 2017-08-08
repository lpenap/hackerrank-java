package lpenap.hr.challenges.ctci_comparator_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/ctci-comparator-sorting
 * 
 * Solution approach: Implement Comparator interface according to problem
 * statement. It will be required to reverse standard comparator results to
 * achieve decreasing order.
 * 
 * @author lpenap
 *
 */

/**
 * Submit only the code for this Checker class as indicated in problem
 * statement.
 *
 */
class Checker implements Comparator<Player> {
	@Override
	public int compare(Player p1, Player p2) {
		if (p1.score < p2.score) {
			return 1;
		} else if (p1.score > p2.score) {
			return -1;
		} else {
			return p1.name.compareTo(p2.name);
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class Solution {

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
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
