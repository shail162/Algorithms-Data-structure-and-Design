package treesAndGraphs;

import library.BTreePrinter;
import library.TreeNode;

public class FindDiameterOfTree {
    static int diameter = 0;
    public static void main(String args[]){

        TreeNode root = TreeNode.createMinimalBST(new int[] {1,2,3,4,5,6,7,8,9, 10,11,12,13,14,15,16,17});
        BTreePrinter.printNode(root);

        int diameterOpt = DiameterTree(root, 0);
        System.out.println(diameter);

    }

    //Time Complexity: O(n^2)
    public static int findDiameter(TreeNode node, int max){
        if (node == null){
            return 0;
        }

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        max  = 1 + Math.max((lHeight + rHeight), max);

        findDiameter(node.left , max);
        findDiameter(node.right, max);

        return max;
    }


    public static int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return 1 + Math.max(lHeight, rHeight);
    }

    /**
     * Optimized O(n)
     *  define height =0 globally and  call diameterOpt(root,height)
     *        from main
     *
     */
   static int DiameterTree(TreeNode root, int diameter) {
        int left, right;
        if (root== null)
            return 0;

        left  = DiameterTree(root.left, diameter);
        right = DiameterTree(root.right, diameter);
        if (left + right > diameter)
            diameter = left + right;

        return Math.max(left, right) + 1;
    }
}
