import java.util.HashMap;
import java.util.HashSet;

public class _3_无重复字符的最长子串 {
    /**
     * 这题得首先想到滑动窗口的思想——且这题要用变长滑动窗口
     *   变长滑动窗口要求窗口的左边界向右递增一位， 那么右边界也一定是向右递增的
     *
     * 我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，
     * 其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 rk
     *
     * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，
     * 然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
     * 在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
     *
     * 在枚举结束后，我们找到的最长的子串的长度即为答案。

     * @param s
     * @return
     */

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            while (set.contains(ch) && left<i){ // 右移左边界, 直至满足条件(不重复子串)
                set.remove(s.charAt(left++));
            }
            res = Math.max(res, i-left+1);
            set.add(ch);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxRes = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }
            maxRes = Math.max(maxRes, i - left +1);
            map.put(ch, i);
        }
        return maxRes;
    }
}
