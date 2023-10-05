package sortAndSearch_排序与查找.exercise;

import java.util.Arrays;

/**
 * 考虑三种解法:
 * 1. 第k小的数: 因为数组排序好后, 肯定占据一半还要多,联想"第k小的数", partition+二分查找->>输出arr[mid]
 * 2. 散列表hash统计
 * 3. 不同数值就抵消: 声明两个数, 一个放当前数,一个放出现次数, 遍历数组下一个不同就出现次数-1
 */
public class Partition_超过数组一半的数_Acwing和剑指offer {

    /*第一种*/
    public static int moreThanHalfNum_Solution01(int[] nums) {
        return searchK(nums,0,nums.length-1,nums.length>>1-1);
    }
    /*第三种 最简单*/
    public static int moreThanHalfNum_Solution02(int[] nums) {
        int val=nums[0];
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==val)
                count++;
            else {
                count--;
                if (count==0){
                    val=nums[i];
                    count=1;
                }
            }
        }
        return val;
    }

    public static int searchK(int[] arr, int prior, int row, int k){
        int q=partition(arr, prior, row);
        int qk=q-prior+1;
        if (qk==k) return arr[q];
        else if (qk>k)
            return searchK(arr, prior,q-1, k);
        else
            return searchK(arr,q+1,row,k-qk);
    }



    public static int partition(int[] arr,int prior,int row){
        int pivot=arr[prior];
        int scan=prior;
        int bigger=row;

        while(scan<=bigger){
            if (arr[scan] <= pivot)
                scan++;
            else {
                swap(arr, bigger, scan);
                bigger--;
            }
        }
        swap(arr,prior,bigger);
        return bigger;
    }

    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void main(String[] args) {
        int[] arg= {5,5,1,4,5,2,3,5,5,5};
//        System.out.println(searchK(arg,0,arg.length-1,arg.length/2+1));
        System.out.println(moreThanHalfNum_Solution01(arg));
        System.out.println(Arrays.toString(arg));
        Arrays.sort(arg);
    }
}
