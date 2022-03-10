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
        solve(100000);
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
        System.out.println("a: " + length);
        int[] arr = new int[length];

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
}
