public class _2390_从字符串中移除星号 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='*'){ // 如果等于*则出栈
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch); // 否则入栈
            }
        }
        return sb.toString();
    }
}
