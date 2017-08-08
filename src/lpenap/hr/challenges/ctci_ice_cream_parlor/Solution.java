package lpenap.hr.challenges.ctci_ice_cream_parlor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution order: O (n log n). Problem statement:
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 * 
 * Solution approach: For each flavor cost, perform a binary search of the
 * remaining money complement until the first pair of matching flavors is found.
 * An additional method or structure to find the original indexes given the
 * costs found will be needed.
 * 
 * @author lpenap
 *
 */

public class Solution {

	public void findFlavors(int flavors[], int money) {
		int[] sortedFlavors = flavors.clone();
		Arrays.sort(sortedFlavors);
		for (int i = 0; i < sortedFlavors.length; i++) {
			int remainingMoney = money - sortedFlavors[i];
			int searchIndex = Arrays.binarySearch(sortedFlavors, i + 1,
				sortedFlavors.length, remainingMoney);

			if (searchIndex >= 0 && searchIndex < sortedFlavors.length
				&& sortedFlavors[searchIndex] == remainingMoney) {
				int flavorA = findIndex(flavors, sortedFlavors[i], -1);
				int flavorB = findIndex(flavors, remainingMoney,
					flavorA);
				if (flavorA < flavorB) {
					System.out.printf("%d %d\n", ++flavorA,
						++flavorB);
				} else {
					System.out.printf("%d %d\n", ++flavorB,
						++flavorA);
				}
			}
		}
	}

	public int findIndex(int[] flavors, int cost, int exclude) {
		for (int i = 0; i < flavors.length; i++) {
			if (i != exclude && flavors[i] == cost) {
				return i;
			}
		}
		return -1;
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);
		int trips = scan.nextInt();

		for (int trip = 0; trip < trips; trip++) {
			int money = scan.nextInt();
			int n = scan.nextInt();
			int[] flavors = new int[n];
			for (int i = 0; i < n; i++) {
				flavors[i] = scan.nextInt();
			}
			findFlavors(flavors, money);
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
