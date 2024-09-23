public class JosephusProblem {
    private Node head = null;
    private Node tail = null;
    private int elements = 0;

    public void insertNode(int value){
        Node node = new Node(value);

        if(head == null){
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
        tail.next = head;
        elements++;
    }

    public void removeNode(int value){
        Node node = head;
        if (head == null){
            return;
        }
        do{
            Node next = node.next;
            if (next.element ==  value){
                if (tail == head){
                    tail = null;
                    head = null;
                    return;
                } else {
                    node.next = next.next;
                    if (head == next){
                        head = head.next;
                        return;
                    }
                    if (tail == next){
                        tail = node;
                        return;
                    }
                }
                break;
            }
            node = next;
        } while (node != head);
    }

    public String findJosephusPos(int deletionInterval) {
        Node node = head;
        int deletionCounter = 1;

        if (head != null) {
            do {
                node = node.next;
                if(deletionCounter != deletionInterval) deletionCounter++;
                if(deletionCounter == deletionInterval){
                    removeNode(node.element);
                    deletionCounter = 0;
                    elements--;
                }
            } while (elements != 1);
        }
        assert node != null;
        return "The safe pos for Josephus is " + node.next.element;
    }

}
