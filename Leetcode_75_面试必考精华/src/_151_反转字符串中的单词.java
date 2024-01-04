import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_反转字符串中的单词 {

    /**
     * 利用集合、字符串、数组的工具类进行单词反转
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> ss = Arrays.asList(s.split(" "));
        Collections.reverse(ss);
        s = String.join(" ", ss);
        return s;
    }

    /**
     * 双指针, 快捷一点
     * @param s
     * @return
     */
    public String reverseWords_1(String s) {
        int l = s.length()-1;
        int r = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while (l>=0){
            while (l>=0 && s.charAt(l) != ' '){
                l--;
            }
            sb.append(s.substring(l+1, r+1)).append(' ');
            while(l > 0 && s.charAt(l) == ' '){
                l--;
            }
            r=l;
        }
        return sb.toString().trim();
    }


    /**
     * 简单的逐个反转
     * @param s
     * @return
     */
    public String reverseWords_2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        System.out.println(Arrays.toString(ss));
        for (String str : ss) {
            if (str.equals(" ") || str.equals(""))
                continue;
            sb.insert(0, str.trim() + " ");
        }
        return sb.toString().trim();
    }
}
