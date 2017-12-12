package core;

import core.graph_components.Edge;
import core.graph_components.Vertex;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public interface Graph extends Serializable, Cloneable, HasId {
    //------------------------------------------------------------------------------------------------------------------
    public abstract Collection<Edge> getEdges();

    public abstract Collection<Vertex> getVertices();
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    public abstract void addEdge(Edge edge);

    public abstract void addVertex(Vertex vertex);

    default public void addEdges(Collection<Edge> edges) {
        edges.forEach(edge -> this.addEdge(edge));
    }

    default public void addVertices(Collection<Vertex> vertices) {
        vertices.forEach(vertex -> this.addVertex(vertex));
    }

    default public void addEdges(Edge ... edges) {
        Arrays.stream(edges).forEach(edge -> this.addEdge(edge));
    }

    default public void addVertices(Vertex ... vertices) {
        Arrays.stream(vertices).forEach(vertex -> this.addVertex(vertex));
    }
    //------------------------------------------------------------------------------------------------------------------
}