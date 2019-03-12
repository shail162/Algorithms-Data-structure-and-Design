package treesAndGraphs.Introduction;

import treesAndGraphs.Q4_01_Route_Between_Nodes.Node;
import treesAndGraphs.Q4_01_Route_Between_Nodes.Question;

/**
 * Depth first search
 */
public class DFS {

    public void search(Node root){

        if(root == null){
            return;
        }

        root.state = Question.State.Visited;
        visit(root);

        for (Node vertex : root.getAdjacent()){
            if(vertex.state.equals(Question.State.Unvisited)){
                vertex.state = Question.State.Visited;
                search(vertex);
            }
        }
    }

    private void visit(Node root) {
        System.out.println(root.getVertex());
    }
}
