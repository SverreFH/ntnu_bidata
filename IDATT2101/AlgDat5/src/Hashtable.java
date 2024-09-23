public class Hashtable {
    static int capacity = 10000019;

    Long[] hashList = new Long[capacity];

    public static int hash(long numb){
        return Math.floorMod(numb, capacity);
    }

}
