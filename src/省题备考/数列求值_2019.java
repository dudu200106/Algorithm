package 省题备考;

/**
 * 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和,求 第 20190324 项的最后 4 位数字。
 *
 * 思路:简单的斐波那契, 加上个取余10000
 */
public class 数列求值_2019 {
    public static void main(String[] args) {
        int num=20190324;
        int a=1,b=1,c=1;
        int temp=-1;
        for (int i = 4; i <=num ; i++) {
            temp=(a+b+c)%10000;
            a=b;
            b=c;
            c=temp;
        }
        System.out.println(temp);

    }
}
