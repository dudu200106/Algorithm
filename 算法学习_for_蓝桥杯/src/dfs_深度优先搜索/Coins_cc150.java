package dfs_深度优先搜索;

/**
 * 四种面值的硬币(钞票):25元,10元,5元,1元. 若要凑成面值N,一共有多少种方法
 *
 * 解法: 四种面值,那么就先从大面值的硬币凑起,一直往下从, 总共有4个面值: money=A*25+B*10+C*5+D*1
 *      ----dfs(剩下要凑的余额, 面值数组, 面值下标)
 * 数据结构: 树(n叉树,因为面值这里可重复),共3层(4种面值,最后1元面值只有一种凑法)
 * 结束条件: 遍历到第4层树
 */
public class Coins_cc150 {
    public static int dfs(int money){
        int[] coin={25,10,5,1};
//        return dfs1(money,coin,0);
        int[][] map=new int[money+1][coin.length];
//        return dfs2(money,coin,0,map); //dp优化版本
        return dfs1(money,coin,0); //dp优化版本
    }


    /*纯递归版本*/
    public static int dfs1(int money,int[] coin, int scan){
        int ways=0;
        if(scan>=coin.length-1) return 1;//只剩下了一种方法

        for (int n= 0; n*coin[scan]<=money;n++){
            int amount=n*coin[scan];
            ways+=dfs1(money-amount,coin,scan+1);
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(dfs(100));
    }

    /*dp优化版本--递归备忘录*/
    public static int dfs2(int money,int[] coin, int scan,int[][] map){
        int ways=0;
        /** 1.判断是否在备忘录里,能否直接返回已记录数据*/
        if(map[money][scan]>0) return map[money][scan];
        if(scan>=coin.length-1) return 1;//只剩下了一种方法

        for (int n= 0; n*coin[scan]<=money;n++){
            int amount=n*coin[scan];
            ways+=dfs2(money-amount,coin,scan+1,map);
        }
        map[money][scan]=ways;
        return ways;
    }
}
