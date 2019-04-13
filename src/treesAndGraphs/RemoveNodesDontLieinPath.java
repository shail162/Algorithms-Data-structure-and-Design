package treesAndGraphs;

    class Node {
        int data;
        Node left;
        Node right;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // class to truncate binary tree
    class BinaryTree {
        Node root;

        // recursive method to truncate binary tree
        public Node prune(Node root, int sum) {

            // base case
            if (root == null)
                return null;

            // recur for left and right subtree
            root.left = prune(root.left, sum - root.data);
            root.right = prune(root.right, sum - root.data);

            // if node is a leaf node whose data is smaller
            // than the sum we delete the leaf.An important
            // thing to note is a non-leaf node can become
            // leaf when its children are deleted.
            if (isLeaf(root)) {
                if (sum > root.data)
                    root = null;
            }

            return root;
        }

        // utility method to check if node is leaf
        public boolean isLeaf(Node root) {
            if (root == null)
                return false;
            if (root.left == null && root.right == null)
                return true;
            return false;
        }

        // for print traversal
        public void print(Node root) {

            // base case
            if (root == null)
                return;

            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }

    // Driver class to test above function
    public class RemoveNodesDontLieinPath {
        public static void main(String args[]) {

            BinaryTree tree = new BinaryTree();

            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);
            tree.root.left.left.left = new Node(8);
            tree.root.left.left.right = new Node(9);
            tree.root.left.right.left = new Node(12);
            tree.root.right.right.left = new Node(10);
            tree.root.right.right.left.right = new Node(11);
            tree.root.left.left.right.left = new Node(13);
            tree.root.left.left.right.right = new Node(14);
            tree.root.left.left.right.right.left = new Node(15);

            System.out.println("Tree before truncation");
            tree.print(tree.root);

            tree.prune(tree.root, 45);

            System.out.println("\nTree after truncation");
            tree.print(tree.root);
        }
    }

