package core.algorithms;

import core.Graph;
import core.graph_components.Vertex;
import core.graphs.GraphBasic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class BreadthFirstSearch implements ShortestPathAlgorithm {
    private static final Logger LOGGER = LogManager.getLogger();

    private Graph graph;
    private Vertex source;

    private HashMap<Vertex, VertexColor> vertexColorMap;
    private HashMap<Vertex, Integer> vertexDistanceMap;
    private HashMap<Vertex, Vertex> vertexParentMap;
    private Queue<Vertex> queue;
    private List<Vertex> traversal;

    public BreadthFirstSearch(Graph graph, Vertex source) {
        this.graph = graph;
        this.source = source;

        LOGGER.debug(this.toString() + ": constructed");

        this.compute();
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Create all helper data structures used for BFS
     */
    private void initializeHelperDataStructures() {
        LOGGER.debug(this.toString() + ": initializing helper data structures");

        vertexColorMap = new HashMap<>();
        vertexDistanceMap = new HashMap<>();
        vertexParentMap = new HashMap<>();
        queue = new ArrayDeque<>();
        traversal = new LinkedList<>();
    }

    /**
     * Paint all vertices white, set distance to infinity for each vertex, set parent to be null for each vertex
     */
    private void initializeAllVertices() {
        LOGGER.debug(this.toString() + ": initializing all vertices");

        for (Vertex v : graph.getVertices()) {
            vertexColorMap.put(v, VertexColor.WHITE);
            vertexDistanceMap.put(v, Integer.MAX_VALUE);
            vertexParentMap.put(v, null);
        }
    }

    /**
     * Paint the source vertex gray as it is discovered now, set distance of source to 0, set parent of source to null
     */
    private void initializeSource() {
        LOGGER.debug(this.toString() + ": initializing source vertex");

        vertexColorMap.replace(source, VertexColor.GRAY);
        vertexDistanceMap.replace(source, 0);
        vertexParentMap.replace(source, null);
    }

    /**
     * Perform the breadth first search
     */
    private void compute() {
        this.initializeHelperDataStructures();
        this.initializeAllVertices();
        this.initializeSource();

        // Initialize queue to contain only source vertex
        queue.add(source);
        LOGGER.debug(this.toString() + ": initializing queue with vertex " + source);

        // As long as there are gray vertices (discovered vertices that have not had their adjacency lists fully examined)
        while (!queue.isEmpty()) {
            Vertex u = queue.remove();
            traversal.add(u);
            LOGGER.debug(this.toString() + ": removing from queue vertex " + u);

            // For each vertex adjacent to current vertex
            for (Vertex v : u.getAdjacentVertices()) {
                // If V is white, then it has not yet been discovered and the procedure discovers it
                if (vertexColorMap.get(v) == VertexColor.WHITE) {
                    // Paint the vertex gray, sets its distance to its parent distance + 1, record its parent as U
                    vertexColorMap.replace(v, VertexColor.GRAY);
                    vertexDistanceMap.replace(v, vertexDistanceMap.get(u) + 1);
                    vertexParentMap.replace(v, u);
                    LOGGER.debug(this.toString() + ": marking vertex " + v);

                    // Place it in the tail of the queue
                    queue.add(v);
                    LOGGER.debug(this.toString() + ": adding to queue vertex " + v);
                }
            }

            // Once the procedure has examined all the vertices on U’s adjacency list, it blackens U in line
            vertexColorMap.replace(u, VertexColor.BLACK);
            LOGGER.debug(this.toString() + ": all adjacent vertexes have been examined from vertex " + u);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private Graph shortestPath;
    @Override
    public Graph getShortestPathTo(Vertex v) {
        if (v.equals(source)) {
            shortestPath = new GraphBasic();
            shortestPath.addVertex(source);
        }

        else if (vertexParentMap.get(v) == null) {
            return null;
        }

        else {
            Vertex parent = vertexParentMap.get(v);
            getShortestPathTo(parent);
            shortestPath.addVertex(v);
            shortestPath.addEdge(parent.getEdgeTo(v));

        }

        return shortestPath;
    }

    public List<Vertex> getTraversal() {
        return traversal;
    }

    public void printShortestPath(Vertex v) {
        if (v.equals(source)) {
            System.out.println(source + "\t");
        }

        else if (vertexParentMap.get(v) == null) {
            System.out.println("No path exists from " + source + " to " + v);
        }

        else {
            LOGGER.debug(this.toString() + ": recursion call into printing routine with vertex " + v);
            printShortestPath(vertexParentMap.get(v));
            System.out.println(v + "\t");
        }
    }

    @Override
    public String toString() {
        return "Breadth First Search";
    }
}