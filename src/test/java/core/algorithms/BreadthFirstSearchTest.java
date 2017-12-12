package core.algorithms;

import core.graph_components.Edge;
import core.Graph;
import core.graph_components.Vertex;
import core.graph_components.edges.EdgeBasic;
import core.graphs.GraphBasic;
import core.graphs.GraphUndirected;
import core.helpers.CollectionsEquals;
import core.graph_components.vertices.VertexBasic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchTest {
    public static Graph g1;
    public static Vertex s1;
    public static List<Vertex> t1;
    public static Vertex d1;
    public static Graph p1;

    public static Graph g2;
    public static Vertex s2;
    public static List<Vertex> t2;
    public static Vertex d2;
    public static Graph p2;

    @Before
    public void setupGraph1() {
        Vertex v0 = new VertexBasic();
        Vertex v1 = new VertexBasic();
        Vertex v2 = new VertexBasic();
        Vertex v3 = new VertexBasic();

        Edge e1 = new EdgeBasic(v2, v0);
        Edge e2 = new EdgeBasic(v0, v2);
        Edge e3 = new EdgeBasic(v2, v3);
        Edge e4 = new EdgeBasic(v3, v3);
        Edge e5 = new EdgeBasic(v1, v2);
        Edge e6 = new EdgeBasic(v0, v1);

        g1 = new GraphBasic();
        g1.addEdges(e1, e2, e3, e4, e5, e6);
        g1.addVertices(v0, v1, v2, v3, v3);
        s1 = v2;

        t1 = new LinkedList<>();
        t1.add(v2); t1.add(v0); t1.add(v3); t1.add(v1);

        d1 = v1;
        p1 = new GraphBasic();
        p1.addEdges(e1, e6);
        p1.addVertices(v2, v0, v1);
    }

    @Before
    public void setupGraph2() {
        Vertex v1 = new VertexBasic();
        Vertex v2 = new VertexBasic();
        Vertex v3 = new VertexBasic();
        Vertex v4 = new VertexBasic();
        Vertex v5 = new VertexBasic();
        Vertex v6 = new VertexBasic();

        Edge e1 = new EdgeBasic(v1, v2);
        Edge e2 = new EdgeBasic(v1, v3);
        Edge e3 = new EdgeBasic(v2, v4);
        Edge e4 = new EdgeBasic(v2, v5);
        Edge e5 = new EdgeBasic(v3, v5);
        Edge e6 = new EdgeBasic(v4, v5);
        Edge e7 = new EdgeBasic(v4, v6);
        Edge e8 = new EdgeBasic(v5, v6);

        g2 = new GraphUndirected();
        g2.addEdges(e1, e2, e3, e4, e5, e6, e7, e8);
        g2.addVertices(v1, v2, v3, v4, v5, v6);
        s2 = v1;
        t2 = new LinkedList<>();
        t2.add(v1); t2.add(v2); t2.add(v3); t2.add(v4); t2.add(v5); t2.add(v6);

        d2 = v4;
        p2 = new GraphBasic();
        p2.addEdges(e1, e3);
        p2.addVertices(v1, v2, v4);
    }

    @Test
    public void testTraversal1() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(g1, s1);
        Assert.assertEquals(true, CollectionsEquals.equals(t1, bfs.getTraversal()));
    }

    @Test
    public void testTraversal2() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(g2, s2);
        Assert.assertEquals(true, CollectionsEquals.equals(t2, bfs.getTraversal()));
    }

    @Test
    public void testShortestPath1() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(g1, s1);
        boolean isSame = p1.equals(bfs.getShortestPathTo(d1));
        Assert.assertEquals(true, isSame);
    }

    @Test
    public void testShortestPath2() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(g2, s2);
        boolean isSame = p2.equals(bfs.getShortestPathTo(d2));
        Assert.assertEquals(true, isSame);
    }
}