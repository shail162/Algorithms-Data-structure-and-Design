package treesAndGraphs.Q4_05_Validate_BST;

import library.TreeNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 * Time complexity O(n)
 *
 * In-order traversal
 */
public class ValidBST {


    public static boolean isValidBST(TreeNode node, int prev){

        if (node == null){
            return true;
        }

        if (!isValidBST(node.left, prev)) {
            return false;
        }

        if (prev > node.data){
            return false;
        }

        prev = node.data;
        return isValidBST(node.right, prev);

    }

    public static void main(String[] args) {
        /* Simple test -- create one */
        int[] array = {1, 3, 5, 6, 10, 13, 15, 18};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 7; // "ruin" the BST property by changing one of the elements
        node.print();
        boolean isBst = isValidBST(node, Integer.MIN_VALUE);
        System.out.println(isBst);
    }
}
