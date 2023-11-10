public class _875_爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right=0;
        for (int num : piles){
            right = Math.max(right, num);
        }

        int res = 1; // 缓存要返回的速度
        while (left<right){
            int speed = left + right >>1;
            int time =0;
            for(int banana: piles){
                time+=banana/speed + banana/speed>0 ? 1 : 0;
            }
            if (time>=h){ // 速度小了
                left = speed;
            }else {
                right = speed-1;
            }
        }
        return left; // 这一题肯定有答案, 所以不需要判断最后的返回值是否真确了
    }
}
