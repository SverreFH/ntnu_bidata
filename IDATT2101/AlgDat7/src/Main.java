import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        // Load the file using InputStreamReader from the classpath
        InputStream inputStream = Main.class.getResourceAsStream("/flytgraf2");
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: /flytgraf1");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        graph.graphReader(reader);
        System.out.println(graph.node[0].nodeNumb); // Uncomment if needed
        graph.bfs(graph.node[0], graph.node[7]);
        graph.printBFS(); // Uncomment if needed
    }
}
