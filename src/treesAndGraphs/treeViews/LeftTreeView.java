package treesAndGraphs.treeViews;

import library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftTreeView {

    public static void main(String args[]) {
        List<TreeNode> leftTreeView = new ArrayList<>();

        TreeNode root = TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
        leftTreeView.add(root);
        leftView(root, leftTreeView);

        leftTreeView.stream().forEach(node -> {
            System.out.print(node.data+ " ");
        });
    }

    public static void leftView(TreeNode root,  List<TreeNode> leftTreeView){

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
                        queue.add(null);
                        leftTreeView.add(queue.peek()); //Add first node of queue in list
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
