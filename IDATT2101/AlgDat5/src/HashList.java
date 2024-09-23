public class HashList {
    int capacatiy = 256;
    int collisions = 0;
    Node[] hashList = new Node[capacatiy];

    public void addElement(String name){
        Node node = new Node(name, hasher(name, capacatiy));
        if(hashList[(node.getHash())] != null){
            System.out.println("Collision at : " + node.getHash() + " | Name 1 : " + name + " | Name 2 : " + hashList[(node.getHash())].name);
            collisions++;
            node.next = hashList[(node.getHash())];
        }
        hashList[node.getHash()] =  node;
    }

    private int hasher(String name, int listSize){
        int hash = 0;
        for (int i = name.length() -1; i  >= 0 ; i--) {
            hash = (7* hash + name.charAt(i)) % listSize;
        }
        return hash;
    }

    public String checkIfStudentExists(String name){
        int hash = hasher(name, capacatiy);
        if(hashList[hash] == null){
            return "Student not in list";
        } else {
            Node node = hashList[hash];
            while (node != null){

                if(node.name.equals(name)){
                    return "Student in list at index : " + hashList[hash].getHash();
                }
                node = node.next;
            }
        }
        return"Student not in list";
    }


}
