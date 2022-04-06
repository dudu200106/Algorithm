package 省题备考;

//填空题--可以直接打表, 数学推算
//当n=2021041820210418时, 有多少种种摆放货物的方式
//  说明: 这种题一般是分解为三个因子, 这里的问题变体就是:排序,不考虑重复
//  而分解为因子的
/*
  分解质因数后,每个质因数都有0,1,n种选法,如:
  4=2*2 -->2^2
  0 0 1*1*4
  0 1 1*2*2
  1 0 2*1*2 //这里可以看出, 若一个质因子只出现一次不去重的话有3种选法
  1 1 2*2*1
  0 2 1*4*1
  2 0 4*1*1

* */

import java.util.*;

//  注: 最后只是打表出每个质因数的个数, 这里是填空题, 要进一步数学推算
public class 货物摆放_2019 {
    public static void main(String[] args) {
        long n=2021041820210418L;

        int start= (int) System.nanoTime();
        System.out.println(solve1(n));
        int end= (int) System.nanoTime();
        System.out.println(end-start);

         start= (int) System.nanoTime();
        System.out.println(solve2(n));
         end= (int) System.nanoTime();
        System.out.println(end-start);
    }

    /**
     * 找出所有的质因数个数,再计算枚举组合数
     * @param n
     */
    static int solve1(long n){
        long temp=2; //从2开始的质数
        HashMap<Long,Integer> map =new HashMap<>();
        while (temp <= n/temp){
            int exponent=0;
            while (n%temp==0){
                n/=temp;
                exponent++;
            }
            if (exponent>0) {
                System.out.println(temp + " : " + exponent);
                map.put(temp,exponent);
            }
            temp++;
        }
        if (n!=1) {
            System.out.println(n + " : " + 1);
            map.put(n, 1);
        }

        int res=1;

        int[] dp=new int[map.size()];
        for (Map.Entry<Long,Integer> entry:
             map.entrySet()) {
            int num= entry.getValue();
            if (dp[num]==0){
                int cnt=0;
                for (int i = 0; i <= num; i++) {
                    for (int j = 0; j <= num; j++) {
                        if (i+j>num) continue;
                        cnt++;
                    }
                }
                dp[num]=cnt;
            }
            res*=dp[num];
        }
        return res;
    }

    static int solve2(long n){
        HashSet<Long> set =new HashSet<>();
        //找出所有因数
        for (long i = 1; i < n/i; i++) {
            if (n%i==0){
                set.add(i);
                set.add(n/i);
            }
        }
        //枚举出所有的组合
        int res=0;
        for (long a : set) {
            for (long b : set) {
                if (a*b >n) continue;
                if (n%(a*b)==0&&set.contains(n/(a*b))) //
                    res++;
            }
        }
        return res;
    }
}
