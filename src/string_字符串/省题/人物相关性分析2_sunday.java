package string_字符串.省题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 人物相关性分析2_sunday {
    public static void main(String[] args) {
        String str="This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
//        String str="This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
        int n=20;
        String a="Alice";
        String b="Bob";

        List<Integer> Alice= match_sun(str,a);
        List<Integer> Bob= match_sun(str,b);
        System.out.println(Alice);
        System.out.println(Bob);

        //两两距离组合相减, 判断之间的距离是否小于n
        int ans = 0;
        for (int i = 0; i < Alice.size(); i++) {
            for (int j = 0; j < Bob.size(); j++) {
                int dist=Alice.get(i)-Bob.get(j);
                if((dist<n && dist>0) || (-dist<n&&dist<0)) //距离的绝对数
                    ans++;
            }
        }
        System.out.println(ans);
    }

    static ArrayList<Integer> match_sun(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        ArrayList<Integer> ans =new ArrayList<Integer>();

        if (lenP > lenS) return new ArrayList<>();
        if (lenP == 0) return new ArrayList<>();

        //1. 生成一个模式串的偏移表--shift[MAX_ACCSI], 代表若下一个字符是i的偏移量
        int[] shift = new int[256]; //扩展ASSCI码的长度
        Arrays.fill(shift,lenP+1);

        for (int i = 0; i < lenP; i++) {
            shift[p.charAt(i)] = lenP - i;
        }

        int sc = 0; //s开始的下标
        while (sc <= lenS - lenP) {
            int j=0; //p的下标
            while(s.charAt(sc+j)==p.charAt(j)){
                j++;
                if (j>=lenP ) {
                    if (check(s,sc,sc+lenP-1)) {
                        ans.add(sc);
                    }
                    break;
                }
            }
            sc+=shift[s.charAt(sc+lenP)];
        }
        return ans;
    }

    static boolean check(String str, int b, int e){
        if (b>0)
            if (str.charAt(b - 1) != ' ')
                return false;
        if (e<str.length()-1)
            if (str.charAt(e + 1) != ' ' && str.charAt(e + 1) != '.')
                return false;

        return true;
    }
}
