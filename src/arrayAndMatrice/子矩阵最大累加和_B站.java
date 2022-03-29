package arrayAndMatrice;

import java.util.Arrays;

/*暴力解法时间复杂度为一维数组的两倍:O(n^4),就不尝试了*/
public class 子矩阵最大累加和_B站 {
    /*借助上一题的findByDp方法, 竖向相加压缩每个子矩阵为"一维数组",遍历,>O(n^3)*/

    /*
    *  模板:
    *   int[] temp;--矩阵列数
    *   for 压缩起始行 from 0 to arr.length-1
    *       for 向下压缩行数 from 压缩起始行 to arr.length-1
    *           计算压缩后的一位数组最大累加和
    *           与历史最大比较
    *   结束
    *
    * */
    public static int findMaxSum(int[][] arr){
        int[] temp=new int[arr[0].length];
        int max=-100001;
        //压缩起始行
        for (int i = 0; i <arr.length ; i++) {
            //向下压缩的行数
            for (int j = i; j < arr.length; j++) {
                //向下一直累加,压缩
                for (int k = 0; k < arr[0].length; k++) {
                    temp[k]+=arr[j][k];
                }
                int sum=子数组最大累加和_B站.findByDp(temp);
                if(sum>max)
                    max=sum;
            }
            Arrays.fill(temp,0);//清理
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-90, 48, 78},
                {64, -40, 64},
                {-81, -7, 66}
        };
//        matrix = new int[][]{{1, 2, -1}};
        int res = findMaxSum(matrix);
        System.out.println(res);
    }
}
