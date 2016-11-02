package main;

import graph.Edge;
import graph.Graph;
import graph.vertex.Vertex;
import word.Word;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Graph graph1 = new Graph();

        Vertex vertex1 = new Vertex(graph1);
        vertex1.setWord(new Word("папа", "папа"));

        Vertex vertex2 = new Vertex(graph1);
        vertex2.setWord(new Word("пойти", "пошел"));

        Vertex vertex3 = new Vertex(graph1);
        vertex3.setWord(new Word("лес"));

        Vertex vertex4 = new Vertex(graph1);
        vertex4.setWord(new Word("горит"));

        Vertex vertex5 = new Vertex(graph1);
        vertex5.setWord(new Word("находится"));

        Edge edge1 = new Edge(vertex1, vertex2, graph1);
        Edge edge2 = new Edge(vertex2, vertex3, graph1);
        Edge edge3 = new Edge(vertex3, vertex4, graph1);
        Edge edge4 = new Edge(vertex3, vertex5, graph1);

        Boolean res = bfs(vertex1, vertex4);
        System.out.println("heh");
        System.out.println(res);


    }

    public static boolean bfs(Vertex startVertex, Vertex goalVertex) {
        List<Vertex> visited = new ArrayList<>();
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        // начиная с узла-источника
        queue.add(startVertex);
        visited.add(startVertex);
        // пока очередь не пуста
        while (!queue.isEmpty()) {
            // извлечь первый элемент в очереди
            Vertex currentVertex = queue.poll();

            // проверить, не является ли текущий узел целевым
            if (currentVertex == goalVertex) {
                return true;
            }
            List<Edge> edges = currentVertex.getEdgesTo();
            // все преемники текущего узла, ...
            for (Edge edgeTo : edges) {
                Vertex child = edgeTo.getTo();
                // все преемники текущего узла, ...
                if (!visited.contains(child)) {
                    queue.add(child);
                    visited.add(child);
                }
            }
        }
        // Целевой узел недостижим
        return false;
    }
}
