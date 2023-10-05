package greedy_贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有N个人有渡河,却只有一条最大容量为两人的船, 每次来回划船的时间由最慢的那一个人决定
 * 求全部人渡河的最短时间:
 * Sample Input
 * 1 (测试用例个数)
 * 4
 * 1 2 5 10
 * Sample Output
 * 17
 *

  注意:时间由最慢的个人决定
  思路: 这里有两种贪心策略, 需分几批,每批4个人为一轮,将所有人渡过河去,每批的选择哪个贪心策略则要具体分析.
  证明:
        (数学证明)设有四个人由快到慢排列 a,b,c,d
        第一种策略,是由最快的那个人a,来回将所有人都带过去;
                用时T1: 2a+b+c+d ----但这样的话所有人都要划船;
        第二种策略,是每次都用最快的那两个a,b带最慢的那两个c,d.
                找到最快的a,b和最慢的c,d;
                先将最快的a,b送过去,a回来, 再将c,d送过去,b回来
                用时T2: a+3b+d ----这样的话就不用所有人都在划船了(最慢的那两个相差不大,划算),且划回来的永远是最快的那两个
        二者的等式两边减去同类型: T1:T2 = a+c:2b
                那么每批4人,选择哪个策略则需比较哪个策略用时最短
  解法: 1.策略二需要先送最慢的那两个,那就得四人一批为一轮,双指针--right指向最慢的那两个;
        2.比较用时较短的那个策略就是眼前最优选择, time+=(s1<s2)?s1:s2;
        3.greed算法保留上一个最优解(time是多少)
        4.还有就是如果剩余人数渡河少于4人,
            1人result=他自己;
            2人result=min(a,b);
            3人的话所有人都要划resul=a+b+person[right]
 */
public class 渡河_B站 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            //排序,最短时间的两人在最前
            Arrays.sort(speed);
            greedy(n, speed);
        }
    }

    static void greedy(int n, int[] speed){
        int right= speed.length-1; //最慢的
        int time=0;
        while(n>0){
            if (n==1) {  //还剩一个人:去a
                time += speed[0];
                n--;
            }
            else if (n==2) { //还剩下两个人:去b
                time += speed[1];
                n-=2;
            }
            else if (n==3) { //还剩三个人:去b+ 回a+ 去c
                time += speed[0] + speed[1] + speed[right];
                n-=3;
            }
            else {
                //四个人为一轮, 一轮五趟可以将四人全都送过去
                //比较两种贪心策略谁更小用谁
                int s1=speed[0]*2+speed[1]+speed[right-1]+speed[right];
                int s2=speed[0]+speed[1]*3+speed[right];
                time+= s1<=s2?s1:s2;
                n-=4;
            }
        }
        System.out.println(time);
    }

}
