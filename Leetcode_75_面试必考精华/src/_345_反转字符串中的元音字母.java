import java.util.ArrayList;
import java.util.List;

public class _345_反转字符串中的元音字母 {
    /**
     * 最简单的方法
     * 用两个辅助空间记录元音字符和他们所在的下吧, 然后逆向遍历替换就行了
     *
     */
    public String reverseVowels_1(String s) {
        int len = s.length();
        List<Integer> remenber = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if ("aeiouAEIOU".contains(s.substring(i, i+1))){
                remenber.add(i);
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
        StringBuilder new_str = new StringBuilder(s);
        int new_len = sb.length();
        for (int j = new_len-1; j >=0; j--) {
            int ind = remenber.get(new_len-j-1);
            char ch = sb.charAt(j);
            new_str.replace(ind,ind+1, ch+"");
        }
        System.out.println(new_str);
        return new_str.toString();
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            while (left<right && !check(s, left)){
                left++;
            }
            while (left<right && !check(s, right)){
                right--;
            }
            if (left<right) {
                String temp = s.substring(right,right+1);
                sb.replace(right, right + 1, s.substring(left,left+1));
                sb.replace(left, left + 1, temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }

    public boolean check(String source, int ind){
        return "aeiouAEIOU".contains(source.substring(ind, ind+1));
    }
}
