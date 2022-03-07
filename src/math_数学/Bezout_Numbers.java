package math_数学;

import java.util.Scanner;

public class Bezout_Numbers {
    static long x;
    static long y;

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Three Number About Bezout:");
        long num1 = input.nextLong();
        long num2 = input.nextLong();
        long num3 = input.nextLong();
//        long d= bezout_Number(96,36,24);
        long d= bezout_Number(num1,num2 ,num3);
        System.out.println("贝组数：" + x + " " + y );
    }

    /**原始欧几里得算法:
     *     public static long gcb(long a,long b) {return b==0?a:gcb(b,a%b);}
     */

    //扩展欧几里得方法，方便下一步求贝组数（返回的是最大公约数）

    /**
     * 定义了两个变量x,y分别代表使贝祖等式成立时的贝祖数
     * 裴蜀定理: ax + by = m (m为gcd(a,b)的倍数)
     * 实际运用: 得知了a,b的gcd, 可以由a,b配出任何gcd的倍数--若gcd(a,b)=1, 可以组合处任何数
     * 扩展欧几里得在这里的任务: 计算出使ax + by = gcd 成立的基本贝祖数, 把他们放在静态变量x,y里
     * @param a
     * @param b
     * @return gcd 最小大公约数:greatest common divisor
     */
    public static long egcb(long a,long b){
        if(b==0) {
            x =1;
            y =0;
            return a;
        }
        //入栈
        long gcd=egcb(b,a%b);
        //出栈,静态变量x和y已近改变成bx'+(a%b)y'=gcd 的解
        long x1=x;
        x=y;
        y=x1-(a/b)*y;

        return gcd;
    }

    //返回最大该公约数，若等式不成立则返回-1
    /**
     * ax+by=m (m为gcd(a,b)的倍数)
     * @param a
     * @param b
     * @param m
     * @return n 最大公约数的倍数
     */
    public static long bezout_Number(long a, long b, long m){
        long n = m/egcb(a,b); //等式右边的值，最大公约数的n倍
        if(m%egcb(a,b)!=0) {
            System.out.println("m非两数最大公约数倍数，无解！！");
            return -1;
        }
        x*=n;//x,y是静态变量
        y*=n;

        return n;
    }

}
