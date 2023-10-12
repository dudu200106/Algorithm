import java.util.Scanner;

public class HJ16购物单 {


    public static void main(String[] args){
        int[][] primary = new int[61][3]; //  存放主件的价格v和重要程度p
        int[][][] fujain = new int[61][3][3]; // 存放主件对应的俩个附件的v/p;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <=m ; i++) {
            int v= sc.nextInt();
            int p= sc.nextInt();
            int q= sc.nextInt();
            if(q==0){
                primary[i][1]= v;
                primary[i][2]= p;
            }else {
                if (fujain[q][1][1]!=0) {
                    fujain[q][1][1] = v;
                    fujain[q][1][2] = p;
                }else {
                    fujain[q][2][1] = v;
                    fujain[q][2][2] = p;
                }
            }
        }
        int[][] w= new int[61][5];
        int[][] v= new int[61][5];
        for (int i = 1; i <=m ; i++) {
            if (primary[i][0]==0) continue;
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

        System.out.println(primary.toString());
        System.out.println(fujain.toString());

        sc.close();
    }


}
