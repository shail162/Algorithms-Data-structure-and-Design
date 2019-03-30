package treesAndGraphs.treeViews;

import library.TreeNode;

import java.util.*;

public class DiagonalTraversalTree {


    public static void main(String args[]) {
        HashMap<Integer, List<Integer>> diagonalPrint = new HashMap<>();
        TreeNode root = TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
        diagonalPrintUtil(root, 0, diagonalPrint);

        System.out.println("Diagonal Traversal of Binary Tree");
        for (Map.Entry<Integer, List<Integer>> entry : diagonalPrint.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }
    /* root - root of the binary tree
    d -  distance of current line from rightmost
            -topmost slope.
    diagonalPrint - HashMap to store Diagonal
    elements (Passed by Reference) */
    static void diagonalPrintUtil(TreeNode root, int d,
                                  HashMap<Integer, List<Integer>> diagonalPrint){

        // Base case
        if (root == null)
            return;

        // get the list at the particular d value
        List<Integer> k = diagonalPrint.get(d);

        // k is null then create a vector and store the data
        if (k == null)
        {
            k = new ArrayList<>();
            k.add(root.data);
        }

        // k is not null then update the list
        else
        {
            k.add(root.data);
        }

        // Store all nodes of same line together as a vector
        diagonalPrint.put(d, k);

        // Increase the vertical distance if left child
        diagonalPrintUtil(root.left, d + 1, diagonalPrint);

        // Vertical distance remains same for right child
        diagonalPrintUtil(root.right, d, diagonalPrint);
    }
}
