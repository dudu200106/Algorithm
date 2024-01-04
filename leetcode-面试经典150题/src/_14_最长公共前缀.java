public class _14_最长公共前缀 {

    /**
     * 我的第一种方法
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String sb = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            if (s.length() == 0) {
                return "";
            }
            int p = 0;
            while ( p < Math.min(s.length(), sb.length()) && s.charAt(p) == sb.charAt(p)) {
                p++;
            }
            sb = sb.substring(0, p);
        }
        return sb;
    }


    /**
     * 最快速的方法, 跟第一种方法类似, 利用String的startsWith() 和 subString() API方法
     * @param strs
     * @return
     */
    public String longestCommonPrefix_1(String[] strs) {
        String sb = strs[0];
        for (String s : strs) {
            if (s.length() ==0 || sb.length() == 0) {
                return "";
            }
            while (!s.startsWith(sb)) {
                sb = sb.substring(0, sb.length() - 1);
            }
        }
        return sb;
    }


}
