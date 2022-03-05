package math_数学;

/**
 * 要求用3的指数幂(1,3,9,27...),分别放在天平的左右两边,左盘加右盘减, 表示出用户给出的重量, 且不能重复使用
 * 如:
 * 5
 * 输出:
 * 9-3-1
 *
   思路: 若是直接用三进制表示电话就是循环%3, 但这里一方面是每个进位只能使用一次,且可以有表示负数的进位
        所以,就要使用类似"二进制"1代表要,0代表不要的思想
        1. 可以使用暴力解法循环穷举,每个进制位上有0,-1,1代表这个进位的指数幂数:不要,放右盘,放左盘
        2. 直接求出三进制数,因为每个指数幂只能使用一次, 那么某位是2则进1,原位-1;那么相当于每个进位只有0,-1,1三种情况
 */
public class 天平称重_三进制 {

    public static void main(String[] args) {
    }

    public static void solve(int num){
        StringBuilder sb=transf(num);
        int i=sb.length()-1;
        while (i<=0){

        }
    }

    static StringBuilder transf(int num){
        StringBuilder sb=new StringBuilder();
        while (num>0){
            int temp=num%3;
            sb.append(temp);
            num/=3;
        }
        return sb.reverse();
    }
}
