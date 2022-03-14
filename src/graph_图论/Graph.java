package graph_图论;

public class Graph {
    public static void main(String[] args) {
        GraphNode n1=new GraphNode(1);
        GraphNode n2=new GraphNode(2);
        GraphNode n3=new GraphNode(3);
        GraphNode n4=new GraphNode(4);
        GraphNode n5=new GraphNode(5);

        n1.add(n2);
        n1.add(n3);

        n2.add(n1);

        n3.add(n1);
        n3.add(n4);
        n3.add(n5);

        n4.add(n3);

        n5.add(n3);
    }
}
