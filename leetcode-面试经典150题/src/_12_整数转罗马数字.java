public class _12_整数转罗马数字 {

    /**
     * 这题隐藏着一个条件:
     *   由基础的7个罗马数字, 可以再拼接组合成另外6个数字.
     *   由小到大分别是:
     *      "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
     *   分别代表:
     *      1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
     *   故:
     *      我们可以根据当前值是否大于某个数字, 从大到小减去这几个数字, 拼接成对应的罗马数字字符
     */

    public int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public String[] ss = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i>=0; i--) {
            int val = nums[i];
            String str = ss[i];
            while (num>=val){
                sb.append(str);
                num-=val;
            }
            if (num ==0){
                break;
            }
        }
        return sb.toString();
    }

}
