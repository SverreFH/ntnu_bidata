public class LinearProbe extends Hashtable{

    long collisions = 0;

    public LinearProbe(int capacity){
        Hashtable.capacity = capacity;
    }

    public void probeAdd(long numb){
        int m = hashList.length;
        int h = hash(numb);
        for (int i = 0; i < m; i++){
            int j = probe(h, i, m);
            if(hashList[j] == null){

                hashList[j] = numb;
                return;
            }
            collisions++;
        }
    }

    public int probe(int h, int i, int m){
        return (h + i) % m;
    }

}
