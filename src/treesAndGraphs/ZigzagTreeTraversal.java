package treesAndGraphs;
// Java implementation of a O(n) time
// method for Zigzag order traversal
import java.util.*;


 class BinaryTreeZig {

        Node rootNode;

        // function to print the
// zigzag traversal
        void printZigZagTraversal() {

            // if null then return
            if (rootNode == null) {
                return;
            }

            // declare two stacks
            Stack<Node> currentLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();

            // push the root
            currentLevel.push(rootNode);
            boolean leftToRight = true;

            // check if stack is empty
            while (!currentLevel.isEmpty()) {

                // pop out of stack
                Node node = currentLevel.pop();

                // print the data in it
                System.out.print(node.data + " ");

                // store data according to current
                // order.
                if (leftToRight) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }

                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                }
                else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }

                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }

                if (currentLevel.isEmpty()) {
                    leftToRight = !leftToRight;
                    Stack<Node> temp = currentLevel;
                    currentLevel = nextLevel;
                    nextLevel = temp;
                }
            }
        }
    }

    public class ZigzagTreeTraversal {

        // driver program to test the above function
        public static void main(String[] args) {
            BinaryTreeZig tree = new BinaryTreeZig();
            tree.rootNode = new Node(1);
            tree.rootNode.left = new Node(2);
            tree.rootNode.right = new Node(3);
            tree.rootNode.left.left = new Node(7);
            tree.rootNode.left.right = new Node(6);
            tree.rootNode.right.left = new Node(5);
            tree.rootNode.right.right = new Node(4);

            System.out.println("ZigZag Order traversal of binary tree is");
            tree.printZigZagTraversal();
        }
    }


