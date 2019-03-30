package treesAndGraphs.treeViews;

import library.TreeNode;

import java.util.*;

/**
 * Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
 *
 *            1
 *         /    \
 *        2      3
 *       / \   /   \
 *      4   5  6   7
 *                /  \
 *               8   9
 *
 *
 * The output of print this tree vertically will be:
 * 4
 * 2
 * 1 5 6
 * 3 8
 * 7
 * 9
 */
public class VerticalOrderTreeTraversal {

    public static void main(String args[]) {
        Map<Integer, List<TreeNode>> distanceMap = new TreeMap<>();
        TreeNode root= TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});

        verticalTraversal(root, distanceMap, 0);
        distanceMap.entrySet().stream().forEach(entry -> {
           System.out.print("[HD=" + entry.getKey() + "] -> ");
            entry.getValue().stream().forEach(node-> System.out.print(node.data + " "));
            System.out.println();
        });
    }


    public static void verticalTraversal(TreeNode root, Map<Integer, List<TreeNode>> distanceMap, int hd){

        if(root == null){
            return;
        }

        List<TreeNode> ls = distanceMap.get(hd);
        if(ls ==null){
            ls = new ArrayList<>();
            distanceMap.put(hd, ls);
        } else {
            ls = distanceMap.get(hd);
        }

        ls.add(root);
        verticalTraversal(root.left, distanceMap,hd-1);
        verticalTraversal(root.right, distanceMap,hd+1);

    }
}

//https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
