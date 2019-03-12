package treesAndGraphs.Q4_08_First_Common_Ancestor;

import library.TreeNode;

import java.util.ArrayList;

/**
 * Find lowest common anscentor in binary tree
 * Time complexity O(n)
 * Space complexity O(n)
 *
 *             5
 *  *        /  \
 *  *       2    8
 *  *      / \   / \
 *  *     1  3  6  9
 *  *         \  \  \
 *  *         4  7  10
 */
public class LCABinaryTree {


    public static TreeNode findLCA(TreeNode current, TreeNode nodeA, TreeNode nodeB){

        if(current == null){
            return null;
        }

        if(current == nodeA || current == nodeB){
            return current;
        }

        TreeNode left = findLCA(current.left, nodeA, nodeB);
        TreeNode right = findLCA(current.right, nodeA, nodeB);

        if (left!=null && right!=null){
            return current;
        }

        return left!=null? left : right;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        for (int a : array) {
            nodes.add(root.find(a));
        }
        nodes.add(new TreeNode(11));
        TreeNode r3 = findLCA(root, nodes.get(1), nodes.get(8));
        String s3 = resultToString("C", nodes.get(1), nodes.get(8), r3);

        TreeNode r4 = findLCA(root, nodes.get(2), nodes.get(3));
        String s4 = resultToString("D", nodes.get(2), nodes.get(3), r4);


        TreeNode r5 = findLCA(root, nodes.get(9), nodes.get(5));
        String s5 = resultToString("D", nodes.get(9), nodes.get(5), r5);

        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }

    public static String resultToString(String s, TreeNode x, TreeNode y, TreeNode anc) {
        s += ": ";
        s += (x == null ? "null" : x.data);
        s += " & ";
        s += (y == null ? "null" : y.data);
        s += " -> ";
        s += (anc == null ? "null" : anc.data);
        return s;
    }
}
