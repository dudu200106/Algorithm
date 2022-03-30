package arrayAndMatrice;

/**
 * 输出边界为1的矩形, 其最大长度的方阵/正方形的边长
 *
 * 如:
 * 1,1,1,0
 * 0,1,1,0
 * 0,0,1,1
 * 0,0,1,0
 *
 * 最大边长为: 2
 */
public class 边界为1的最大square_B站 {
    public static void main(String[] args) {
        int[][] matric={{0,0,1,1,0},
                        {0,1,1,1,0},
                        {1,1,0,1,0},
                        {1,1,1,1,0}};
        System.out.println(solve(matric));
    }


    /**
     *
     * @param arr
     * @return
     *
     * 模板:
     *      while from 5 to 0, 从大到小扫描是否能够构成一个方阵
     *          for i    //i, j代表每次尝试的起点, i,j<=arr.length-n
     *              l4:
     *              for j
     *                  r=i,c=j;
     *                  while() X4 扫描四条边, 若是有0则跳 l4
     *                  ...
     *                  return n; //四条边都为1, 返回最大边长n
     */

    static int solve(int[][] arr){

        int n=arr.length;
        /** 1.from 5 to 0, 从大到小扫描是否能够构成一个方阵*/
        while(n>0){
            /** 2.i, j代表每次尝试的起点 */
            for (int i = 0; i <=arr.length-n; i++) {
                l3:
                for(int j = 0; j <=arr.length-n; j++) {
                    int r=i; //行和列
                    int c=j;

                    /** 3.扫描方式: 绕一圈*/
                    while(c<j+n){ //上
                        if (arr[r][c]==0) continue l3;
                        c++;
                    }
                    c--; /** 4.跳出判断会越界一位, 恢复*/

                    while(r<i+n){ //现在来到了右边
                        if (arr[r][c]==0) continue l3;
                        r++;
                    }
                    r--;
                    while(c>=j){ //现在来到了下边
                        if (arr[r][c]==0) continue l3;
                        c--;
                    }
                    c++;
                    while(r>=i){ //现在来到了左边
                        if (arr[r][c]==0) continue l3;
                        r--;
                    }
                    /**5.如果扫描完四条边还没跳,说明满足条件,返回最大边长 n */
                    return n;
                }
            }
            n--;
        }
        return n;
    }
}
