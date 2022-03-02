package sortAndSearch_排序与查找;

import java.util.Arrays;

class InsertSort {

    //插入排序,左栏有序,右栏待排序
    public static void insert_Sort(int[] arr, int left, int right) { //打牌时理顺序
        // 左栏在变大, 右栏在减小
        for (int i = left; i < right; i++) {
            int temp=arr[i+1]; //右栏未理好的第一个数据先保存,作为比较参考
            int index = i+1; //记录空位的下标
            //比较和移动(和要插入的"牌"temp比较,不断将大于temp的数据往后移, 找到合适位置后停止)
            for(int j=i;arr[j]>temp && j>left;j--) {
                arr[j+1]=arr[j];
                index--;
            }
            //temp插入合适位置
            arr[index]=temp;
        }
    }

    public static void insert_Sort(int[] arr) { //好比在打牌时理顺序，分左边理好的部分和右边没理好的；
        for (int i = 1; i < arr.length; i++) { //处理没排序好的部分，在左边找合适位置，并移动
            int temp=arr[i]; //将没理好的、最左边的牌先保存
            int index = i; //理好的牌从右往左，找到待插入位置的索引值
            for (int j = i; j >0&&arr[j-1]>temp; j--) { //然后从右往左比较理好的队列，移动的同时，找到合适插入位置
                    arr[j]=arr[j-1];
                    index--;
            }
            arr[index]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*50);
        }
//        insert_Sort(arg);
        insert_Sort(arg,0,arg.length-1);
        System.out.println(Arrays.toString(arg));
    }
}
