import java.util.Scanner;

public class HJ16购物单 {


    public static void main(String[] args){
        int[][] primary = new int[61][3]; //  存放主件的价格v和重要程度p
        int[][][] fujain = new int[61][3][3]; // 存放主件对应的俩个附件的v/p;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        /* 1. 将主件,附件分开，把v，p存放于数组中*/
        for (int i = 1; i <=m ; i++) {
            int v= sc.nextInt();
            int p= sc.nextInt();
            int q= sc.nextInt();
            if(q==0){
                primary[i][1]= v;
                primary[i][2]= p;
            }else { // 附件放于对应的
                if (fujain[q][1][1]==0) {
                    fujain[q][1][1] = v;
                    fujain[q][1][2] = p;
                }else {
                    fujain[q][2][1] = v;
                    fujain[q][2][2] = p;
                }
            }
        }

        /* 2. 此步骤是核心, 将问题转化为我们熟悉的01背包

            w[i][k]代表第i个主件的k个附件情况下的"重量"--金额
            v[i][k]代表第i个主件的k个附件情况下的"价值"--满意度

            k: 每个主件下有四种情况
                case1: 一个主件 + 0个附件
                case2: 一个主件 + 附件1
                case3: 一个主件 + 附件2
                case4: 一个主件 + 附件1 + 附件2
        * */
        int[][] w= new int[61][5];
        int[][] v= new int[61][5];
        for (int i = 1; i <=m ; i++) {
            if (primary[i][1]==0) continue;
            w[i][1] = primary[i][1];
            v[i][1] = primary[i][1]*primary[i][2];

            if(fujain[i][1][1]!=0) {
                w[i][2] = primary[i][1] + fujain[i][1][1];
                v[i][2] = primary[i][1]*primary[i][2] + fujain[i][1][1]*fujain[i][1][2];
                if (fujain[i][2][1] != 0){
                    w[i][3] = primary[i][1] + fujain[i][2][1];
                    v[i][3] = primary[i][1]*primary[i][2] + fujain[i][2][1]*fujain[i][2][2];

                    w[i][4] = primary[i][1] + fujain[i][1][1] + fujain[i][2][1];
                    v[i][4] = primary[i][1]*primary[i][2] + fujain[i][1][1]*fujain[i][1][2] + fujain[i][2][1]*fujain[i][2][2];
                }
            }
        }

        //开始dp
        /*
            这里多了一重循环, 本质还是01背包
        */
        int[][] dp = new int[m+1][n/10+1];
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n/10 ; j++) {
                int max = dp[i-1][j];
                for (int k = 1; k <=4 ; k++) {
                    if (j >= w[i][k]/10){
                        max = Math.max(max, dp[i-1][j-w[i][k]/10] + v[i][k]);
                    }
                }
                dp[i][j] = max;
            }
        }

        System.out.println(dp[m][n/10]);
        sc.close();
    }


}
