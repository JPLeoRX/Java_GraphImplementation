package core.graphs;

import core.graph_components.Edge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GraphUndirected extends GraphBasic {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void addEdge(Edge edge) {

        getEdges().stream().filter(e -> e.equals(edge)).findFirst().ifPresent(a -> {
            LOGGER.error(this + ": trying to add existing edge " + '"' + edge + '"');
            throw new IllegalArgumentException();
        });

        super.addEdge(edge);
        super.addEdge(edge.reverse());
    }
}