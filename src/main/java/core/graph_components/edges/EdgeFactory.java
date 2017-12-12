package core.graph_components.edges;

import core.graph_components.Edge;
import core.graph_components.Vertex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EdgeFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public Edge getEdge(Vertex from, Vertex to, EdgeType edgeType) {
        LOGGER.debug(this.toString() + ": creating edge");

        if (edgeType == EdgeType.EDGE_BASIC) {
            return new EdgeBasic(from, to);
        }

        else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Edge Factory";
    }
}