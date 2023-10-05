package math_数学;

import java.util.Scanner;

public class InverseElement01 {

    /**
     * @author seAN D
     * @param args
     * @amend_time 2021/12/12
     *
     * 求逆元过程：同余定理 --> 解不定方程 --> 扩展欧几里得/Bezout定理
     *
     * 同余方程：a≡b(mod n) <--> a%n=b
     * 故可解不定方程：ax≡b(mod n) <--> ax=ny + b(余数) <--> ax + ny =b (y符号可内涵)
     * 那么就可以用Bezout定理求出逆元x（ax≡1(mod n), 逆元x是a关于模n的乘法逆元/倒数），即求：
     *   ax + ny =1，贝祖数[x，y]
     *   但最后的逆元并不能方法：x=(x%b+b)%b
     */
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter two Number About InverseElement:");
        long num1 = input.nextLong();
        long num2 = input.nextLong();
//        long d= bezout_Number(96,36,24);
        long element= inverseElement(num1,num2 );
        System.out.println("逆元：" + element);
    }

    public static long inverseElement(long x,long n){ //相当于ax≡1(mod d),返回a对于模d的逆元
        Beizu_Number.bezout_Number(x,n,1);
        long temp = Beizu_Number.x;
        return (temp%n+n)%n; //确保返回一个正数——逆元是正数，也是第一组贝组数x大于零的
    }

    private static class Beizu_Number {
        static long x;
        static long y;

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
}
