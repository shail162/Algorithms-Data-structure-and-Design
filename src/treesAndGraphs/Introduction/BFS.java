package treesAndGraphs.Introduction;

import treesAndGraphs.Q4_01_Route_Between_Nodes.Graph;
import treesAndGraphs.Q4_01_Route_Between_Nodes.Node;
import treesAndGraphs.Q4_01_Route_Between_Nodes.Question;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Breadth first search, also called as level order traversal.
 */
public class BFS {

    public void traverse(Graph graph){
       Node vertices[] = graph.getNodes();

       Arrays.stream(vertices).forEach(vertex->{
                vertex.state = Question.State.Visiting;
                visitVertex(vertex);
       });
    }

    private void visitVertex(Node vertex) {
        Queue<Node> queue = new ArrayDeque<>();
        vertex.state = Question.State.Visiting;
        queue.add(vertex);

        while (!queue.isEmpty()){
            Node node =  queue.remove();
            node.state = Question.State.Visited;
            for (Node adjacent : node.getAdjacent()){
                if (!adjacent.state.equals(Question.State.Visited)){
                    adjacent.state = Question.State.Visiting;
                    queue.add(adjacent);
                }
            }
        }

        vertex.state = Question.State.Visited;
    }
}
