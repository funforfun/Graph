package graph.vertex;

import concept.Concept;
import graph.Edge;
import graph.Graph;
import word.Word;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int id;
    private Graph graph;
    private Concept concept;
    private Word word;

    // start
    private List<Edge> edgesFrom = new ArrayList<>();
    // end
    private List<Edge> edgesTo = new ArrayList<>();

    public Vertex(Graph graph) {
        this.graph = graph;
        id = graph.addVertex(this);
    }

    public void addEdgeTo(Edge edge) {
        edgesTo.add(edge);
    }

    public void addEdgeFrom(Edge edge) {
        edgesFrom.add(edge);
    }

    public int getId() {
        return id;
    }

    public Graph getGraph() {
        return graph;
    }

    public boolean hasConcept() {
        return concept != null;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Concept getConcept() {
        return concept;
    }

    public boolean hasWord() {
        return word != null;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public List<Edge> getEdgesTo() {
        return edgesTo;
    }

    public List<Edge> getEdgesFrom() {
        return edgesFrom;
    }

    public boolean compareTo(Vertex vertex) {
        return concept == vertex.getConcept();
    }

}
