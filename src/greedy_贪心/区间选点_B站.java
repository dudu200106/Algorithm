package greedy_贪心;

// 数轴上有n个闭区间[ai,bi]。取尽量少的点，使得每个区间内都至少有一个点（不同区间内含的点可以是同一个）。

import java.util.Arrays;
import java.util.Scanner;

/**
 *
        *Intervals
        *You are given n closed,integer intervals[ai,bi]and n integers c1,...,cn.
        *Write a program that:
        *reads the number of intervals,their end points and integers c1,...,cn from the standard input,
        *computes the minimal size of a set Z of integers which has at least ci common elements with interval[ai,bi],for each i=1,2,...,n,
        *writes the answer to the standard output.
        *
        *Input
        *The first line of the input contains an integer n(1<=n<=50000)--the number of intervals.
        *The following n lines describe the intervals.The(i+1)-th line of the input contains three integers ai,
        *bi and ci separated by single spaces and such that 0<=ai<=bi<=50000and 1<=ci<=bi-ai+1.
        *
        *Output
        *The output contains exactly one integer equal to the minimal size of set Z
        *sharing at least ci elements with interval[ai,bi],for each i=1,2,...,n.
        *Sample Input
        *5
        *3 7 3
        *8 10 3
        *6 8 1
        *1 3 1
        *10 11 1
        *Sample Output
        *6
 *
 * //POJ1201
 ** //用树状数组才可以不超时(树状数组求数组前缀)
        **/

/*思路: 1.将所有区间的end结束点从大到小排列(若是end一致则按照start从大到小),
        2.这里又加深了一点难度,规定了一个区间最少要覆盖的点Ci,那么就要新建一条数轴(数组),
        每次每个区间覆盖前,先计算自己的区间内已经有了多少已经标记的点了;
        3.每次都将点选在区间的最末端,这样可以一个点覆盖更多的区间;
        4.然后剩余的点的覆盖都从最右边开始,然后在数轴数组上标注了点是否已被使用了:
        如果被使用了,下一个点;如果没被使用,axis[i]=1,count++,下一个点.
* */

public class 区间选点_B站 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Interval[] intervals= new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(in.nextInt(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(intervals);
        System.out.println(greedy(n,intervals));
    }

    public static int greedy(int n,Interval[] intervals){
        int[] axis=new int[intervals[n-1].end+1];
        int cnt=0;
        for (int i = 0; i <n ; i++) {
            int start=intervals[i].start; //区间双指针
            int end=intervals[i].end;
            int used=sum(axis,start,end); //计算自己区间里已经标记了多少点
            int point=intervals[i].point-used; //剩余多少要覆盖的点
            while(point>0){
                if (axis[end]==0){ //如果自己区间最右边的点有没有被标记
                    axis[end]=1;
                    point--;
                    cnt++;
                    end--;
                }
                else { //标记了的话指针下一个
                    end--;
                }
            }
        }
        return cnt;
    }

    /*寻找数轴(数组)上的点,可能会超时,现在还不会用树状数组,可以以后在加上*/
    private static int sum(int[] axis, int s, int t) {
        int sum = 0;
        for (int i = s; i <= t; i++) {
            sum += axis[i];
        }
        return sum;
    }

    public static class Interval implements Comparable<Interval>{
        int start;
        int end;
        int point;

        public Interval(int start,int end,int point){
            this.start=start;
            this.end=end;
            this.point=point;
        }

        @Override
        public int compareTo(Interval other){
            int x=this.end- other.end;
            if (x==0)
                return this.start-other.start;
            else
                return x;
        }
    }
}
