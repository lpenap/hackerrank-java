package lpenap.hr.challenges.ctci_contacts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution order: Add contact: O(n^2) . Find contact: O(1). Problem statement:
 * https://www.hackerrank.com/challenges/ctci-contacts
 * 
 * Solution approach: Construct a Trie with all possible prefixes when adding a
 * contact.
 * 
 * @author lpenap
 *
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		Solution sol = new Solution();
		sol.runSolution();
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		int n = in.nextInt();
		HashMap<String, Integer> prefixes = new HashMap<String, Integer>();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op.equals("add")) {
				addContact(prefixes, contact);
			} else {
				findContact(prefixes, contact);
			}
		}
		in.close();
	}

	public void addContact(HashMap<String, Integer> map, String name) {
		int size = name.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buffer.append(name.charAt(i));
			if (map.containsKey(buffer.toString())) {
				int count = map.get(buffer.toString());
				map.put(buffer.toString(), count + 1);
			} else {
				map.put(buffer.toString(), 1);
			}
		}

	}

	public void findContact(HashMap<String, Integer> map, String name) {
		Integer count = map.get(name);
		System.out.println(count == null ? "0" : count);
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
