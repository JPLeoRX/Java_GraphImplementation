package core.algorithms;

import core.Graph;
import core.graph_components.Vertex;

public interface ShortestPathAlgorithm {
    public abstract Graph getShortestPathTo(Vertex v);
}
