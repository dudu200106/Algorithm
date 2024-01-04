import java.util.ArrayList;
import java.util.List;

/**
 * 这道简单题最适合用 KMP 算法
 *
 * @author Sean Du
 * @date 2024/01/04
 */
public class _28_找出字符串中第一个匹配项的下标 {

    /**
     * 暴力解法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        List<Integer> inds = new ArrayList<>();
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (i > haystack.length()-needle.length()){
                break;
            }
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 较简洁版本, next[i]储存的是i结尾字符串最长相等前后缀 长度（就是相等的前缀的后一位）
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int[] next = buildNext(needle);
        // 双指针, i指向text的指针, j指向pattern的指针
        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    // 返回匹配的起始位置
                    return i - j;
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

//    int solve(String text, String pattern){
//        // 经由模式串构造next数组
//        int[] next = buildNext(pattern);
//        int i=0;
//        int j=0;
//        while(i <= text.length()-pattern.length()){
//            if (j<0 || text.charAt(i) == pattern.charAt(j)){
//                i++;
//                j++;
//                if (j==pattern.length()){
//                    return i - j;
//                }
//            }
//        }
//        return -1;
//    }

    // 构建next数组
    public int[] buildNext(String str){
        int[] next = new int[str.length()];
        next[0] = -1;
        // 双指针, i指向当前后缀尾部, j指向前缀尾部
        int i = 1;
        int j = 0;
        while(i<str.length()){
            if (str.charAt(i) == str.charAt(j) || j<0){
                i++;
                j++;
                next[i-1]=j;
            }else {
                j = next[j];
            }
        }
        return next;
    }


    /**
     * Leetcode官方提供的算法,不易理解、不简洁
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            // 这一步的作用是 判断跳出while循环的条件: 若果是j<=0, j不自增; 是相等, 则j++
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * KMP 字符串匹配:
     *   当谈到字符串匹配算法时，KMP（Knuth-Morris-Pratt）算法是一个非常常见和高效的算法之一。
     *   在KMP算法中，next数组（也称为最长公共前后缀数组）扮演着重要的角色。
     * next数组用于确定在匹配过程中，当出现不匹配时应该如何移动模式串（待匹配串）的指针，以避免不必要的比较。
     * 它存储了模式串中每个位置上前缀字符串的最长相等前后缀的长度。
     *
     * 下面是next数组的计算方法：
     *   首先，next数组的长度与模式串的长度相同，并且next[0] = -1，next[1] = 0。
     *   然后，我们从位置2开始逐个计算next数组的值。对于位置i，我们需要找到模式串中从位置0到i-1的子串的最长相等前后缀。
     *   如果模式串中位置i-1的字符与位置next[i-1]的字符相等，那么next[i] = next[i-1] + 1。
     * 如果模式串中位置i-1的字符与位置next[i-1]的字符不相等，我们需要回溯。我们将next[i-1]的值作为新的索引，
     *   继续比较模式串中位置next[i-1]的字符和当前字符是否相等，直到找到相等的字符或者回溯到了起始位置0。
     *   如果找到相等的字符，那么next[i]就等于回溯后的索引值加1；如果回溯到了起始位置0仍然没有找到相等的字符，那么next[i]就等于0。
     *   通过计算得到的next数组可以帮助我们在匹配过程中高效地移动模式串的指针，从而减少不必要的比较操作，提高算法的效率。
     *
     * 算出next数组后:
     *   例如，假设当前模式串的指针位于位置i，文本串的指针位于位置j，
     *   而模式串中的字符pattern[i]与文本串中的字符text[j]不匹配。
     *   根据next数组，我们可以知道在位置i之前的模式串子串中存在一个最长相等前后缀，其长度为next[i]。
     *   这意味着我们可以将模式串的指针移动到位置next[i]，然后继续与文本串中的字符进行比较。
     * 通过利用next数组，KMP算法避免了在模式串与文本串中进行重复的比较操作，从而减少了算法的时间复杂度。
     */
}
