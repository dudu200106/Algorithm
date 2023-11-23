public class Q2 {

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    class Link{
        Node head;
        int size;
        Link(){
            head = null;
            size = 0;
        }
    }

    public void add(Link link, int data){
        Node head = link.head;
        Node node = new Node(data);
        if (head==null){
            node.next = null;
        }else {
            node.next = head;
            link.head = node;
        }
        link.size+=1;
    }

    public int delete(Link link, int target){
        if (link.size ==0){
            return -1;
        }
        Node node = link.head;
        Node parent = null;
        while(node!=null){
            int data = node.data;
            if (data ==  target){
                parent.next = node.next;
                link.size -= 1;
                return 1;
            }
            parent = node;
            node = node.next;
        }
        parent = null;
        node = null;
        return -1;
    }


}
