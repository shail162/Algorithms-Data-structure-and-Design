package treesAndGraphs.Q4_12_Paths_with_Sum;

import library.TreeNode;

/**
 * Root to leaf path sum equal to a given number
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given number. Return false if no such path can be found.
 *
 *           10
 *         /   \
 *        8     2
 *       / \    /
 *      3  5   2
 * For example, in the above tree root to leaf paths exist with following sums.
 *
 * 21 –> 10 – 8 – 3
 * 23 –> 10 – 8 – 5
 * 14 –> 10 – 2 – 2
 *
 * So the returned value should be true only for numbers 21, 23 and 14. For any other number, returned value should be false.
 */
public class TreeWithPathSum {

    public static void main(String args[]) {

        TreeNode root= TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
        boolean result = rootToLeafPathSum(root, 30);
        System.out.println(result);
    }


    public static boolean rootToLeafPathSum(TreeNode root, int sum){

        if(root == null) {
            return sum == 0;
        } else {
            boolean ans = false;
            int subSum = sum - root.data;

            if (subSum == 0 && root.left == null && root.right == null) {
                return true;
            }

            if(root.left!=null){
                ans = ans ||  rootToLeafPathSum(root.left, subSum);
            }
            if (root.right!=null){
                ans = ans ||  rootToLeafPathSum(root.right, subSum);
            }
            return ans;
        }
    }
}
