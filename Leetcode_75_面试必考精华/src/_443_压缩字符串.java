import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _443_压缩字符串 {


    // 以下方法不符合力扣的要求, 需用双指针, 要使得不能开辟
    public int compress2(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int write = 0, left = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read == chars.length-1 || chars[read] !=chars[read+1]){
                sb.append(chars[write]);
                int len = read - write +1;
                if (len > 1){
                    sb.append(len);
                }
                write=read+1;
                read++;
            }
        }
        System.out.println(sb);
        return sb.length();
    }

    public int compress(char[] chars) {
        int write =0;
        int read = 0, left = 0;
        while (left< chars.length) {
            read = left;
            while (read== chars.length-1 || chars[read] != chars[read+1])
                read++;
            chars[write++] = chars[left];
            int len = read - left +1;
            if (len>1) {
                char[] str = (len+"").toCharArray();
                for (char ch: str) {
                    chars[write++] = ch;
                }
            }
            left = read+1;
        }
        return write;
    }

}
