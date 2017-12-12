package core.graphs;

import core.graph_components.Edge;
import core.Graph;
import core.graph_components.Vertex;
import core.helpers.CollectionsEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class GraphBasic implements Graph {
    private static final Logger LOGGER = LogManager.getLogger();
    private static long count = 0;

    private ArrayList<Edge> edges;
    private ArrayList<Vertex> vertices;
    private long id;

    public GraphBasic() {
        this.id = count;
        count++;

        this.edges = new ArrayList<Edge>();
        this.vertices = new ArrayList<Vertex>();

        LOGGER.debug(this.toString() + ": constructed");
    }

    public GraphBasic(Collection<Edge> edges, Collection<Vertex> vertices) {
        this();
        this.addEdges(edges);
        this.addVertices(vertices);
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Collection<Edge> getEdges() {
        LOGGER.debug(this.toString() + ": getting edges");
        return edges;
    }

    @Override
    public Collection<Vertex> getVertices() {
        LOGGER.debug(this.toString() + ": getting vertices");
        return vertices;
    }

    @Override
    public long getId() {
        LOGGER.debug(this.toString() + ": getting id");
        return id;
    }

    @Override
    public void addEdge(Edge edge) {
        LOGGER.debug(this.toString() + ": adding edge " + '"' + edge + '"');
        this.edges.add(edge);
    }

    @Override
    public void addVertex(Vertex vertex) {
        LOGGER.debug(this.toString() + ": adding vertex " + '"' + vertex + '"');
        this.vertices.add(vertex);
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Graph " + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof GraphBasic))
            return false;

        GraphBasic that = (GraphBasic) o;

        if (this.id == that.id)
            return true;
        else
            return CollectionsEquals.equals(this.edges, that.edges) && CollectionsEquals.equals(this.vertices, that.vertices);
    }

    @Override
    public int hashCode() {

        return Objects.hash(edges, vertices, id);
    }
}