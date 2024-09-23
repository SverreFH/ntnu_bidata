public class Edge {
    Edge next;
    Node to;

    public Edge(Node n, Edge e){
        to = n;
        next = e;
    }
}
