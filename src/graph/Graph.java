package graph;

import graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices = new ArrayList<Vertex>();
    private List<Edge> edges = new ArrayList<Edge>();

    public int addVertex(Vertex vertex) {
        vertices.add(vertex);
        return vertices.indexOf(vertex);
    }

    public int addEdge(Edge edge) {
        edges.add(edge);
        return edges.indexOf(edge);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
