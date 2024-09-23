public class Edge {
    Edge next;
    Node to;
    Edge inverseEdge;
    int vekt;

    public Edge(Node n, Edge e, int vekt){
        to = n;
        next = e;
        this.vekt = vekt;
    }
}