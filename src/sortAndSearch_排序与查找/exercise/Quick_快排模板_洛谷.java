package sortAndSearch_排序与查找.exercise;

import java.util.Arrays;

public class Quick_快排模板_洛谷 {
    public static void sort_Quick(int[] arr, int prior, int row){
        if (prior<row){ //长度小于8的插排更快
            if (row-prior<=8){
                insert_Sort(arr,prior,row);
            }
            int mid=partition(arr, prior, row);
            if (prior<mid)
                sort_Quick(arr,prior,mid-1);
            if (mid+1<row)
                sort_Quick(arr,mid+1,row);
        }
    }

    //单项扫描
    public static int partition(int[] arr, int prior, int row){
        //三点中值法求中值,应对最坏情况
        int midIndex=(prior+row)/2;
        if (arr[prior]>arr[midIndex]&&arr[prior]<arr[row])
            midIndex=prior;
        if (arr[row]>arr[midIndex]&&arr[row]<arr[prior])
            midIndex=row;
        // 中值和第一个元素交换, 变成熟悉的主元在第一位
        swap(arr,prior,midIndex);

        int pivot=arr[prior];
        int scan=prior+1;
        int bigger=row;
        //单项扫描
        while (scan<=bigger){
            if (arr[scan]<=pivot){
                scan++;
            }else {
                swap(arr, scan, bigger);
                bigger--;
            }
        }
        //交换主元的下标,返回中位数
        swap(arr,prior,bigger);
        return bigger;
    }

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

    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }
        sort_Quick(arg,0,arg.length-1);
        System.out.println(Arrays.toString(arg));
    }

    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int range=input.nextInt();
        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i]= input.nextInt();
        }
        sort_Quick(arr,0,arr.length-1);
        for (int index:arr)
            System.out.print(index+" ");
    }*/
}