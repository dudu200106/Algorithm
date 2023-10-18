import java.util.HashMap;
import java.util.Map;

public class _1657_确定两个字符串是否接近 {
    Map<Integer, Integer> m1 = new HashMap<>();
    Map<Integer, Integer> m2 = new HashMap<>();
    public boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length())
            return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            a1[word1.charAt(i)-'a']++;
            a2[word2.charAt(i)-'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if ((a1[j]==0&&a2[j]!=0) || (a2[j]==0&&a1[j]!=0))
                return false;
            if (a1[j]!=0){ // key存放的是元素的个数, value是有key个元素的字符有几个
                m1.put(a1[j], m1.getOrDefault(a1[j],0)+1);
            }
            if (a2[j]!=0){
                m2.put(a2[j], m2.getOrDefault(a2[j],0)+1);
            }
        }
        for (int ele: m1.keySet()) {
            if (m1.get(ele) != m2.get(ele)){
                return false;
            }
        }
        return true;
    }
}
