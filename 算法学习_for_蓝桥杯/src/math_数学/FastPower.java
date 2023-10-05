package math_数学;

/**
 * 这里介绍了两种快速幂的思想:
 *   1.二分思想, 不断使基数平方翻倍,指数减半
 *   2.位运算, 将指数转换成二进制数, 每位二进制位代表此位是否取得到, 然后累乘得到result
 *最后还可以拓展一下矩阵幂运算的思想--首先得学会斐波那契的矩阵解法
 */
public class FastPower {

    static int fast1(int base, int power){
        if (power==0) return 1;
        if (power==1) return base;

        int res=1;
        int temp=base;
        int exponent=1;
        while((exponent<<1)<=power){
            temp*=temp;
            exponent<<=1;
        }
        res=temp * fast1(base,power-exponent);
        return res;
    }

   /*利用power的二进制--如10次幂的二进制格式:1010, 每位对应着(base)^2^n-1要不要取, 由小到大平方翻番累乘上去*/
   static int fast2(int base, int power){
       int res=1;
       int bit=base; //bit代表每位的进位数,现在是最小的那位
       while (power>0){
           if ((power&1)==1){ //判断是否取得到此时的最低位
               res*=bit;
           }
           bit*=bit; //无论此二进制位是否取得到,进位都要平方翻番
           power>>=1; //移位至更高位
       }
       return res;
   }

    public static void main(String[] args){
        long start= System.nanoTime();
        System.out.println(fast1(9,5));
        long end= System.nanoTime();
        System.out.println("Solve1: "+ (end-start));

        start= System.nanoTime();
        System.out.println(fast2(9,5));
        end= System.nanoTime();
        System.out.println("Solve2: "+ (end-start));
    }
}
