package lpenap.hr.challenges.ctci_balanced_brackets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Solution order: O(n) . Problem statement:
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * 
 * Solution approach: stack every opening bracket and check the top of the stack
 * when found a closing one. If they don't match, the expression is not balanced
 * if they do, pop the top of the stack and continue.
 * 
 * @author lpenap
 *
 */
public class Solution {
	public boolean isOpening(Character bracket) {
		switch (bracket) {
		case '{':
		case '[':
		case '(':
			return true;
		default:
			return false;
		}
	}

	public boolean bracketMatches(Character left, Character right) {
		switch (left) {
		case '{':
			return '}' == right.charValue();
		case '[':
			return ']' == right.charValue();
		case '(':
			return ')' == right.charValue();
		}
		return false;
	}

	public boolean isBalanced(String exp) {
		Stack<Character> stack = new Stack<Character>();
		Character bracket = null;
		for (int i = 0; i < exp.length(); i++) {
			bracket = exp.charAt(i);
			if (isOpening(bracket)) {
				stack.push(bracket);
			} else {
				if (stack.isEmpty() || !bracketMatches(stack.peek(), bracket)) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		int n = in.nextInt();
		for (int a_i = 0; a_i < n; a_i++) {
			String expression = in.next();
			System.out.println(isBalanced(expression) ? "YES" : "NO");
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
