package core.graph_components;

public interface EdgeWeighted<W extends Comparable<W>> extends Edge, Comparable<EdgeWeighted<W>> {
    public abstract W getWeight();

    @Override
    default public int compareTo(EdgeWeighted<W> o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}