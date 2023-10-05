public class HJ93数组分组 {

    public static void main(String[] args) {
        System.out.println(min_diff(new int[]{1, 5, -5, 1}));
        System.out.println(min_diff(new int[]{3,5,8}));
    }

    public static int min_diff(int[] arr){
        int[] pre_sum = new int[arr.length];
        pre_sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) { // 得出前缀和数组
            pre_sum[i] = pre_sum[i-1]+arr[i];
        }
        int total = pre_sum[pre_sum.length-1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pre_sum.length; i++) {
            if (Math.abs(pre_sum[i] - (total-pre_sum[i]) )==0){
//                if (check(arr,i)){
//
//                }
                return i;
            }
        }


        return min;
    }

    static boolean check(int[] arr, int mid){

        for (int i = 0; i <= mid; i++) {
            if(arr[i]%5==0 && arr[i]%3==0){
                return false;
            }
        }
        for (int i = mid+1; i <arr.length ; i++) {
            if(arr[i]%5==0 && arr[i]%3==0){
                return false;
            }
        }
        return true;
    }
}


