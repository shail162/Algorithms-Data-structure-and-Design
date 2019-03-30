package treesAndGraphs.treeViews;

import library.TreeNode;

import java.util.*;

public class TopTreeView {
    public static void main(String args[]) {
        Map<Integer, List<TreeNode>> distanceMap = new TreeMap<>();
        TreeNode root= TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});

        topTreeView(root);
    }


    public static void topTreeView(TreeNode root){

        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<Integer, TreeNode>();

        if (root == null) {
            return;
        } else {
            q.add(root);
        }

        System.out.println("The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            TreeNode tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode);
            }

            if (tmpNode.left != null) {
                tmpNode.left.hd = tmpNode.hd - 1;
                q.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                tmpNode.right.hd = tmpNode.hd + 1;
                q.add(tmpNode.right);
            }

        }
        for (Map.Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data +" ");
        }
    }
}
