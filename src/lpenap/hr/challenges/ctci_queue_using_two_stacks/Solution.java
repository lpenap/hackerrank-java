package lpenap.hr.challenges.ctci_queue_using_two_stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Solution order: O(n) for dequeue and peek, O(1) for enqueue . Problem
 * statement: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 * 
 * Solution approach: Enqueue adding to the first stack and dequeue from the
 * second stack, when the dequeuing stack gets empty, move all from the
 * enqueuing stack to the second.
 * 
 * @author lpenap
 *
 */
public class Solution {
	public class MyQueue<T> {
		protected Stack<T> enqueueStack;
		protected Stack<T> dequeueStack;

		public MyQueue() {
			enqueueStack = new Stack<T>();
			dequeueStack = new Stack<T>();
		}

		public void enqueue(T element) {
			enqueueStack.push(element);
		}

		protected void checkStacks() {
			if (dequeueStack.isEmpty()) {
				while (!enqueueStack.isEmpty()) {
					dequeueStack.push(enqueueStack.pop());
				}
			}
		}

		public void dequeue() {
			checkStacks();
			dequeueStack.pop();
		}

		public T peek() {
			checkStacks();
			return dequeueStack.peek();
		}

	}

	public void runSolution() {
		BufferedReader br = inputFromHackerrank(false);
		Scanner scan = new Scanner(br);

		MyQueue<Integer> queue = new MyQueue<Integer>();
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
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
			return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(DIR_SEP
					+ getClass().getPackage().getName().replaceAll("\\.", DIR_SEP) + DIR_SEP + "input.txt")));
		}
	}
}
