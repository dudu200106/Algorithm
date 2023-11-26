public class _45_跳跃游戏_II {

    /**
     * 从终点反推  每次选择能够得达终点的最左边元素
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n= nums.length;
        int steps = 0;
        int terminal = n-1;
        while (terminal>0){
            for (int i = 0; i < terminal; i++) {
                if (i+nums[i]>=terminal){
                    terminal = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 上一个时间复杂度太高
     *
     * 接下来使用正推的办法
     *
     *      选择当前位置可达的所有位置中, 能够二次到达最远的地方为下一个位置
     *      这样就能使得用最小的跳转步数, 到达最远的位置
     */
    public int jump02(int[] nums) {
        int n = nums.length;
        int step =0;
        int end = 0;
        int mostLonger = 0;
        for (int j = 0; j <n-1 ; j++) {
            mostLonger = Math.max(mostLonger, j+nums[j]);
            if (j==end){
                end = mostLonger;
                step++;
            }
        }
        return step;
    }
}
