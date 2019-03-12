package treesAndGraphs.Introduction;

import library.TreeNode;

public class TreeTraversals {
	public static void visit(TreeNode node) {
		if (node != null) {
			System.out.println(node.data);
		}
	}

	/**
	 * Left - Root - Right
	 * @param node
	 */
	public static void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
	}

	/**
	 * Root - Left - Right
	 * @param node
	 */
	public static void preOrderTraversal(TreeNode node) {
		if (node != null) {
			visit(node);
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
		}
	}

	/**
	 * LEft- Right - Root
	 * @param node
	 */
	public static void postOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
			visit(node);
		}
	}	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		TreeNode root = TreeNode.createMinimalBST(array);
		inOrderTraversal(root);
	}

}
