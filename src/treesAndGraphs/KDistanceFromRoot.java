package treesAndGraphs;

/**
 * Print nodes at k distance from root
 * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
 * For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
 *             1
 *           /   \
 *         2      3
 *       /  \    /
 *     4     5  8
 */
public class KDistanceFromRoot {
    // Java program to print nodes at k distance from root

        Node root;

        void printKDistant(Node node, int k)
        {
            if (node == null)
                return;
            if (k == 0)
            {
                System.out.print(node.data + " ");
                return;
            }
            else
            {
                printKDistant(node.left, k - 1);
                printKDistant(node.right, k - 1);
            }
        }

        /* Driver program to test above functions */
        public static void main(String args[]) {
            KDistanceFromRoot tree = new KDistanceFromRoot();

        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8
        */
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(8);

            tree.printKDistant(tree.root, 2);
        }
}


