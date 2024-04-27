package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 * 希尔排序的思想: 希尔排序脱胎于直接插入排序.
 *      直接插入排序时,若是原数组基本有序的话,时间效率接近O(n);
 *      --故这样思考: 先追求表中元素局部基本有序, 再逐渐趋向全局有序.
 *      1).把待排序元素间隔划分为一个个诸如:L[i,i+d,i+2d...]的子表(子数组), 用插入排序使每个子表各自有序;
 *      2).再取一个d2<d, 再次划分子表L[i,i+d2,i+2d2...], 再让子表各自有序...
 *      3).重复以上过程, 直至d=1, 就对全局做一次直接插入排序, 很快得出结果
 *
 *      注:
 *      a.因为要不断减小增量d, 故希尔排序又叫做 缩小增量排序
 *      b.增量d最好(希尔本人也推荐)每次取n/2, n/2/2...直至d=1
 *
 */
public class ShellSort {

    public static void shell_sort(int[] arr, int n) {
        for (int d = n/2; d >=1; d/=2) { //划分子表
            // 下面for循环一次,每次使得一个子表有序,也可只一遍就让所有子表有序(具体如下)
            for (int i = 0; i <= n/d; i++) {
                for (int j = i+d; j < n; j+=d) {
                    if (arr[j-d]>arr[j]){
                        int temp =arr[j];
                        int k;
                        for (k = j-d; k >=0 && arr[k]>temp ; k-=d)
                            arr[k+d] = arr[k];
                        arr[k+d] = temp;
                    }
                }
            }
        }

    }

    public static void shell_sort02(int[] arr, int n) {
        for (int d = n/2; d >=1; d/=2) { //划分子表
            for (int j = 1+d; j < n; j++) { //注意这里使局部有序的方法, 与上面不同了
                if (arr[j-d]>arr[j]){
                    int temp =arr[j];
                    int k;
                    for (k = j-d; k >=0 && arr[k]>temp ; k-=d)
                        arr[k+d] = arr[k];
                    arr[k+d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*101);
        }

        shell_sort(arg,arg.length);
        System.out.println(Arrays.toString(arg));
    }

}
