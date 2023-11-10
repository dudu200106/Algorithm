import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public String decodeString2(String s) {
        LinkedList<StringBuilder> stack = new LinkedList<>();

        StringBuilder  cur = new StringBuilder();
        int num = 0;
        for (int i = s.length()-1; i >=0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                cur.insert(0,ch);
            }else if (ch==']'){
                stack.add(cur);
                cur = new StringBuilder();
            }else if (ch=='['){
                if(Character.isDigit(s.charAt(i-1))){
                    int j=i;
                    while(j >0 && Character.isDigit(s.charAt(j-1))){
                        j--;
                    }
                    num = Integer.valueOf(s.substring(j, i));
                }else{
                    num=1;
                }
                String temp = cur.toString();
                for (int k = 1; k < num; k++) {
                    cur.append(temp);
                }
                cur.append(stack.getLast());
                stack.removeLast();
            }
        }
        return cur.toString();
    }


}
