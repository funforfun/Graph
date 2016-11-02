package graph;

import graph.vertex.Vertex;

public class Edge {
    private int id;
    private Graph graph;
    private Vertex from;
    private Vertex to;

    public Edge(Vertex from, Vertex to, Graph graph){
        this.from = from;
        this.to = to;
        this.graph = graph;
        from.addEdgeTo(this);
        to.addEdgeFrom(this);
        id = graph.addEdge(this);
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public int getId() {
        return id;
    }

    public Graph getGraph() {
        return graph;
    }
}
