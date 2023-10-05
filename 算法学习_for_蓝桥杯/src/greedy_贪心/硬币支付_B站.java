package greedy_贪心;

import java.util.Scanner;

/**
 * 有1元,5元,10元,50元,100元,500元的硬币各c1,c5,c10,c50,c100,c500枚.
 * 现在要用这些硬币来支付A元,最少需要多少枚硬币?
 * 假定本题至少存在一种支付方案.
 *
 * 输入:
 * 第一行有六个数字,分别代表从小到大6种面值的硬币的个数
 * 第二行为A,代表需支付的A元
 *
 * 样例:
 * 输入:
 * 3 2 1 3 0 2
 * 620
 * 输出:
 * 6
   思路: 每次都顺着从大的凑下来, 就是最优选择
 */
public class 硬币支付_B站 {
    static int[] coins={1,5,10,50,100,500};
    static int[] cnt =new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            cnt[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int res = greedy(amount);
        System.out.println(res);
    }

    static int greedy(int ant){
        int count=0;
        int cur=5;

        while(cur>=0&&ant>0){
            int num=ant/coins[cur]; //每次从最大面值的开始,看最多能包含几张
            if (num>0&&cnt[cur]>0){ //剩余的面值张数,和能凑几张
                if (cnt[cur]>num){
                    ant-=num*coins[cur];
                    count+=num;
                }
                else {
                    ant-=cnt[cur]*coins[cur];
                    count+=cnt[cur];
                }
            }
            cur--;
        }
        return count;
    }
}
