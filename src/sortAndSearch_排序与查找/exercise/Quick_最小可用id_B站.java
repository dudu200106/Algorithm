package sortAndSearch_排序与查找.exercise;

import sortAndSearch_排序与查找.QuickSort;

/**找最小可用ID就是找排序后的第一个断点
 * 1. 暴力解法,顺着乱序素组第一个数来,每个数都要找n,O(n的平方)
 * 2. 快排后遍历, NlogN
 * 3. 数值转下标, 它在不在其位
 * 4. partition分区后, 若中位数mid!=arr[mid],那说明前面肯定有空缺, 放弃一半
 */
public class Quick_最小可用id_B站 { //非负数

    public static int minAvailableID03(int[] arr){
        //寻找最大最小值, 若是从1开始就不要找了
        int maxOfArr=-1;
        int minOfArr=1000001;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxOfArr)
                maxOfArr=arr[i];
            if (arr[i]<minOfArr)
                minOfArr=arr[i];
        }

        //数值转下标
        int[] helper=new int[maxOfArr];
        for (int i = 0; i < arr.length; i++) {
            helper[arr[i]-1]++; //非负数减一
        }
        //找helper下标空着的,就是断点
        int val=maxOfArr+1; //若都是连续的,返回最大值后一位
        for (int j = minOfArr; j < helper.length; j++) {
            if(helper[j]==0) {
                val = j + 1;
                break;
            }
        }
        return val;
    }

    public static int minAvailableID04(int[] arr, int prior, int row){
        int minOfArr=1000001;
        for (int i = 0; i < arr.length; i++) { //先找出最小值
            if (arr[i]<minOfArr)
                minOfArr=arr[i];
        }
        int mid= QuickSort.partition01_1(arr,prior,row);
        if (arr[mid]==mid+minOfArr+1&&arr[mid-1]!=mid+minOfArr) return mid+minOfArr;
        if(arr[mid]==mid+minOfArr)// 左侧紧密,放弃左侧
            return minAvailableID04(arr,mid+1,row);
        else
            return minAvailableID04(arr,prior,mid-1);
    }

    public static void main(String[] args) {
        int[] arg={2,3,4,7,6,8,9,10,11,13};
        System.out.println(minAvailableID03(arg));
        System.out.println(minAvailableID04(arg,0,arg.length-1));
    }
}
