package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 *
 * 思想: 让原数组内的前缀数组一直有序,并不断扩大前缀数组,直至与原数组一样长(排序完毕);
 *      遍历时, 让有序前缀数组的后一个数, 插到前缀数组中合适的位置
 *          -- 故选择排序分两步: 确定位置 和 不断后移为了空出位置
 *              (让两个步骤分开, 确定位置用二分查找, 能较少地优化算法效率, 但实际不好用)
 */
class InsertSort {

    //插入排序,下标i元素之前是有序的前缀数组
    public static void insert_Sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 把原本下标为i的元素插到合适的位置
            int temp = arr[i];
            for (int j = i; j > 0; j--) {
                 if(arr[j-1]>temp){
                     arr[j] = arr[j-1]; // 移动, 然后空出一个位置
                 }else {
                     arr[j] = temp; // 找到合适位置, 插入
                     break;
                 }
            }
        }
    }

    public static void insert_Sort02(int[] arr) { //好比在打牌时理顺序，分左边理好的部分和右边没理好的；
        for (int i = 1; i < arr.length; i++) { //处理没排序好的部分，在左边找合适位置，并移动
            int temp=arr[i]; //将没理好的的牌先保存
            int j ;
            for (j = i; j >0 && arr[j-1]>temp; j--) { // 短路&的特性, 这里j>0在前,否则arr[j-1]越界
                    arr[j]=arr[j-1];
            }
            arr[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arg=new int[10];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*101);
        }
        System.out.println("排序前：" + Arrays.toString(arg));
//        insert_Sort02(arg);
        insert_Sort(arg);
        System.out.println("排序后：" + Arrays.toString(arg));
    }
}
