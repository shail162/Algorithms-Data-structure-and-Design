package treesAndGraphs.Q4_08_First_Common_Ancestor;

import library.TreeNode;

public class LCABST {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeNode.createMinimalBST(array);

        TreeNode nodeA = new TreeNode(7);
        TreeNode nodeB = new TreeNode(9);

        System.out.println("LCA : " + findLCAofBST(root, nodeA, nodeB).data);
    }

    public static TreeNode findLCAofBST(TreeNode root, TreeNode nodeA, TreeNode nodeB){

        while(Boolean.TRUE){

            if((nodeA.data < root.data && nodeB.data > root.data) || root.data == nodeA.data || root.data ==nodeB.data){
                return root;
            } else if (nodeA.data < root.data && nodeB.data < root.data ){
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}