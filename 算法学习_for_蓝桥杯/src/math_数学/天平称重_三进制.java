package math_数学;

import java.util.ArrayList;

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
        solve(1000);
    }

    public static void solve(int num){
        StringBuilder temp=new StringBuilder();
        temp.append(Integer.toString(num,3)); //Integer.toString(N,几进制)
        char[] arr=temp.toString().toCharArray();
        ArrayList<Integer> list=new ArrayList<>();
        for (int j = arr.length-1; j >=0 ; j--) {
            if (arr[j]=='2'){ //"逢2进1,原位为-1"
                list.add(0,-1);//在链表头部插入,再看情况是否进位
                if (j==0){ //数值进制到头,直接插入以
                    list.add(0,1);
                } else
                    arr[j-1]++; //进位
            }
            else if (arr[j]=='3'){ //"逢3进1,原位为0"
                list.add(0,0);
                if (j==0){
                    list.add(0,1);
                } else {
                    arr[j-1]++;
                }
            }
            else list.add(0,arr[j]-'0');
        }
        System.out.println(list);


        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==1) sb.append('+').append((int)Math.pow(3,list.size()-i-1));
            if (list.get(i)==-1) sb.append('-').append((int)Math.pow(3,list.size()-i-1));
        }
        System.out.println(sb.substring(1));
    }

}
