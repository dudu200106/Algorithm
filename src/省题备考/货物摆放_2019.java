package 省题备考;

//填空题--可以直接打表, 数学推算
//当n=2021041820210418时, 有多少种种摆放货物的方式
//  说明: 这种题一般是分解为三个因子, 这里的问题变体就是:排序,不考虑重复
//  而分解为因子的
/*
  分解质因数后,每个质因数都有0,1,n种选法,如:
  4=2*2 -->2^2
  0 0 1*1*4
  0 1 1*2*2
  1 0 2*1*2 //这里可以看出, 若一个质因子只出现一次不去重的话有3种选法
  1 1 2*2*1
  0 2 1*4*1
  2 0 4*1*1

* */

//  注: 最后只是打表出每个质因数的个数, 这里是填空题, 要进一步数学推算
public class 货物摆放_2019 {
    public static void main(String[] args) {
        long n=2021041820210418L;
        int temp=2; //从2开始的质数
        while (temp <= n/temp){
            int exponent=0;
            while (n%temp==0){
                n/=temp;
                exponent++;
            }
            if (exponent>0)
                System.out.println(temp+ " : " +exponent);
            temp++;
        }
        if (n!=1)
            System.out.println(n +" : "+ 1);
    }
}
