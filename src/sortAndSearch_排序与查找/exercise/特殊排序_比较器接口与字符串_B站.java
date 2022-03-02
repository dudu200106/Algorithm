package sortAndSearch_排序与查找.exercise;

import java.util.Arrays;
import java.util.Comparator;

/**一个整形数组类似{3,32,321},输出他们三个可拼接成的最小整数(比如"332321")
 * 解法:Arrays.sort()快速排列就成--但这里使用传入比较器的方法进行排序
 */
public class 特殊排序_比较器接口与字符串_B站 {
    public static int specal_sort(Integer[] arr){
        //传入比较器,API排序
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1+""+o2;
                String s2=o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        //拼接字符串--动态字符串StringBuffer
        StringBuffer sb= new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        Integer[] arg={3,32,321};
        System.out.println(specal_sort(arg));;
    }
}
