package run;

import core.graph_components.Edge;
import core.Graph;
import core.graph_components.Vertex;
import core.algorithms.BreadthFirstSearch;
import core.graph_components.edges.EdgeBasic;
import core.graphs.GraphBasic;
import core.graph_components.vertices.VertexBasic;

public class Main {
    public static void main(String[] args) {
        Vertex v1 = new VertexBasic();
        Vertex v2 = new VertexBasic();
        Vertex v3 = new VertexBasic();
        Vertex v4 = new VertexBasic();


        Edge e1 = new EdgeBasic(v1, v2);
        Edge e2 = new EdgeBasic(v2, v3);
        Edge e3 = new EdgeBasic(v1, v4);


        Graph graph = new GraphBasic();
        graph.addEdges(e1, e2, e3);
        graph.addVertices(v1, v2, v3, v4);


        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, v1);
        breadthFirstSearch.printShortestPath(v3);

        Graph shortestPathFromV1toV3 = breadthFirstSearch.getShortestPathTo(v3);
        System.out.println(shortestPathFromV1toV3.getVertices());
        System.out.println(shortestPathFromV1toV3.getEdges());

        Graph shortestPathFromV1toV4 = breadthFirstSearch.getShortestPathTo(v4);
        System.out.println(shortestPathFromV1toV4.getVertices());
        System.out.println(shortestPathFromV1toV4.getEdges());
    }
}
