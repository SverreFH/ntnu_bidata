import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph {
    int N;

    int K;

    Node []node;


    public void graphReader(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i = 0; i < N; ++i){
            node[i]  = new Node();
            node[i].nodeNumb = i;
        }
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            int vekt = Integer.parseInt(st.nextToken());
            Edge k = new Edge(node[til], node[fra].edge, vekt);
            Edge k2 = new Edge(node[fra], node[til].edge, vekt);
            node[fra].edge = k;
            node[til].edge = k2;
            node[fra].edge.inverseEdge = node[til].edge;
            node[til].edge.inverseEdge = node[fra].edge;
        }
    }

    public void initPrev(Node s){
        for(int i = N; i-- > 0;){
            node[i].d = new Previous();
        }
        ((Previous)s.d).dist = 0;
    }

    public void bfs(Node start, Node end){
        initPrev(start);
        ListQueue listQueue = new ListQueue(N -1);
        listQueue.addToQueue(start);
        while (!listQueue.empty()){
            Node n = (Node) listQueue.nextInQueue();

            for(Edge e = n.edge; e != null; e = e.next){
                Previous p = (Previous) e.to.d;
                if(p.dist == p.infinity && e.inverseEdge.vekt != 0){
                    p.dist = ((Previous)n.d).dist + 1;
                    p.prev = n;
                    listQueue.addToQueue(e.to);
                }
            }
        }
    }

    public void printBFS(){
        System.out.println("Node Prev Dist");
        for (Node n : node){
            Previous p = (Previous) n.d;
            System.out.println(n.nodeNumb + "    " + (p.prev != null ? p.prev.nodeNumb : " ") + "    " + (p.dist != p.infinity ? p.dist : " "));
        }
    }


}
