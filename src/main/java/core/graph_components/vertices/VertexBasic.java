package core.graph_components.vertices;

import core.graph_components.Edge;
import core.graph_components.Vertex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VertexBasic implements Vertex {
    private static final Logger LOGGER = LogManager.getLogger();
    private static long count = 0;

    private List<Edge> incomingEdges;
    private List<Edge> outgoingEdges;
    private long id;

    // Constructor
    //------------------------------------------------------------------------------------------------------------------
    public VertexBasic() {
        this.id = count;
        count++;

        this.incomingEdges = new ArrayList<Edge>();
        this.outgoingEdges = new ArrayList<Edge>();

        LOGGER.debug(this.toString() + ": constructed");
    }
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    // Vertex functionality
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public List<Edge> getIncomingEdges() {
        LOGGER.debug(this.toString() + ": getting incoming edges");
        return incomingEdges;
    }

    @Override
    public List<Edge> getOutgoingEdges() {
        LOGGER.debug(this.toString() + ": getting outgoing edges");
        return outgoingEdges;
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
        return "Vertex " + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof VertexBasic))
            return false;

        VertexBasic that = (VertexBasic) o;

        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}