package greedy_贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**输入很多个区间,若有一段距离(线段),请问最少多少区间可覆盖完这段距离(覆盖完这条线段)
 *
 * 例如安排奶牛在1点到T点之间,不间断地清理谷仓,给出了N头奶牛的可工作时间区间,求最少要多少头牛
 *
 *Input:
 *  Line 1: Two space-separated integers: N and T
 *
 *  Lines 2..N+1: Each line contains the start and end times of the interval during which a cow can work.
 *
 *  A cow starts work at the start time and finishes after the end time.
 *Output:
 *  Line 1: The minimum number of cows Farmer John needs to hire or -1 if it is not possible to assign a cow to each shift.
 *  Sample Input
 *  3 10
 *  1 7
 *  3 6
 *  6 10
 *  Sample Output
 *  2
 * */

// 区间覆盖: 最少, 排序按照start点越早的越前,依据也是上一个区间的end点
/*
  思路: 这次的重叠区间就变成了"重叠线段起点S"的了,要反过来,开始start点最早(小)的区间排在前面,如果start相同则end小的排在前面;
        选出既能够连接上一个区间终点end_old, 又伸得最远的线段[s,t] .
        若下一个区间不再重叠线段起点start_now,则更新线段起点S,转入下一段线段[s',t],重复以上操作直至遍历完线段或者end_now>=T
  解法:  1.创建Job类,实现Comparable接口,包含start和end两个类变量;
        2.所有区间放入一个Job[]数组中,对其进行排序(start小的在前,相同end小的在前);
            判断job[length-1].end是否能覆盖线段最远端
        3.(贪心)保存上一个区间的终点的end_old,上一条重叠线段的终点end_last;
        4.初始化end_old=S(要覆盖的起点),end_last=jobs[0].end,count=1,
        5,若是当前线段的起点s不能覆盖上一条线段的终点end_last,那就永远不能覆盖完线段了,错误退出返回-1;
          若是不断开,那么如果该区间还能连接前一个区间终点end_old,考虑更新end_last;
                       如果是不连接了,就更新起点end_old=end_last,end_last=t(当前终点);count++, 继续往后遍历;
          最后就是T<=end_now就跳出. 输出结果;

* */
public class 区间覆盖_B站 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = 1;
        int T = in.nextInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job(in.nextInt(), in.nextInt());
        }
        /*step.2 对job类排序,判断最远点*/
        Arrays.sort(jobs);
        System.out.println(Arrays.toString(jobs));
        if (jobs[jobs.length - 1].end < T  //首或尾不能覆盖
                || jobs[0].start > S) {
            System.out.println(-1 + "aa");
            System.exit(0);
        }
        /*step.3 初始化start_now点与end_now点,count=1*/
        int end_his = S;
        int end_last = S;
        int cnt = 1;
        /*step.4 遍历排序好的区间, 若有点不重叠上一次end就交换起点和终点*/
        for (int i = 0; i < N; i++) {
            int s = jobs[i].start;
            int t = jobs[i].end;

            //第一种情况, 当前线段和上一条线段的终点end_last不相连, 出现断层，不能覆盖
            if (s > end_last) {
                System.exit(0);
            }
            //第二种情况,当前线段起点和上一条线段相连
            else {
                //若是当前起点大于历史终点, 则加一条线段,交换当前终点与上一条历史终点
                if (s > end_his) {
                    end_his = end_last;
                    end_last = t;
                    cnt++;//更新要覆盖的线段,计数加一
                } else //否则就判断是否更新上一条的终点
                    end_last = Math.max(end_last, t);
            }

            if (end_last >= T) //完成覆盖,退出
                break;
        }
        System.out.println(cnt);
    }

    /*step.1 封装, 创建job类*/
    static class Job implements Comparable<Job> {
        int start;
        int end;

        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Job other) {
            int x = this.start - other.start;
            if (x == 0)
                return this.end - other.end;
            else return x;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

    }
}
