package core.graph_components;

import core.HasId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Vertex representation
 */
public interface Vertex extends Serializable, Cloneable, HasId {
    /**
     * @return {@link List<Edge>} list of edges that are pointing to this vertex
     */
    public abstract List<Edge> getIncomingEdges();

    /**
     * @return {@link List<Edge>} list of edges that are originating from this vertex
     */
    public abstract List<Edge> getOutgoingEdges();

    /**
     * @return {@link List<Vertex>} list of vertices adjacent to this vertex (neighboring vertices)
     */
    default public List<Vertex> getAdjacentVertices() {
        // Create new list to represent adjacent vertices
        List<Vertex> adjacentVertices = new ArrayList<>();

        // For each edge outgoing from this vertex - add the edge's destination vertex to the list of adjacent vertices
        this.getOutgoingEdges().parallelStream().forEach(outEdge -> adjacentVertices.add(outEdge.getVertexTo()));

        return adjacentVertices;
    }

    /**
     * @param v vertex to which the edge must point
     * @return {@link Edge} edge between this vertex and vertex V, or null if such edge doesn't exist
     */
    default public Edge getEdgeTo(Vertex v) {
        // Get outgoing edges and see if for any edge its direction vertex will be the same as V
        Optional<Edge> edgesToV = this.getOutgoingEdges().parallelStream().filter(edge -> edge.getVertexTo().equals(v)).findFirst();

        if (edgesToV.isPresent())
            return edgesToV.get();
        else
            return null;
    }


    default public boolean isConnectedTo(Vertex v) {
        // Get outgoing edges and see if there is an edge that connects THIS vertex to V
        return this.getOutgoingEdges().parallelStream().filter(edge -> edge.getVertexTo().equals(v)).count() > 0;
    }
}