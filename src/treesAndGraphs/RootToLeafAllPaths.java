package treesAndGraphs;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafAllPaths {

    public static void main(String args[]) {

        List<TreeNode> temp = new ArrayList<>();
        List<List<TreeNode>> allList = new ArrayList<>();

        TreeNode root = TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9,10});
        temp.add(root);
        printAllRootToLeafPaths(root, allList, temp);

        for (List<TreeNode> list : allList) {
            list.forEach(node->{
                System.out.print(node.data + " ");
            });
            System.out.println();
        }
    }


    public static void printAllRootToLeafPaths(TreeNode node, List<List<TreeNode>> allList, List<TreeNode> temp){

        if(node == null){
            return ;
        }

        if(node.left == null && node.right == null){
            List<TreeNode> temp1 = new ArrayList<>(temp);
            allList.add(temp1);
            temp.remove(temp.size()-1);
        } else {
            if (node.left!=null){
                temp.add(node.left);
                printAllRootToLeafPaths(node.left, allList, temp);
            }

            if(node.right!=null){
                temp.add(node.right);
                printAllRootToLeafPaths(node.right, allList, temp);
            }

            temp.remove(temp.size()-1);
        }
    }
}


