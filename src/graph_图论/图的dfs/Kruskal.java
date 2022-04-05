package graph_图论.图的dfs;

import java.util.ArrayList;
import java.util.Arrays;

/* 最小生成树*/
public class Kruskal {

    public static Edge[] edges; //边集合
    public static ArrayList<Edge> list =new ArrayList<>(); //存放最小生成树的边
    public static int[] prev =new int[256];  //每个顶点的最小权重前驱
    public static int[] p =new int[256]; //并查集

    static {
        edges=new Edge[10];
        edges[0]=new Edge('C', 'D', 1);
        edges[1]=new Edge('C', 'A', 1);
        edges[2]=new Edge('C', 'E', 8);
        edges[3]=new Edge('A', 'B', 3);
        edges[4]=new Edge('D', 'E', 3);
        edges[5]=new Edge('B', 'C', 5);
        edges[6]=new Edge('B', 'E', 6);
        edges[7]=new Edge('B', 'D', 7);
        edges[8]=new Edge('A', 'D', 2);
        edges[9]=new Edge('A', 'E', 9);

        for (int i = 0; i < p.length; i++) { //初始化并查集
            p[i]=i;
        }
    }
    public static void main(String[] args) {
        int res= solve(5);
        System.out.println(res);
        System.out.println(list);

    }

    /**
     *
     * @param n //总顶点数量
     */
    static int solve(int n){
        //sort
        Arrays.sort(edges);

        int res=0; //最小生成树权重值

        //开始遍历边集， 找出最小生成树的边集合list和最小权重，前驱
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            int a=find(edge.start);
            int b=find(edge.end);
            if (a!=b){ //两个顶点不在同一并查集（不在同一棵子树，不会形成回路）
                p[b]=a; //将他们两个放入同一并查集
                res+=edge.value;
                prev[b]=a; //每个顶点的前驱
                list.add(edge); //加入最小生成树
                if (list.size()==n-1)
                    break;
            }
        }
        if (list.size()==n-1) //最后检查若是不同并查集的边少于n-1， 则该图不连通
            return res;
        else return -1;
    }

    static int find(int x){
        if (p[x]!=x) p[x]=find(p[x]);
        return p[x];
    }

    static class Edge implements Comparable<Edge>{
        char start;
        char end;
        int value;

        public Edge(char start, char end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value-o.value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", value=" + value +
                    '}';
        }
    }
}


