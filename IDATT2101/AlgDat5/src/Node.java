public class Node {
    String name;
    Node next = null;
    int hash;

    public Node(String name, int hash){
        this.name = name;
        this.hash = hash;
    }

    public int getHash(){
        return hash;
    }
}
