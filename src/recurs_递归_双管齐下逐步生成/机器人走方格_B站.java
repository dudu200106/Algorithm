package recurs_递归_双管齐下逐步生成;

/** 机器人有多少种方法, 从方格左上角走到右下角, 且只能往右移和往下移
 *  思路: 倒着想的话, 最终结果f(x,y)= f(x-1,y)+f(x,y-1);
 *      且只有两种移动方法,那么从原点一直右移和下移,就只有一种方法,即当x=1/y=1时,return 1;
 */
public class 机器人走方格_B站 {
    /*递归--记忆型递归实现的动态规划DP*/
    static int[][] dp =new int[4][4];
    static int getMove01(int x, int y){
        if(x==1||y==1) return 1;//退出出栈条件
        if(dp[x][y]>0) return dp[x][y];
        int ans=getMove01(x-1,y)+getMove01(x,y-1);
        dp[x][y]=ans;
        return ans;
    }

    /*迭代--地推实现的动态规划DP*/
    static int getMove02(int x, int y){
        int[][] box=new int[x+1][y+1];
        /*step.1 base case -- 初始化第一行和第一列*/
        for (int i = 0; i <= x; i++) {
            box[i][1]=1;
            box[1][i]=1;
        }
        /*step.2 DP状态转移函数和策略*/
        /*
        * f(x,y)=f(x+1,y) + f(x, y+1)
        * */
        for (int j = 2; j <=x ; j++) {
            for (int k = 2; k <=y ; k++) {
                box[j][k]=box[j-1][k]+box[j][k-1];
            }
        }
        return box[x][y];
    }

    public static void main(String[] args) {
        int start =(int)System.nanoTime();
        System.out.println(getMove01(3,3));
        int end =(int)System.nanoTime();
        System.out.println(end - start);
        start =(int)System.nanoTime();
        System.out.println(getMove02(3,3));
        end =(int)System.nanoTime();
        System.out.println(end - start);
    }
}
