package treesAndGraphs;


/**
 *
 * Question:
 * Given the root of a binary search tree and 2 numbers min and max,
 * trim the tree such that all the numbers in the new tree are between min and max (inclusive).
 * The resulting tree should still be a valid binary search tree. So, if we get this tree as input:
 *
 *
 *
 *
 * The complexity of this algorithm is O(N), where N is the number of nodes in the tree.
 * Because we basically perform a post-order traversal of the tree, visiting each and every node one.
 * This is optimal because we should visit every node at least once.
 * This is a very elegant question that demonstrates the effectiveness of recursion in trees.
 */
public class TrimBSTByMinMaxValue {

//    def trimBST(tree, minVal, maxVal):
//            if not tree:
//            return
//    tree.left=trimBST(tree.left, minVal, maxVal)
//    tree.right=trimBST(tree.right, minVal, maxVal)
//    if minVal<=tree.val<=maxVal:
//            return tree
//    if tree.val<minVal:
//            return tree.right
//    if tree.val>maxVal:
//            return tree.left
}
