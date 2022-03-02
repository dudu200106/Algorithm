package string_字符串;

import java.util.HashMap;

/**
 * 询问两个串是否是由相同的字符集生成 (可以引申到"有没有重复出现的字符","是不是重拍字符--变形词,长度一样,每个字符和数量也一样")
 * 1.限制串的组成的字符类型是ASCII,空间换时间,开辟128/256个空间的数组储存(增强的ASCII有256位字符);
 * 2.若没有规定的话, 就用O(N^2)级别的暴力解法也行,比较通用--两个for循环+hasmap,看每个字符在上个字符集里都能不能get到
 */

public class HasSameStrSet_相同字符集_B站 {
    public static void main(String[] args) {
        boolean res = check("abcde", "deabccadcd");
        System.out.println(res);
        System.out.println(check("abcdefg","hjkimn"));
        System.out.println(check1("abcde", "deabccadcd"));
        System.out.println(check1("abcdefg","hjkimn"));

    }

    static boolean check(String str1,String str2){
        int[] helper=new int[256];

        for (int i = 0; i < str1.length(); i++) {
            int c=str1.charAt(i);
            helper[c]=1; //标记1记录出现过这个字符
        }

        for (int j = 0; j < str2.length(); j++) {
            int c=str2.charAt(j);
            if (helper[c]==0)
                return false;
        }
        return true;
    }

    /*用hashMap*/
    static Boolean check1(String str1, String str2){
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            Character c=str1.charAt(i);
            if (map.get(c)==null){
                map.put(c,1);
            }
        }

        for (int j = 0; j < str2.length(); j++) {
            Character c=str2.charAt(j);
            if (map.get(c)==null)
                return false;
        }
        return true;
    }
}
