public class _392_判断子序列 {
    /**
     * 这题可以用简单的双指针,;
     * 或者深入一点, 用dp动态规划进行预处理,减少移动比较的时间
     */


    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            // 找到 t 上第一个匹配的 ch
            while (i < t.length() && t.charAt(i) != ch) i++;
            // 如果 t 穷尽，跳出，注意始终对 i 加一
            if (i++ >= t.length()) break;
        }
        return i <= t.length();
    }


    /**
     * dp减少了大量用于下一个字符是否存在的比较
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence_2(String s, String t) {
        //先预处理, 生成一个dp数组

        //在进行比较
        return false;
    }
}
