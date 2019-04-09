package treesAndGraphs.Q4_04_Check_Balanced;

import library.TreeNode;

/**
 *  https://www.youtube.com/watch?v=TWDigbwxuB4
 *  Implement a function to check if a binary tree is balanced. For the purpose of this question,
 *  a balanced tree is defined to be a tree such that the heights of the two subtrees
 *  of any node never differ by more than once.
 *  Time complexity O(n)
 *  Space complexity O(n)
 */
public class CheckBalancedTree {


    public static int isBalancedTree(TreeNode node){

        if(node == null){
            return 0;
        }

        int leftHeight = isBalancedTree(node.left);
        if (leftHeight == -1){
            return -1;
        }

        int rightHeight = isBalancedTree(node.right);
        if(rightHeight == -1){
            return -1;
        }

        if ((Math.abs(leftHeight - rightHeight)) > 1) {
            return -1;
        }

        return (1 + (Math.max(leftHeight, rightHeight))) ;

    }

    public static void main(String args[]){
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);


        System.out.println(isBalancedTree(root) == -1 ? false : true);

        root.insertInOrder(4); // Add 4 to make it unbalanced

        System.out.println(isBalancedTree(root)== -1 ? false :true);
    }

}
