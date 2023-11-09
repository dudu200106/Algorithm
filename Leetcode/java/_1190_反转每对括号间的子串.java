import java.util.LinkedList;

public class _1190_反转每对括号间的子串 {

    public String reverseParentheses(String s) {
        LinkedList<StringBuilder> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='('){
                stack.add(sb); // 入栈等待, 翻转出栈(等待处理)
                sb = new StringBuilder(); // 清空
            }else if (ch==')'){
                sb.reverse();
                sb.insert(0,stack.getLast());
                stack.removeLast();
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
