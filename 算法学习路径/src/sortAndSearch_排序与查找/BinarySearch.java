package sortAndSearch_排序与查找;

public class BinarySearch {

    public static int binary_Search01(int[] a, int target){
        int low=0; //未处理数据边界值
        int high=a.length-1;
        while(low<=high){ //若是边界值交错了，说明找到最后一个也找不到
            int mid=(low+high)/2;
            if(a[mid]==target)
                return mid;
            else if(a[mid]>target)
                high=mid-1; //最大值变成中位数上一位，很重要！！
            else
                low=mid+1; //最小值变成中位数下一位
        }
        return -1;
    }

    public static int binary_Search02(int[] arr, int target, int low, int high){
        if(low>high) return -1; //退出条件

        int mid = (high+low)>>1; //相当于(high+low)/2
        if (arr[mid]<target)
            return binary_Search02(arr,target,mid+1,high);

        else if (arr[mid]>target)
            return binary_Search02(arr,target,low,mid+1);

        else return mid;
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }
//        System.out.println(binary_Search02(arg,8,0,arg.length));
        System.out.println(binary_Search01(arg,8));

    }
}
