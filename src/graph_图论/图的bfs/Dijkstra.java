package graph_图论.图的bfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dijkstra算法采用的是一种贪心的策略
 * 1. 声明一个数组dis --- 来保存源点到各个顶点的待定最短距离
 *      声明一个集合：T --- 保存已经找到了最短路径的顶点--在T中的顶点i,dist[i]就是最短距离
 *      (声明一个数组,记录每个顶点的前继 --一些题目可能需要)
 * 2. 初始化时，原点 s 的路径权重为 0 （dis[s] = 0）。
 *      若对于顶点 s 存在能直接到达的边（s,m），则把dis[m]设为w（s, m）,
 *      同时把所有其他（s不能直接到达的）顶点的路径长度设为无穷大。
 *      初始时，集合T只有顶点s。
 *
 * { //属于同一个while
 *  3. 贪心--从dis数组选择还未放入T中的最小值，该值就是源点s到该值对应的顶点的最短路径，并且把该点加入到T中，OK，此时完成一个顶点
 *  4. 初始化原点之后,检查新加入的顶点:
 *          a.是否可以到达其他顶点 (graph[min][i]?==0);
 *          b.查看通过该顶点到达其他点的路径长度是否比原点直达更短 (dist[prev]+cost?<dist[i]);
 *          c.如果是，那么就替换这些顶点在dis中的值。
 *          d.重复step.3---又从dist中找出最小值，重复上述动作，直到T中包含了图的所有顶点。
 * }
 * */
public class Dijkstra {

    static int[][] graph={ //此处是邻接矩阵, 若是邻接链表链表则原理同上
            {0, 2, 5, 0, 0, 0, 0},
            {2, 0, 4, 6, 10, 0, 0},
            {5, 4, 0, 2, 0, 0, 0},
            {0, 6, 2, 0, 0, 1, 0},
            {0, 10, 0, 0, 0, 3, 5},
            {0, 0, 0, 1, 3, 0, 9},
            {0, 0, 0, 0, 5, 9, 0}
    };

    public static void main(String[] args) {
        int start=1; //开始顶点
        int[] shortPath= shortPath(start);
        System.out.println(Arrays.toString(shortPath));
    }


    static int[] shortPath(int start) {
        /** step.1 定义三个*/
        int n= graph.length;
        int[] dist=new int[n];
        ArrayList<Integer> T=new ArrayList<>();
        int[] prev =new int[n];

        /** step.2 初始化原点最短距离,和初始待定dist*/
        dist[start]=0; //原点前无前继, 直接最短距离省略step.3, 加进T去
        T.add(start); //将已确定shortPath的原点加入
        for (int i = 0; i < n; i++) {
            if (graph[start][i] > 0 && i != start) //原点可达
                dist[i] = graph[start][i];
            if (graph[start][i] == 0 && i != start) //原点不可达的为无穷大
                dist[i] = Integer.MAX_VALUE;
        }

        /** step.3 贪心--选择当前待定dist[]中的最小值,加入T --它就是当前的最小值,无后效性和具有最优子结构*/
        while(T.size()<n){
            int minIndex=mini(dist,T);
            T.add(minIndex); //加入T, 表示最短距离已经确定
            if (T.size()==n)
                break;

            /** step.4 查看是否更新此点的邻居的最短距离 -- dist[prev]+cost?<dist[i]*/
            for (int i = 0; i < n; i++) {
                int cost = graph[minIndex][i];
                if (cost>0){
                    if (dist[i] > dist[minIndex] + cost){
                        dist[i]= dist[minIndex] + cost;
                        prev[i]=minIndex; //更新前继,这里可能用不到
                    }
                }
            }

        }
        return dist;
    }

    private static int mini(int[] dist, ArrayList<Integer> T) {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for (int i = 0; i < dist.length; i++) {
            if (!T.contains(i) && dist[i]<min){
                min=dist[i]; //更新最小值及下标
                index=i;
            }
        }
        return index;
    }

}
