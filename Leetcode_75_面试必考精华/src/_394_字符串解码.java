import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _394_字符串解码 {
    public String decodeString(String s) {
        LinkedList<StringBuilder> nums = new LinkedList<>();
        LinkedList<StringBuilder> strs = new LinkedList<>();
        StringBuilder n = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                n.append(ch);
            } else if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (ch == '[') {
                nums.addLast(n);
                strs.addLast(sb);
                n = new StringBuilder();
                sb = new StringBuilder();
            } else if (ch == ']') {
                String cnt_temp = nums.pollLast().toString();
                int cnt = "".equals(cnt_temp) ? 1 : Integer.valueOf(cnt_temp.toString());

                String str_temp = sb.toString();
                for (int i = 1; i < cnt; i++) {
                    sb.append(str_temp);
                }
                sb.insert(0, strs.pollLast());
            }
        }
        return sb.toString();
    }


    /**
     * 反序入栈, 贼难, 靠
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        LinkedList<StringBuilder> stack = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        StringBuilder  cur = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num.append(ch);
            }else if (num.length()>0){
                nums.addLast(Integer.valueOf(num.toString()));
                num = new StringBuilder();
            }
        }
        for (int i = s.length()-1; i >=0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                cur.insert(0,ch);
            }else if (ch==']'){
                stack.add(cur);
                cur = new StringBuilder();
            }else if (ch=='['){
                String temp = cur.toString();
                int m = nums.size() <=0 ? 1: nums.pollLast();
                for (int k = 1; k < m; k++) {
                    cur.append(temp);
                }
                cur.append(stack.getLast());
                stack.removeLast();
            }
        }
        return cur.toString();
    }

}
