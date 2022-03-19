package 省题备考;

import java.util.Scanner;

/**
 暴力版本, 使用二维数组, 有较大空间浪费, 时间复杂度也更高
    --在2中用更好的数据结构--HasMap代替了
 */
public class 外卖店优先级1_2019 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N =in.nextInt();
        int M =in.nextInt();
        int T = in.nextInt();
        int[][] arr=new int[N+1][T+1]; //行下标代表时间, 每列代表一个店铺
        for (int i = 1; i <=M ; i++) {
            int ti=in.nextInt();
            int id= in.nextInt();
            arr[id][ti]++;
        }

        int res=0; //最后结果

        int cnt=0;
        boolean flag=true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[1].length; j++) {
                int val = arr[i][j];
                if (val > 0) {
                    cnt += val * 2;
                    if (cnt>5)
                        flag=true;
                } else if (cnt > 0) {
                    cnt--;
                    if (cnt<=3)
                        flag=false;
                }
            }
            if(flag)
                res++;
        }

        System.out.println(res);
    }
}
