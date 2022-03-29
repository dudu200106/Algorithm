package arrayAndMatrice;

public class 子数组最大累加和_B站 {
    /*暴力解法,O(n^2)*/
    public static int findByForce(int[] arr){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            int max02=arr[i];
            int sum=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum+=arr[j];
                if (sum>max02)
                    max02=sum;
            }
            if (max02>max)
                max=max02;
        }
        return max;
    }

    /*线性扫描--使用"双指针"(记录历史最大和的两个边界), 一个活动指针记录现在的最左边界*/
    public static int findByDp(int[] arr){
        int left=0,right=0;
        int scan=0; //活动指针,当满足条件时边界left=scan
        int sum=0,max=0;
        //遍历
        for (int i = 0; i < arr.length; i++) {
            if (sum>=0) // 1.累加和为正,累加下一个
                sum+=arr[i];
            else{ //2.累加为负,跳过之前的负数,累加和从下一个开始
                sum=arr[i];
                scan=i;
            }
            //3.比较历史最大和,是否替换
            if (sum>max) {
                right=i;
                left=scan;
                max=sum;
            }
        }
        System.out.println("left:" +left+ " right:" +right);
        return max;
    }

    public static void main(String[] args) {
        int[] arr={-1,0,2,-1,9,-2};
        System.out.println(findByForce(arr));
    }
}
