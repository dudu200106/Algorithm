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
    public static long egcb(long a,long b){
        if(b==0) {
            x =1;
            y =0;
            return a;
        }

        long temp=egcb(b,a%b);
        long x1=x;
        x=y;
        y=x1-(a/b)*y;

        return temp;
    }

    //返回最大该公约数，若等式不成立则返回-1
    public static long bezout_Number(long a, long b, long m){
        long n = m/egcb(a,b); //等式右边的值，最大公约数的n倍
        if(m%egcb(a,b)!=0) {
            System.out.println("m非两数最大公约数倍数，无解！！");
            return -1;
        }
        x*=n;
        y*=n;

        return n;
    }

}
