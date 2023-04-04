package graph_图论.图的bfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 蓝桥王国一共有N个建筑和M条单向道路，条道路都连接着两个建筑，每个建筑都有自己编号，分别为1~N。(其中皇宫的编号为1)
 * 国王想让小明回答从皇宫到每个建筑的最短路径是多少,但紧张的小明此时已经无法思考，请你编写程序帮助小明回答国王的考核。
 * 输入描述:
 * 输入第一行包含两个正整数N,M。
 * 第2到M+1行每行包含三个正整数u,v,w,表示u→U之间存在一 条距离为W的路。
 * 1≤N≤3x10^5，1≤m≤10^6，1<ui,vi≤N，0≤wi≤10^9
 * 输出描述:
 * 输出仅一行,共N个数,分别表示从皇宫到编号为1 ~ N建筑的最短距离,两两之间用空格隔开。(如果无法到达则输出-1)
 */

/*
解题思路:
    运用优先队列的特性, 构建小顶堆用来优化dijkstra
*/
public class Dijkstra_蓝桥王国_PriorityQueue优先队列_优化版 {
    public static final int INF = Integer.MAX_VALUE;
    public static final int num = 300010;

    static int N ;
    static int M ;
    static ArrayList<Edge>[] edges ;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        edges =  new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();
            edges[u].add(new Edge(u, v, d));
        }

        int[] res = dijkstra();
        System.out.printf(Arrays.toString(res));

    }

    static int[] dijkstra() {
        boolean[] vis = new boolean[N+1];
        int[] dis = new int[N+1];
        Arrays.fill(dis, INF);
        PriorityQueue<SNode> pq = new PriorityQueue<>();
        SNode start = new SNode(1, 0,0);
        pq.add(start);
        dis[1] = 0;
        while (pq.size() != 0){
            SNode tNode = pq.poll();
            int tId= tNode.id;
            if (vis[tId] == true) continue;
            vis[tId] = true;
            for (Edge ele : edges[tId]){
                int tDis = ele.dis;
                int tTo = ele.to;
                if (dis[tTo] > dis[tId] + tDis){
                    dis[tTo] = dis[tId] + tDis;
                    pq.add(new SNode(tTo, tDis, tId));
                }
            }
        }
        return dis;
    }


    static class Edge{
        int from;
        int to;
        int dis;

        public Edge(int from, int to, int dis) {
            this.from = from;
            this.to = to;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", dis=" + dis +
                    '}';
        }
    }

    static class SNode implements Comparable<SNode>{  //因为要使用到优先队列, 必须实现comparable接口
        int id;
        int dis;
        int prev;

        SNode(int id, int dis, int prev){
            this.id = id;
            this.dis = dis;
            this.prev = prev;
        }

        // 要实现优先队列, 必须实现Comparable接口, 重写compareTo方法
        public int compareTo(SNode o) {
            return Integer.compare(this.dis, o.dis);
        }
    }
}
