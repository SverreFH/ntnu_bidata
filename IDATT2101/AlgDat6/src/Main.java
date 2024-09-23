import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Graph graph = new Graph();

        // Load the file using InputStreamReader from the same package as this class
        InputStream inputStream = Main.class.getResourceAsStream("/ø6g5");
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: /ø6g5");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        graph.readFromFile(reader);
        System.out.println("Starting node: " + graph.node[1].nodeNumb);
        graph.bfs(graph.node[1]);
        graph.printBFS();
        Node result = graph.topologiSort();
        graph.printTopologi(result);
    }
}
