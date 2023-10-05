package util;

/**
 * 这是一个自制的数组工具类，包括：
 *      * 交换数组元素位置
 *      * 查找数组最大值
 *      * 查找数组最小值
 *      * 打印数组
 *      * 拷贝数组
 */
public class ArrayUtil {

    public static int pp=0;

    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void swap(char[] arr,int index1,int index2){
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int findMax(int[] arr){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i])
                max=arr[i];
        }
        return max;
    }

    public static int findMin(int[] arr){
        int min=0;
        for (int i = 0; i < arr.length; i++) {
            if (min>arr[i])
                min=arr[i];
        }
        return min;
    }

    public static void printArr(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static char[][] copy(char[][] target){
        char[][] res=new char[target.length][target[0].length];
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                res[i][j]= target[i][j];
            }
        }
        return res;
    }
}
