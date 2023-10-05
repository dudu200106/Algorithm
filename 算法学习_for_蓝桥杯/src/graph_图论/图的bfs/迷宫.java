package graph_图论.图的bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**v
...11111111111111111111111111111
11.111111........1111111111.1111
11.111111..111.11111111.....1111
11.11111111111.1111111111.111111
11.111111.................111111
11.111111.11111111111.11111.1111
11.111111.11111111111.11111..111
11..........111111111.11111.1111
11111.111111111111111.11....1111
11111.111111111111111.11.11.1111
11111.111111111111111.11.11.1111
111...111111111111111.11.11.1111
111.11111111111111111....11.1111
111.11111111111111111111111.1111
111.1111.111111111111111......11
111.1111.......111111111.1111.11
111.1111.11111.111111111.1111.11
111......11111.111111111.1111111
11111111111111.111111111.111...1
11111111111111...............1.1
111111111111111111111111111111..

如上图的迷宫，入口，出口分别：左上角，右下角
"1"是墙壁，"."是通路
求最短需要走多少步？
* */

/**
 * 注: bfs不用递归!!!
 *  纯靠队列, 不停地出队入队, 直至队中再无元素
 */

public class 迷宫 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 21;
        int n = 32;

        //四个方向, 用于上下左右移动
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        char[][] graph = new char[m][n];  // 存放输入--地图数据
        for (int i = 0; i < m; i++) {
            graph[i] = scanner.next().toCharArray();
        }
        int[][] vis = new int[m][n];//标记哪些点已访问
        Queue<Node> queue =new LinkedList<>();

        //先将起点放进去
        Node start =new Node(0,0,0); //起点坐标与深度/距离, 也可放在vis数组中, 最后输出终点的vis[tx][ty]
        queue.add(start);
        while(!queue.isEmpty()){ //队列队首出队, 放入并处理其所有邻居
            Node poll =queue.poll();
            int x= poll.x;
            int y= poll.y;
            int depth= poll.depth;
            vis[x][y]=1;

            //判断是否到达终点
            if (x==m-1 && y==n-1){
                System.out.println(depth);
                break;
            }

            //加入该节点的邻居
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i]; //这里可以控制方向先后
                int y1 = y + dy[i];
                if (x1 >=0 && x1 < m && y1>=0 && y1<n )  // 未出队
                    if (vis[x1][y1]==0 && graph[x1][y1]=='.'){  //没访问过, 且能走
                        queue.add(new Node(x1,y1,depth+1));  //邻居入队
                        /* 这里可以根据题目加入相关的额外处理 */
                    }
            }
        }

    }

    static class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
