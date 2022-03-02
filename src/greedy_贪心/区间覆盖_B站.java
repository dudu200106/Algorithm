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
/*
  思路: 这次的重叠区间就变成了"重叠线段起点S"的了,要反过来,开始start点最早(小)的区间排在前面,如果start相同则end小的排在前面;
        选出来的覆盖线段[S,T]起点S的重叠区间,end_now也要是最远的;
        若下一个区间不再重叠线段起点S,则更新线段起点S,转入下一段线段[S',T],重复以上操作直至区间没了或者end_new>=T
  解法:  1.创建Job类,实现Comparable接口,包含start和end两个类变量;
        2.所有区间放入一个Job[]数组中,对其进行排序(start小的在前,相同end小的在前);
        3.(贪心)保存要覆盖线段的S起点,与眼前重叠区间的now_end;
        4.初始化S=1,end_now=1,count=1,
        5,接下来的第一种情况是区间能够覆盖起点S,那么若是当前区间end更大则更新now_end;
          第二种情况是当前区间不重叠当前起点S了,就更新起点S=end_now,count++,若是更新后,当前区间的start仍然不能覆盖S,那就永远不能覆盖完线段了,退出返回-1;
          最后就是T>=end_now结束;
        6.所有区间若是完了,或者覆盖完了线段(end_now>=S),结束判断结果(若是end_now>=T对,<T错)
* */
public class 区间覆盖_B站 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int T=in.nextInt();
        Job[] jobs=new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i]=new Job(in.nextInt(),in.nextInt());
        }
        Arrays.sort(jobs);

        int S=1;
        int end_now=1;
        int cnt=1;
        for (int i = 0; i < N; i++) {
            int s=jobs[i].start;
            int t=jobs[i].end;
            if(i==0&&s>1) break; //若是第一个区间jobs[0]就不覆盖起点S=1,直接错误退出
            if(s<=S){ //第一种情况,在覆盖起点的重叠区间,判断end_now要不要更新
                end_now=Math.max(t,end_now);
            }
            else { //第二种情况,超过S了,这时更新起点S再情况一中的判断
                S=end_now+1;
                cnt++;//更新要覆盖的线段,计数加一
                if (s<=S){
                    end_now=Math.max(t,end_now);
                }
                else{
                    break; //下一个区间的起点不能覆盖线段起点S,结束循环,最后判断结果
                }
            }
            if (end_now>=T) //问题解决,退出
                break;
        }

        if(end_now>=T) System.out.println(cnt);
        else System.out.println(-1);

    }


    public static class Job implements Comparable<Job>{
        int start;
        int end;

        public Job(int start,int end){
            this.start=start;
            this.end=end;
        }

        public int compareTo(Job other){
            int x=this.start- other.start;
            if (x==0)
                return this.end-other.end;
            else return x;
        }
    }
}
