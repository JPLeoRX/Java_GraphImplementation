package core.graph_components;

public interface VertexLabeled<L> extends Vertex {
    public abstract L getLabel();
}