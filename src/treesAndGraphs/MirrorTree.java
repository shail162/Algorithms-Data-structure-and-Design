package treesAndGraphs;

/**
 * Create a mirror tree from the given binary tree
 * Given a binary tree, the task is to create a new binary tree which is a mirror image of the given binary tree
 *
 * Approach: Write a recursive function that will take two nodes as the argument, one of the original tree and the other of the newly created tree.
 * Now, for every passed node of the original tree, create a corresponding node in the mirror tree and
 * then recursively call the same method for the child nodes
 * but passing the left child of the original tree node with the right child of the mirror tree node and the
 * right child of the original tree node with the left child of the mirror tree node.
 */
public class MirrorTree {

    // A binary tree node has data, pointer to
    // left child and a pointer to right child
    static class node
    {
        int val;
        node left;
        node right;
    }

    // Helper function that allocates
// a new node with the given data
// and null left and right pointers
    static node createNode(int val)
    {
        node newNode = new node();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    // Helper function to print Inorder traversal
    static void inorder(node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.printf("%d ", root.val);
        inorder(root.right);
    }

    // mirrorify function takes two trees,
// original tree and a mirror tree
// It recurses on both the trees,
// but when orignal tree recurses on left,
// mirror tree recurses on right and
// vice-versa
    static node mirrorify(node root)
    {
        if (root == null)
        {
            return null;

        }

        // Create new mirror node from orignal tree node
        node mirror = createNode(root.val);
        mirror.right = mirrorify(root.left);
        mirror.left = mirrorify(root.right);
        return mirror;
    }

    // Driver code
    public static void main(String args[])
    {

        node tree = createNode(5);
        tree.left = createNode(3);
        tree.right = createNode(6);
        tree.left.left = createNode(2);
        tree.left.right = createNode(4);

        // Print inorder traversal of the input tree
        System.out.printf("Inorder of original tree: ");
        inorder(tree);
        node mirror = null;
        mirror = mirrorify(tree);

        // Print inorder traversal of the mirror tree
        System.out.printf("\nInorder of mirror tree: ");
        inorder(mirror);
    }
}
