package core.graph_components;

import core.HasId;
import core.graph_components.edges.EdgeFactory;
import core.graph_components.edges.EdgeType;

import java.io.Serializable;

/**
 * Edge representation
 */
public interface Edge extends Serializable, Cloneable, HasId {
    /**
     * @return {@link Vertex} vertex from which this edge originates
     */
    public abstract Vertex getVertexFrom();

    /**
     * @return {@link Vertex} vertex to which this edge is pointing
     */
    public abstract Vertex getVertexTo();

    /**
     * @return {@link Edge} reversed edge
     */
    default public Edge reverse() {
        return new EdgeFactory().getEdge(this.getVertexTo(), this.getVertexFrom(), EdgeType.EDGE_BASIC);
    }

    /**
     * A self-loop is an edge that connects a vertex to itself.
     * @return
     */
    default public boolean isSelfLoop() {
        return getVertexTo().equals(getVertexFrom());
    }

    /**
     * Two edges are parallel if they connect the same pair of vertices.
     * @param e1
     * @param e2
     * @return
     */
    public static boolean areParallel(Edge e1, Edge e2) {
        return e1.getVertexFrom().equals(e2.getVertexFrom()) && e1.getVertexTo().equals(e2.getVertexTo());
    }
}