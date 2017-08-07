package lpenap.hr.challenges.ctci_is_binary_search_tree;

/**
 * Solution order: O(n) . Problem statement:
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
 * 
 * Solution approach: Traverse the binary tree recursively to check
 * condition for a BST.
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
		Node n = new Node();
		n.data = 20;
		n.left = new Node();
		n.left.data = 10;
		n.right = new Node();
		n.right.data = 30;

		n.left.left = new Node();
		n.left.left.data = 5;
		n.left.right = new Node();
		n.left.right.data = 15;

		n.right.left = new Node();
		n.right.left.data = 29;
		n.right.right = new Node();
		n.right.right.data = 31;

		System.out.println(checkBST(n));
	}

	/**
	 * Only submit checkBST and isBinary methods
	 */
	boolean checkBST(Node root) {
		return isBinary(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBinary(Node n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.data < min || n.data > max) {
			return false;
		}
		return isBinary(n.left, min, n.data) && isBinary(n.right, n.data, max);
	}
}
