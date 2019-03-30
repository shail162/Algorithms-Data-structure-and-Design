package treesAndGraphs.treeViews;

import library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class LevelOrderTraversal {

    public static void main(String args[]) {
        TreeNode node = TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
        levelOrderTraversal(node);
    }

    public static void levelOrderTraversal(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node!=null)
                System.out.print(node.data+ " ");
            /**
             * check end of level
             */
            if(node == null){
                System.out.println("level " + level );
                if(!queue.isEmpty()){
                    level++;
                    queue.add(null);
                }
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
