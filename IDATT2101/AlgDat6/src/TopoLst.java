public class TopoLst{
    boolean found;
    Node next;

    public Node dfTopo(Node n, Node l){
        TopoLst nd = (TopoLst) n.d;
        if(nd.found) return l;
        nd.found = true;
        for (Edge e = n.edge; e != null; e = e.next){
            l = dfTopo(e.to, l);
        }
        nd.next = l;
        return n;
    }


}
