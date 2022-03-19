package 省题备考;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
 */

/*
* 解题思路: --合适的数据结构--Hashmap+ArrayList
*   将每个时刻的订单放入以 外卖店铺id位为key的哈希表中
* */

public class 外卖优先级2_2019 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int T = input.nextInt();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int ti = input.nextInt();
            int id = input.nextInt();
            if (map.get(id) == null) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(ti);
        }

        int res=0; //放置最终结果
        for (Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
            int[] arr_val=new int[T+1];
            ArrayList<Integer> list =e.getValue();
            for (int i = 0; i < list.size(); i++) { //把订单装入每个店铺的时刻订单表
                int index=list.get(i);
                arr_val[index]++;
            }

            boolean flag=false;
            int cnt=0;
            for (int i = 1; i <=T; i++) { //遍历订单, 查看订单最后是否在优先序列里
                if (arr_val[i]==0){
                    if (cnt>0)
                        cnt--;
                    if (cnt<=3)
                        flag=false;
                }
                else {
                    cnt+=arr_val[i] * 2;
                    if (cnt>5)
                        flag=true;
                }
            }
            if (flag)
                res++;
        }

        System.out.println(res);

    }
}


