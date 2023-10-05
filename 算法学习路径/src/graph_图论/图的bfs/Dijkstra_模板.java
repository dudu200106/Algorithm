package graph_图论.图的bfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dijkstra算法采用的是一种贪心的策略, 用来算出起点到各点的最短距离 (额外加上个前驱prev[]也能逆推处到各点的最短路径)
 * 1.声明.
 *      声明一个距离数组dis --- 来保存源点到各个顶点的待定最短距离
 *      声明一个已确定集合：T --- 保存已经找到了最短路径的顶点--在T中的顶点i,dist[i]就是其最短距离
 *      声明一个前继数组prev[],记录每个顶点的前继 -- 在一些题目中可能是必要的
 *      注: 每个点用数字1~N代表, 一般来说源点为1
 * 2. 初始化.
 *      a.给源点A距离dis[]赋值, dis[A]=0, 放入已确定集T
 *      b.给其他顶点的距离dis[]赋原始值, 大小为和源点A相连的边长, 若和A不相连则该点的dis[i]赋为-1或无穷大
 *
 * 3. 贪心--选择待定dist数组中值最小的顶点i(即i不在T中)，弹出该顶点的编号, 加入T中, 并访问其相邻顶点
 *          a.找出当前dis最短距离的(贪心),将该点加入到T中，该顶点当前的dis[]就是最优解的最短距离
 *          b.访问该顶点可到达其他顶点;
 *          c.是否通过该顶点到达其他点的路径长度, 比原点直达更短 (dist[prev]+cost?<dist[i]);
 *          c.如果是，那么就替换这些顶点在dis中的值。
 *          d.continue, 重复step.3动作，直到T中包含了图的所有顶点。
 *
 * */
public class Dijkstra_模板 {

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

    /**
     * 最短路径的原理就是: 找出当前待定的所有节点中距离最短, 那么他就是当前可确定的最短可达节点C.
     *      将该C加入确定集T, 然后根据C所有的邻居节点做bfs, 是否f(c)+graph(c,i)<f(i)
     *      -- 注: f()函数代表起点到该点距离, graph(a,b)代表边ab的长度
     * @param start
     * @return 最短路径的数组, 下标是节点的标识
     */
    static int[] shortPath(int start) {
        /** step.1 定义三个记录当前结果的属性:dist,T,prev*/
        int n= graph.length;
        int[] dist=new int[n];
        ArrayList<Integer> T=new ArrayList<>();
        int[] prev =new int[n];

        /** step.2 初始化,预处理待定shortPath dist[]
         *                  -- 原点除了要加入自己的邻居外, 还要初始化其他不可达节点的待定最短距离*/
        dist[start]=0;
        T.add(start); //将已确定shortPath的原点加入
        for (int i = 0; i < n; i++) {
            if (graph[start][i] > 0 && i != start) //原点可达
                dist[i] = graph[start][i];
                prev[i] = start; // 前驱现在用不到
            if (graph[start][i] == 0 && i != start) //原点不可达的为无穷大
                dist[i] = Integer.MAX_VALUE;
        }

        /** step.3 bfs + 贪心--弹出当前待定dist[]中的最小值,加入T --它就是当前的最小值,无后效性和具有最优子结构*/
        while(T.size()<n){
            int minIndex=mini(dist,T);  //找出当前待定dist[]中的最小值, 弹出该顶点的下标编号
            T.add(minIndex);  //加入T, 表示最短距离已经确定
            if (T.size()==n)  //已确定集满, 结束
                break;
            // 遍历查看当前顶点的邻居, 看是否要更新邻居点的dis[i]最短距离 -- dist[prev]+cost?<dist[i], bfs的具体体现*/
            for (int i = 0; i < n; i++) {
                int cost = graph[minIndex][i];
                if (cost>0){
                    if (dist[i] > dist[minIndex] + cost){
                        dist[i]= dist[minIndex] + cost;
                        prev[i]=minIndex; //更新前继,这里可能用不到, 但如果要求最短路径则排得上用场
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
