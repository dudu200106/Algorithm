public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int ans = 0;
        while(left!=right){
            int s = Math.min(height[left],height[right]) * (right - left);
            ans = Math.max(ans, s);
            if (height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
