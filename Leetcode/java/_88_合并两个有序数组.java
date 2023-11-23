import java.util.Arrays;

public class _88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        * 这题可以使用类似插入排序那样不断移动、找到位置后插入的办法， O(n^2)
        * 但最好空间换时间,使用归并排序那样的办法, 用一个辅助数组使得空间复杂度为o(n)
        * */

        int[] help = Arrays.copyOf(nums1, m+n);
        int p = m;
        int q = n;
        int cur= m+n;
        while (p+q>=0){
            while (nums1[p] >=nums2[q] && p>=0){
                help[cur--] = nums1[p--];
            }
            while (nums2[q] >=nums1[p] && q>=0){
                help[cur--] = nums2[q--];
            }
        }
        while (q>0){
            help[cur--] = nums2[q--];
        }
        nums1= help;
    }


}
