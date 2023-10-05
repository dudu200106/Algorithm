package recurs_递归_双管齐下逐步生成;

/**
 * 斐波那契数的增长趋势是呈指数增加的,int类型的变量会很快溢出
 * 递推式: f(n)=f(n-1)+f(n-2) ----也可以变更形式
 * 0,1,1,2,3,5,8... (a0,a1,a2,a3,a4,a5,a6...)
 */
public class FiborNums {
    /*斐波那契法递归原型,时间复杂度O(n^2)*/
    public static long fibor01(int n){ //递归方法
//        if (n<0) return -1; //n不能为负数
        if (n<0) throw new IllegalArgumentException();
        if(n==0||n==1) return n;
        return fibor02(n-1)+fibor02(n-2);
    }

    /*
    * 结果确定、有限，用迭代方法;
    * 此处也有动态规划(dp)自底向上递归记忆法的原理(a和b储存了上两项f(n-1),f(n-2)的值)
    * 时间复杂度:O(n)级别 */
    public static long fibor02(int n){
//        if (n<0) return -1;
        if (n<0) throw new IllegalArgumentException();
        if(n==0||n==1) return n;
        long a =0;
        long b = 1;
        long res=0;
        for (int i=2; i<=n; i++){
            res= a + b;
            a = b;
            b = res;
        }

        return res;
    }

    //动态规划(dynami planning),自顶向下
    public static long fibor03(int n){ //重载
        return fibor03(n,new long[n+1]);
    }
    public static long fibor03(int i,long[] helper){
        if (i<0) throw new IllegalArgumentException();
        if (i==0||i==1) return i;
        if (helper[i]==0){
            helper[i]=fibor03(i-1,helper)+fibor03(i-2,helper);
        }
        return helper[i];
    }

    public static void main(String args[]){
        int start; //开始执行时间
        int end; //运行结束时间

        start = (int)System.nanoTime();
        System.out.println(fibor01(10));
        end =(int)System.nanoTime();
        System.out.println("Time of fibor01:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(fibor02(10));
        end =(int)System.nanoTime();
        System.out.println("Time of fibor02:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        long[] arr =new long[11];
        System.out.println(fibor03(10));
        end =(int)System.nanoTime();
        System.out.println("Time of fibor03:" + (end - start) + "ns");
    }
}
