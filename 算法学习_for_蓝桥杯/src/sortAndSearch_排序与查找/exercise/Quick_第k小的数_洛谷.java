package sortAndSearch_排序与查找.exercise;

/**
 * 这里主观的解决办法是将乱序数组排序后,再输出arr[k]
 * 但超时了
 * 所以根据BUD的的优化原则,发现每次分区之后,会出现一个中位数,那类似"二分查找"的, 放弃一半不就行了?
 * 所以,只针对一半排序,当mid==k时, 输出arr[k]
 */
public class Quick_第k小的数_洛谷 {
    /*public static int searchK(int[] arr, int prior, int row, int k){
        int mid=partition(arr, prior, row);
        if (mid==k) return arr[mid];
        else if (k<mid)
            return searchK(arr,prior,mid-1,k);
        else
            return searchK(arr,mid+1,row,k);
    }*/

    public static int searchK(int[] arr, int prior, int row, int k){
        int q=partition(arr, prior, row);
        int qk=q-prior+1;
        if (qk==k) return arr[q];
        else if (qk>k)
            return searchK(arr, prior,q-1, k);
        else
            return searchK(arr,q+1,row,k-qk);
    }
    //单项扫描
    public static int partition(int[] arr, int prior, int row){
        //指针
        int pivot=arr[prior];
        int scan=prior+1;
        int bigger=row;
        //扫描
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

    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        /*Scanner input=new Scanner(System.in);
        int range=input.nextInt();
        int k=input.nextInt();
        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i]= input.nextInt();
        }*/

        int[] arr={1,4,2,8,5,6,4};
        System.out.println(searchK(arr,0,arr.length-1,4));
    }
}
