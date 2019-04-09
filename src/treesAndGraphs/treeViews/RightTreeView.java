package treesAndGraphs.treeViews;

import library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightTreeView {

    public static void main(String args[]) {
        List<TreeNode> rightTreeView = new ArrayList<>();

        TreeNode root = TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
        rightTreeView.add(root);
        rightTreeView(root, rightTreeView);

        rightTreeView.stream().forEach(node -> {
            System.out.print(node.data+ " ");
        });
    }

    /**
     * Last node of each level
     * @param root
     * @param rightTreeView
     */
    public static void rightTreeView(TreeNode root,  List<TreeNode> rightTreeView){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            /**
             * check end of level
             */
            if(node == null){
                if(!queue.isEmpty()){
                    level++;
                    rightTreeView.add(((LinkedList<TreeNode>) queue).peekLast()); //Add first node of queue in list
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
