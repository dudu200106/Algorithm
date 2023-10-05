package dfs_深度优先搜索;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**给定整数序列a1,a2,...,an,判断是否可以从中选出若干数,使它们的和恰好为k.
  1≤n≤20
 -10^8≤ai≤10^8
 -10^8≤k≤10^8

 样例:
 输入:
 n=4
 a={1,2,4,7}
 k=13

 输出: Yes (13 = 2 + 4 + 7)
 *
 * 思路: 1."面值"的"硬币"去凑钱, 那么就联系到Coins问题的dfs(剩下要凑的钱,面值数组,面值下标指针),
 *      又因为"面值"不能重复, 那么就构造一个深度为n的二叉树(每层就只有不使用,使用一次的平行状态),
 *      找到一条可行解路径就退出(和的结果为K)
 *      2. 暴力解法会想到找出所有加数的组合, 判断他们的和是否为结果k;
 *      ----而由此可想到"集合","子集"的概念, 那么"二进制"方法就是最优解
 */
public class 部分和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();//13

        /*int start = (int)System.nanoTime();
        dfs(a, 0, k, new ArrayList<Integer>());
        int end =(int)System.nanoTime();
        System.out.println("Time of dfs:" + (end - start) + "ns");*/


        dfs01(a,k);
    }

    /*递归,硬币*/
    static void dfs(int[] arr, int cur, int k, ArrayList<Integer> list){
        if(k==0){ //结束条件 (注: 此处找到答案的结束条件必须在栈退出条件前)
            System.out.print("Yes (k = ");
            for (int i=0; i<list.size(); i++){
                System.out.print(list.get(i) + (i==list.size()-1?"":" + "));
            }
            System.out.println(")");
            System.exit(0);
        }
        //退出条件
        if(k<0||cur>=arr.length) return;

        //左结点--要
        list.add(arr[cur]);
        dfs(arr,cur+1,k-arr[cur],list);
        list.remove(list.size()-1);// 回溯
        //右结点--不要
        dfs(arr,cur+1,k,list);
    }

    /*迭代, 集合, 二进制*/
    static void dfs01(int[] arr,int k){
        int num=(int)Math.pow(2,arr.length); //个数
        for (int i = 1; i <=num; i++) {
            List<Integer> list= new ArrayList<>(); //每次新建一个列表
            int count=0;
            for (int j = 0; j <arr.length; j++) {
                if (((i>>j)&1)==1){
                    list.add(arr[j]);
                    count+=arr[j];
                }
            }

            if(k==count){ //结束条件
                System.out.print("Yes (k = ");
                for (int l=0; l<list.size(); l++){
                    System.out.print(list.get(l) + (l==list.size()-1?"":" + "));
                }
                System.out.println(")");
                System.exit(0);
            }
        }
    }
}
