package 省题备考;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * “饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有 一个优先级，初始时 (0 时刻) 优先级都为 0。
 * 每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减 到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
 * 如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果 优先级小于等于 3，则会被清除出优先缓存。
 * 给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优 先缓存中。
 *
 * 【输入格式】
 * 第一行包含 3 个整数 N、M 和 T。
 *
 * 以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到 一个订单。
 *
 * 【输出格式】
 * 输出一个整数代表答案。
 *
 * 【样例输入】
 2 6 6
 1 1
 5 2
 3 1
 6 2
 2 1
 6 2
 *
 * 【样例输出】
 * 1
 *
 * 【样例解释】
 * 6 时刻时，1 号店优先级降到 3，被移除出优先缓存；2 号店优先级升到 6， 加入优先缓存。所以是有 1 家店 (2 号) 在优先缓存中。
 *
 * 【评测用例规模与约定】
 * 对于 80% 的评测用例，1≤ N,M,T ≤10000。
 * 对于所有评测用例，1≤ N,M,T ≤100000，1≤ts≤T，1≤id ≤ N。
 *
 * 时间限制：1.0s
 * 内存限制：512.0MB
 *
 *
 */

public class 外卖优先级2 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N =in.nextInt();
        int M =in.nextInt();
        int T = in.nextInt();
        Pair[] arr=new Pair[M+1]; //行下标代表时间, 每列代表一个店铺

        new Pair(1,1);
        /*for (int i = 1; i <M+1 ; i++) {
            int ti= in.nextInt();
            int id= in.nextInt();
            arr[i]=new Pair(ti,id);
        }

        for (int i = 0; i < M+1; i++) {
            System.out.println(arr[i].ti+ "::" +arr[i].id);
        }*/

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return 0;
            }
        });

    }

     class Pair implements Comparator<Pair>{
        int ti;
        int id;

        Pair(int ti,int id) {
            this.ti = ti;
            this.id = id;
        }

        public void print(){
            System.out.println("ti: "+ti+ " id: "+id);
        }

         @Override
         public int compare(Pair o1, Pair o2) {
             return o1.ti-o2.ti;
         }
     }

}


