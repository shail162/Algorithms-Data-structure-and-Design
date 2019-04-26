package treesAndGraphs.treeViews;

import library.AssortedMethods;
import library.TreeNode;

import java.util.*;

public class BottomTreeView {
    public static void main(String args[]) {
        Map<Integer, TreeNode> distanceMap = new HashMap<>();
        TreeNode root = TreeNode.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});

        bottomTreeView(root);
}


    /**
     *  Every time we find a node having same horizontal distance we need to replace
     *  the data in the map.
     * @param root
     */
    // Method that prints the bottom view.
    public static void bottomTreeView(TreeNode root)
    {
        if (root == null)
            return;

        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;

        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue to store tree nodes in level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);

        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty())
        {
            TreeNode temp = queue.remove();

            // Extract the horizontal distance value from the
            // dequeued tree node.
            hd = temp.hd;

            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);

            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        // Make an iterator
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
}
