package sortAndSearch_排序与查找.exercise;

public class 找到和为10的元组_b站 {
    static void findTwo_tuples(int[] arr){
        //开辟左右两个指针
        int left=0;
        int right=arr.length-1;
        //左右两个指针相加,若是小于10,左指针+1;若是大于大于是10,右指针-1
        while(left!=right) { //当两指针重合,结束
            if (arr[left]+arr[right] == 10) {
                System.out.println("(" + arr[left] + " " + arr[right] + ")");
                left++;
            }
            else if (arr[left]+arr[right] > 10) right--;
            else left++;
        }
    }

    /*查找二元组的时间复杂度为O(n);
    * 而三元组则根据 num3+(num1+num2)=10,加上一个for循环遍历num3
    * 时间复杂度就变成了n*O(n)=O(n^2)
    * */
    static void findThree_tuples(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int left=i+1; //为了不重复,每次都从num3的下一个开始找
            int right=arr.length-1;
            while(left!=right&&left<arr.length-2) { //当两指针重合,结束
                if (arr[i] +arr[left]+arr[right] == 10) {
                    System.out.println("(" + arr[i]+ " " +arr[left]+ " " +arr[right]+ ")");
                    left++;
                }
                else if (arr[i] +arr[left]+arr[right] > 10) right--;
                else left++;
            }
        }

    }
    public static void main(String[] args) {
        int[] arg={-8,-4,-3,0,2,4,5,8,9,10};
        findThree_tuples(arg);
    }
}
