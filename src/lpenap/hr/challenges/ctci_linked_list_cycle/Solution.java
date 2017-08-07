package lpenap.hr.challenges.ctci_linked_list_cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution order: O(n) . Problem statement:
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle
 * 
 * Solution approach: Mark each visited node in an ArrayList and check whether
 * or not the node has been visited.
 * 
 * @author lpenap
 *
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		Solution sol = new Solution();
		sol.run();
	}

	public void run() {
		// test case 1
		Node n = null;

		System.out.println(hasCycle(n));

		// test case 2
		Node head = new Node();
		head.data = 1;

		head.next = new Node();
		Node n2 = head.next;
		head.next.data = 2;

		head.next.next = new Node();
		head.next.next.data = 3;
		head.next.next.next = n2;

		System.out.println(hasCycle(head));

	}

	boolean hasCycle(Node head) {
		List<Node> marks = new ArrayList<Node>();
		Node n = head;
		while (n != null) {
			if (marks.contains(n)) {
				return true;
			} else {
				marks.add(n);
			}
			n = n.next;
		}
		return false;
	}
}
