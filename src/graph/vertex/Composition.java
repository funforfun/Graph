package graph.vertex;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class Composition extends Vertex {

    private List<Vertex> components = new ArrayList<Vertex>();

    public Composition(Graph graph) {
        super(graph);
    }

    public void addVertex(Vertex vertex) {
        components.add(vertex);
    }

    public List<Vertex> getComponents() {
        return components;
    }

    @Override
    public boolean hasConcept() {
        for (Vertex vertexComponent : components) {
            if (vertexComponent.hasConcept()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean compareTo(Vertex vertex) {
        for (Vertex vertexComponent : components) {
            if (vertexComponent.getConcept() == vertex.getConcept()) {
                return true;
            }
        }
        return false;
    }

}
