package enumrate_枚举;

import java.util.Scanner;

/**
 * 问: 有一个 n \times mn×m 方格的棋盘，求其方格包含多少正方形、长方形（不包含正方形）。
 * 思路1: 真*暴力枚举----画图,找到规律--矩形左上和右下的端点,斜率==1是正方形,其他是长方形
 *   结果: 时间复杂度O(n^4),枚举数量太大,爆掉了..
 * 思路2: 逐步生成----固定矩阵左上角坐标(0,0),变动右下角坐标(i,j),计算每次坐标变动后多出的矩形和正方形.
 *     发现右下角坐标(i,j)每移动一次,就会比以往多出i*j个矩形,min(i,j)个正方形.
 *     (如果算出了矩形的总数,减去正方形数就行了)
 * 思路3: 数学公式----
 */
public class P2241统计方形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int cou_squa = 0;
        int cou_rect = 0;

        /*思路1: 真*暴力枚举*/
        /*for (int x1=0;x1<c;x1++)
            for (int y1 = 0; y1 < r; y1++)
                for (int x2=x1 + 1;x2<=c;x2++)
                    for (int y2 = y1+1; y2 <= r; y2++) {
                        System.out.println("x1:" + x1 + " y1:" + y1 + " x2:" + x2 + " y2:" + y2);
                        if ((y2 - y1) / (x2 - x1) == 1) cou_squa++;
                        else cou_rect++;
                    }
        System.out.println(cou_squa+ " " +cou_rect);*/

        /*思路2: 逐步生成*/
        /*for (int i = 1; i <= c; i++)
            for (int j = 1; j <= r; j++) {
                cou_squa += Math.min(i, j);
                cou_rect += i * j;
            }
        System.out.println(cou_squa + " " + (cou_rect - cou_squa));*/

        /*思路3: 数学公式----矩形的数量=((column+1)*column/2)*((row+1)*row/2)*/
        cou_rect = ((c + 1) * c / 2) * ((r + 1) * r / 2);
        for (int i = 1; i <= Math.min(c, r); i++){
            cou_squa+= (c - i + 1) * (r - i + 1);
        }
        System.out.println( cou_squa +" "+ (cou_rect - cou_squa));
    }
}
