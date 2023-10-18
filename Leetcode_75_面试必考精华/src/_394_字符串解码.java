import java.util.LinkedList;

public class _394_字符串解码 {
    public String decodeString(String s) {
        LinkedList<StringBuilder> nums = new LinkedList<>();
        LinkedList<StringBuilder> beforeStr = new LinkedList<>();
        StringBuilder cur_num = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                cur_num.append(ch);
            } else if (Character.isLetter(ch)) {
                res.append(ch);
            } else if (ch == '[') {
                nums.addLast(cur_num);
                beforeStr.addLast(res);
                cur_num = new StringBuilder();
                res = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temps = new StringBuilder();
                String cnt = nums.removeLast().toString();
                int i = "".equals(cnt) ? 0 : Integer.valueOf(cnt);
                while (i > 0) {
                    temps.append(res);
                    i--;
                }
                temps.insert(0, beforeStr.removeLast());
                res = temps;
            }
        }
        return res.toString();
    }
}
