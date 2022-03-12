package math_数学;

import static java.lang.StrictMath.log;

/**
 * 若是要求第十万个质数, 那么计数求法的时间复杂度为O(n*根号n), 肯定超时;
 * 这里可以用一种预处理的方法--埃氏筛法, 但要到两个前人已经提出证明的知识:
 *   1.埃氏筛法--构造一个足够长度的数组,数值转下标,把所有非素数标记出来
 *   2.素数定理--在n个数中抽中素数的概率为1/lgn, 可以确定需要构造多大长度的数组
 */
public class 第N个素数 {
    public static void main(String[] args) {
        long start= System.nanoTime();
        solve(100000);
        long end= System.nanoTime();
        System.out.println("Solve: "+ (end-start));

        start= System.nanoTime();
        solve2(100000);
        end= System.nanoTime();
        System.out.println("Solve: "+ (end-start));
    }

    /**
     * 打表出第N个质数
     * @param N
     */
    static void solve(int N) {
        /*1.构造足够长度的数组*/
        int length = 2;
        while (length / log(length) < N) {
            length++;
        }
        System.out.println("记录第1000000个素数数组范围要到: " + length);
        int[] arr = new int[length+1]; //因为要数组转下标

        /*2.筛除所有非素数*/
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0)//若是标记过, 说明这是之前某个素数的倍数
                continue;

            int k = 2; //k代表素数的倍数
            while (i * k < length) {
                arr[i * k] = -1;
                k++;
            }
        }
        /*3.开始计数素数*/
        int cnt = 0;
        for (int i = 2; i < arr.length; i++) { //从数字2开始--数值转下标
            if (arr[i] == 0)
                cnt++;
            if (cnt == N) {
                System.out.println("第" + N + "个素数是: " + i);
                return;
            }
        }
    }

    /**
     * 线性的埃式筛法
     *   一边筛(标记)一边记录素数:
     *   线性地扫描着2~length, 其中伴随着以下决策:
     *   若i是素数(arr[i]==0), 则记录在素数数组prime里,继续以下操作;
     *   将i作为最大公约数,乘以小于他的所有素数(小于它的素数就是最小质因数),将形成的每个合数标记为他们的最小质因数
     *   这样一来就可以不用重复地标记具有相同最小质因数的数字，如:3*4=12 2*6==12, 重复原因就是没有确定12的唯一产生方式
     *      -->这时候就可以分解质因数:12=2*2*3,12下标的最小质因数是2,只需在arr数组中标记他们的最小质因数,就可以不重复标记具有相同最小质因数的数字了)
     * @param N
     */
    static void solve2(int N){
        //step1
        int length=2; //1不是素数
        while(length / log(length)<N)
            length++;
        System.out.println("记录第1000000个素数数组范围要到: " + length);
        int[] arr=new int[length+1];

        //step2
        int[] prime=new int[length+1];
        int m=0; //质数的数量
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]==0){ //judge1:若是i为质数
                prime[++m]=i;//重要!!先自增再记录第m+1个质数
                arr[i]=i; //标记它的最小质因数--他自己
            }
            for (int j = 0; j <= m; j++) {
                //i与它的最小质因数之前的素数prime[j]们相乘(包含它的最小质因数), 形成的新合数prime[j]*i,标记为他的最小质因数prime[j]
                if (prime[j]>arr[i] || prime[j]*i>length) //若是prime[j]大于了arr[i]的最小质因数,或新合数超出筛选长度则break
                    break;
                arr[prime[j]*i]=prime[j]; //将i的所有合数(i*prime[j])标识为他们的最小质因数prime[j]
            }
        }

        //step3
        System.out.println("第" + N + "个素数是: " + prime[100000]);
    }
}
