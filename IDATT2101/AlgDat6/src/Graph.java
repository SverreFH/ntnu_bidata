import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph extends TopoLst{
    int N;
    int K;
    Node []node;

    public void readFromFile(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for(int i = 0; i < N; ++i){
            node[i] = new Node();
            node[i].nodeNumb = i;
        }
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Edge e = new Edge(node[to], node[from].edge);
            node[from].edge = e;
            //node[from].nodeNumb = from;
        }

    }

    public void initPrev(Node s){
        for(int i = N; i-- > 0;){
            node[i].d = new Previous();
        }
        ((Previous)s.d).dist = 0;
    }

    public void bfs(Node s){
        initPrev(s);
        ListQueue listQueue = new ListQueue(N -1);
        listQueue.addToQueue(s);
        while (!listQueue.empty()){
            Node n = (Node) listQueue.nextInQueue();

            for(Edge e = n.edge; e != null; e = e.next){
                Previous p = (Previous) e.to.d;
                if(p.dist == p.infinity){
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

    public Node topologiSort(){
        Node l = null;
        for(int i = N; i-- > 0;){
            node[i].d = new TopoLst();
        }
        for (int i = N; i-- > 0;){
            l = dfTopo(node[i], l);
        }
        return l;
    }

    public void printTopologi(Node result){
        System.out.println("Topological sorting result");
        while (result != null){
            System.out.print(result.nodeNumb + " ");
            result = ((TopoLst) result.d).next;
        }
        System.out.println();
    }
}
