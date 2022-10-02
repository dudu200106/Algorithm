package 省题备考;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入:
 20
 This is a story about Alice and Bob. Alice wants to send a private message to Bob.
 *
 */

/*
* 思路： 字符串匹配 + 组合 + 距离限制
*       将匹配出的所有Alice和Bob放入相应的集合中， 然后对他们进行组合
*
* */

public class 人物相关性分析2_sunday {
    public static void main(String[] args) {
        /*Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String str=in.nextLine();
        System.out.println(str);*/
        int n=20;
        String str="This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
        String a="Alice";
        String b="Bob";

        List<Integer> Alice= match_sun(str,a);
        List<Integer> Bob= match_sun(str,b);

        int ans = 0;
        for (int i = 0; i < Alice.size(); i++) {
            int l =0,r=-1;
            while(r+1 < Bob.size() && Alice.get(i) > Bob.get(r+1)  ) {
                r++;
            }
            while (l<=r && Alice.get(i) >Bob.get(l)+n+3  ) {
                l++;
            }
            ans += r-l+1;
        }

        for (int i = 0; i < Bob.size(); i++) {
            int l  =0,r=-1;
            while(r+1 < Alice.size() && Bob.get(i) > Alice.get(r+1)  ) {
                r++;
            }
            while (l<=r && Bob.get(i) >Alice.get(l)+n+5  ) {
                l++;
            }
            ans += r-l+1;
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
            int next =sc+p.length();
            if (next<s.length())
                sc+=shift[s.charAt(sc+lenP)];
            else
                break;

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
