import java.util.Arrays;

public class _151_反转字符串中的单词 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        System.out.println(Arrays.toString(ss));
        for (String str: ss){
            if (str.equals(" ") || str.equals(""))
                continue;
            sb.insert(0, str.trim()+" " );
        }
        return sb.toString().trim();
    }
}
