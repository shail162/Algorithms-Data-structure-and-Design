package treesAndGraphs;

import library.TreeNode;

/**
 * Find all subtrees with sum equal to K.
 * The time complexity of this algorithm would be similar to all other traversals like postorder, that is, O(n),
 * where ‘n’ is number of nodes in the tree.
 *
 */
public class SubTreesWithSumK {

    static int result =0 ;
    public static void main(String args[]) {

        TreeNode root =  new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-2);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.left. left = new TreeNode(7);
        root.right.left. right = new TreeNode(-9);

        countSubTreesWithSumK(root, 6);
        System.out.println(result);
    }


    /**
     * post order traversal left-right-root
     * @param node
     * @param target
     * @return
     */
    public static int countSubTreesWithSumK(TreeNode node, int target){

        if (node == null){
            return 0;
        }

        int left = countSubTreesWithSumK(node.left, target);
        int right = countSubTreesWithSumK(node.right, target);

        if (left+right+node.data == target){
            System.out.println(left + ", "  + right  + "," + node.data);
            result++;
        }

        return (left+right+node.data);
    }
}
