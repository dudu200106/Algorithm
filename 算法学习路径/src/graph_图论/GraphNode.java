package graph_图论;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int val;
    private List<GraphNode> neibor=new ArrayList<>();
    public boolean checked=false;

    GraphNode(int val){
        this.val=val;
    }

    public void add(GraphNode node){
        if (this.neibor==null)
            neibor=new ArrayList<>(); //this默认添加在成员变量前了
        neibor.add(node);

    }
    public List<GraphNode> getNeibor() {return neibor;}

    public int getVal() {return val;}

    public int size(){ return neibor.size();}
}
