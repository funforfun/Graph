package main;

import graph.Edge;
import graph.Graph;
import graph.vertex.Vertex;
import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.gui.AboutDialog;
import org.languagetool.language.Russian;
import org.languagetool.rules.RuleMatch;
import org.maltparser.Malt;
import org.maltparser.MaltParserService;
import org.maltparser.core.exception.MaltChainedException;
import org.maltparser.core.syntaxgraph.DependencyStructure;
import word.Word;

import javax.swing.*;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;


//class A<T>{
//    private T a;
//    public  A(T a){
//        this.a = a;
//    }
//
//    public T getA(){
//        return a;
//    }
//}

//class A{
//    public List<Long> list = new ArrayList<>();
//
//    public long get(long index){
//        return list.get((int) index);
//    }
//
//    public void set(int index, int value){
//        list.put(index, value);
//    }
//}


public class DemoFrame extends JFrame {

    public DemoFrame() {

        JScrollPane jScrollPane = new javax.swing.JScrollPane();
        JTextArea jTextArea = new javax.swing.JTextArea("This is a a samplee.");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane.setViewportView(jTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();

        MyLanguageToolSupport lt = new LanguageT(this, jTextArea);
        lt.setLanguage(Language.getLanguageForLocale(new Locale("en", "US")));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoFrame().setVisible(true);
            }
        });
    }

}

public class Main {

    public static void main(String[] args) {

        AboutDialog ad = new AboutDialog();


//        maltParserUse();
        languageTool();


// todo:
//        long b = (new A(1)).getA();
//        int b = (new A<Integer>(1)).getA(); //V
//        long b = (new A<Integer>(1)).getA();
//        Object b = (new A(1)).getA();

//        int x = 2>>1; // 1
//        int x = 2|1; // 3
//        int x = 0xc + 0b100; // 16
//        System.out.println(x);
//
//        Graph graph1 = new Graph();
//        Annotation[] annotations = graph1.class.getAnnotations();
//
//
//        Vertex vertex1 = new Vertex(graph1);
//        vertex1.setWord(new Word("папа", "папа"));
//
//        Vertex vertex2 = new Vertex(graph1);
//        vertex2.setWord(new Word("пойти", "пошел"));
//
//        Vertex vertex3 = new Vertex(graph1);
//        vertex3.setWord(new Word("лес"));
//
//        Vertex vertex4 = new Vertex(graph1);
//        vertex4.setWord(new Word("горит"));
//
//        Vertex vertex5 = new Vertex(graph1);
//        vertex5.setWord(new Word("находится"));
//
//        Edge edge1 = new Edge(vertex1, vertex2, graph1);
//        Edge edge2 = new Edge(vertex2, vertex3, graph1);
//        Edge edge3 = new Edge(vertex3, vertex4, graph1);
//        Edge edge4 = new Edge(vertex3, vertex5, graph1);
//
//        Boolean res = bfs(vertex1, vertex4);
//        System.out.println("heh");
//        System.out.println(res);


    }



    private static void languageTool() {
        try {

            JLanguageTool langTool = new JLanguageTool(new Russian());
//            List<RuleMatch> matches = langTool.check("A sentence with a error in the Hitchhiker's Guide tot he Galaxy");


            long timeStart = System.currentTimeMillis();
            List<RuleMatch> matches = langTool.check("Здраствуйте, нашла в списке сваего дедушку, но инфармации мало, и не разглядеть. Знаю что он верулся в 1947 году, и хотелось узнать в каких лагирях он был, когда попал в плен. Спосибо зоранее, Жанна");

            for (RuleMatch match : matches) {
                System.out.println("Potential error at characters " +
                        match.getFromPos() + "-" + match.getToPos() + ": " +
                        match.getMessage());
                System.out.println("Suggested correction(s): " +
                        match.getSuggestedReplacements());
            }

            long timeEnd = System.currentTimeMillis();
            System.out.println("Time: " + (timeEnd - timeStart) / 1000.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void maltParserUse() {
        try {
            MaltParserService service = new MaltParserService();
            // Inititalize the parser model 'model0' and sets the working directory to '.' and sets the logging file to 'parser.log'
//            service.initializeParserModel("-c model0 -m parse -w . -lfi parser.log");
//            service.initializeParserModel("-c src/main/rus-test -m parse -w . -lfi parser.log");
            service.initializeParserModel("-c src/main/russian.mco -m parse");


            // Creates an array of tokens, which contains the Swedish sentence 'Grundavdraget upphör alltså vid en taxerad inkomst på 52500 kr.'
            // in the CoNLL data format.
            String[] tokens = new String[11];
            tokens[0] = "1\tGrundavdraget\t_\tN\tNN\tDD|SS";
            tokens[1] = "2\tupphör\t_\tV\tVV\tPS|SM";
            tokens[2] = "3\talltså\t_\tAB\tAB\tKS";
            tokens[3] = "4\tvid\t_\tPR\tPR\t_";
            tokens[4] = "5\ten\t_\tN\tEN\t_";
            tokens[5] = "6\ttaxerad\t_\tP\tTP\tPA";
            tokens[6] = "7\tinkomst\t_\tN\tNN\t_";
            tokens[7] = "8\tpå\t_\tPR\tPR\t_";
            tokens[8] = "9\t52500\t_\tR\tRO\t_";
            tokens[9] = "10\tkr\t_\tN\tNN\t_";
            tokens[10] = "11\t.\t_\tP\tIP\t_";
            // Parses the Swedish sentence above
            DependencyStructure graph = service.parse(tokens);
            // Outputs the dependency graph created by MaltParser.
            System.out.println(graph);
            // Terminates the parser model
            service.terminateParserModel();
        } catch (MaltChainedException e) {
            e.printStackTrace();
        }


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
