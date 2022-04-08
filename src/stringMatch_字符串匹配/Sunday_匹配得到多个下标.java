package stringMatch_字符串匹配;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sunday_匹配得到多个下标 {

    public static void main(String[] args) {
        String str ="BobouwBob";
        match(str,"Bob");
        System.out.println(list);
    }

    static List<Integer> list = new ArrayList<>();

    static void match(String s,String p){
        int[] shift =new int[256];
        Arrays.fill(shift,p.length()+1);
        for (int i = 0; i < p.length(); i++) {
            shift[p.charAt(i)]=p.length()-i;
        }

        int sc =0; //模式串开始
        while (sc<=s.length()-p.length()){
            int pc=0;
            //检查可能匹配的区间
            while(s.charAt(sc+pc) == p.charAt(pc)){
                pc++;
                if (pc>=p.length()){
                    list.add(sc);
                    break ;
                }
            }
            //偏移表的作用: 失配和匹配,都对比末尾字符坐标,看下一个可能匹配的区间要移动几下
            int next =sc+p.length();
            if (next<s.length())
                sc+=shift[s.charAt(next)];
            else
                break;
        }
    }
}
