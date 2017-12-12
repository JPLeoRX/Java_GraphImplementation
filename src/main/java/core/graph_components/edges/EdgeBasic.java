package core.graph_components.edges;

import core.graph_components.Edge;
import core.graph_components.Vertex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class EdgeBasic implements Edge {
    private static final Logger LOGGER = LogManager.getLogger();
    private static long count = 1;

    private Vertex vertexFrom;
    private Vertex vertexTo;
    private long id;

    // Constructor
    //------------------------------------------------------------------------------------------------------------------
    public EdgeBasic(Vertex vertexFrom, Vertex vertexTo) {
        this.id = count;
        count++;

        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;

        vertexFrom.getOutgoingEdges().add(this);
        vertexTo.getIncomingEdges().add(this);

        LOGGER.debug(this.toString() + ": constructed");
    }
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    // Edge functionality
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Vertex getVertexFrom() {
        LOGGER.debug(this.toString() + ": getting vertex from");
        return vertexFrom;
    }

    @Override
    public Vertex getVertexTo() {
        LOGGER.debug(this.toString() + ": getting vertex to");
        return vertexTo;
    }

    @Override
    public long getId() {
        LOGGER.debug(this.toString() + ": getting id");
        return id;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    // Other methods
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Edge " + this.id + " from " + vertexFrom + " to " + vertexTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof EdgeBasic))
            return false;

        EdgeBasic edgeBasic = (EdgeBasic) o;

        return Objects.equals(vertexFrom, edgeBasic.vertexFrom) && Objects.equals(vertexTo, edgeBasic.vertexTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}