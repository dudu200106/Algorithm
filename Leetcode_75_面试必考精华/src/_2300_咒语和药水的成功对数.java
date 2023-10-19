import java.util.Arrays;

public class _2300_咒语和药水的成功对数 {

    /**
     * 利用二分找到 第一个 乘积大于等于目标值的数, 和药水数组长度相减,然后就能够返回符合的元素数量了
     *      —— 这里巧妙地改变二分时的边界策略，最后剩下的那一个元素（left==right）就是第一个大于等于的元素了
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        long[] arr=new long[potions.length];//必须要转发为long类型，不然超范围
        for (int i = 0; i < potions.length; i++) {
            arr[i]=potions[i];
        }
        for (int i = 0; i < spells.length ; i++) {
            int spell = spells[i];
            int l=0, r=potions.length-1;
            while (l<r){
                if(arr[arr.length-1]*spell<success){
                    r=arr.length;
                    break;
                }
                int mid = (l+r)>>1;
                if (arr[mid] * spell>= success){
                    r=mid;
                }else {
                    l=mid+1;
                }
            }
            res[i] = arr.length-r;
        }
        return res;
    }
}
