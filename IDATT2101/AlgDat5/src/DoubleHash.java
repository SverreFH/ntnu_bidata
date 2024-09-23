public class DoubleHash extends Hashtable{
    long collisions = 0;
    public DoubleHash(int capacatiy){
        Hashtable.capacity = capacatiy;

    }

    public int hash2(long numb){
        return Math.floorMod((2 * numb +1), capacity);
    }

    public void insert ( long x ) {
        int pos = hash ( x ) ;
        if (hashList[pos] == null) {
            hashList[pos] = x;
            return ;
        }
        int h2 = hash2 ( x ) ;
        for ( ; ; ) {
            collisions++;
            pos += h2 ;
            if (hashList[Math.abs(pos%capacity)] == null) {
                hashList[Math.abs(pos%capacity)] = x;
                return ;
            }
        }
    }
}
