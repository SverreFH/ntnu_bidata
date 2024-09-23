public class ListQueue {
    private final Object[] tab;
    private int start = 0;
    private int end = 0;
    private int elements = 0;

    public ListQueue(int str){
        tab = new Object[str];
    }

    public boolean empty(){
        return elements == 0;
    }

    public boolean full(){
        return elements == tab.length;
    }

    public void addToQueue(Object e){
        if(full()) return;
        tab[end] = e;
        end = (end + 1) % tab.length;
        ++elements;
    }

    public Object nextInQueue() {
        if (!empty()) {
            Object e = tab[start];
            start = (start + 1) % tab.length;
            --elements;
            return e;
        } else {
            return null;
        }
    }

}
