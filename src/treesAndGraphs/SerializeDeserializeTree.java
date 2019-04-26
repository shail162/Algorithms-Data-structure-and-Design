package treesAndGraphs;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeTree {

    public static void main(String args[]){

       TreeNode root= TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
       List list = new ArrayList();
       serialize(root, list);

       list.stream().forEach(i -> System.out.print(i +" "));
        TreeNode rNode = deserialize(list);
        System.out.println(rNode.data);

    }

    /**
     * Pre-order traversal  [Root - left - right]
     * @param root
     * @param list
     */
    public static void serialize(TreeNode root, List<Integer> list){

        if(root ==null) {
            list.add(-1);
            return;
        }

        list.add(root.data);
        serialize(root.left, list);
        serialize(root.right, list);
    }


    public static TreeNode deserialize(List<Integer> list){
        if(list.get(0)== -1){
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(list.get(0));
        list.remove(0);
        node.left = deserialize(list);
        node.right = deserialize( list);

        return node;
    }

}
