package 省题备考;

import java.util.HashSet;
import java.util.Set;

/** 填空题
 * 一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成 的串。
 * 例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
 * 注意在计算时，只算本质不同的串的个数。请问，字符串0100110001010001 有多少个不同的非空子串？
 *
 *思路:
 *   就是把不同长度的子串放入hashSet去重罢了
 */
public class 不同子串_2019 {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        String s="0100110001010001";
        int len=1;
        while (len<=s.length()) {
            for (int i = 0; i+len <= s.length(); i++) {
                set.add(s.substring(i,i+len));
            }
            len++;
        }
        System.out.println(set.size());
    }
}
