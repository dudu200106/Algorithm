package greedy_贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
有n项工作,每项工作分别在si时间开始,在ti时间结束.
对于每项工作,你都可以选择参与与否.如果选择了参与,那么自始至终都必须全程参与.
此外,参与工作的时间段不能重复(即使是开始的瞬间和结束的瞬间的重叠也是不允许的).
你的目标是参与尽可能多的工作,那么最多能参与多少项工作呢?

1≤n≤100000
1≤si≤ti≤10^9

输入:

第一行:n
第二行:n个整数空格隔开,代表n个工作的开始时间
第三行:n个整数空格隔开,代表n个工作的结束时间

样例输入:

5
1 3 1 6 8
3 5 2 9 10

样例输出:

3

说明:选取工作1,3,5
 */

// 区间调度: 最多, end点越早的越前, 依据是上一个区间的最晚end点
/* 思路: 所有重叠区间里(第一个区间end端点与其他区间重叠了),只能完成一个任务----所以,找出最早结束的第一个任务,它的end点
*       重叠的,就属于第一个重叠区间,其他与end点重叠的区间就不要----这就是最优选择的区间
*  证明: 所有最早结束区间之后,可选择的工作就越多;
*  解法: 1.循环找出所有区间最早结束的end点
*       2.贪心算法保留眼前最早结束的end点
*       3.比较下一个最早结束点的start点是否与上一个end点交叉
*       4.没有的话找到第二个最优区间,重复操作2,count++;否则重复操作3*/

public class 区间任务调度_B站 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        int[] starts=new int[n];
        int[] ends=new int[n];
        Job[] job=new Job[n];
        for (int i = 0; i < n; i++) {
            starts[i]=input.nextInt();
        }
        for (int j = 0; j < n; j++) {
            ends[j]=input.nextInt();
        }
        for (int k = 0; k < n; k++) {
            job[k]=new Job(starts[k],ends[k]);
        }
        Arrays.sort(job);
        int res=greedy(n,job);
        System.out.println(res);
    }

    static int greedy(int n,Job[] jobs){
        int count=1;
        int save=jobs[0].end;
        for (int i = 1; i < n; i++) {
            if (jobs[i].start>save){ //开始和结束端也不能重叠
                save=jobs[i].end;
                count++;
            }
        }
        return count;
    }

    private static class Job implements Comparable<Job>{
        int start;
        int end;
        Job(int start,int end){
            this.start=start;
            this.end=end;
        }

        public int compareTo(Job other) {
            int x = this.end - other.end;
            if (x == 0)
                return this.start - other.start;
            else
                return x;
        }
    }
}
