package graph_图论.图的dfs;

import java.util.ArrayList;

/* 最小生成树*/
public class Kruskal {

    public static Edge[] edges; //边集合
    public static ArrayList<Edge> list; //存放最小生成树的边
    public static int[] prev;  //每个顶点的最小权重前驱
    public static int[] p; //并查集



    class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value-o.value;
        }
    }
}


