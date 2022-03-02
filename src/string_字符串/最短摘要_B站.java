package string_字符串;

import java.util.HashMap;
import java.util.Map;

/**
 *Alibaba笔试题：给定一段产品的英文描述，包含M个英文字母，每个英文单词以空格分隔，无其他标点符号；再给定N个英文单词关键字，请说明思路并编程实现方法
 *
 * String extractSummary(String description,String[] key words)
 *
 * 目标是找出此产品描述中包含N个关键字（每个关键词至少出现一次）的长度最短的子串，作为产品简介输出。（不限编程语言）20分。
 */

/*
    1.暴力法,遍历所有不同关键字开头的的文字,找到所有关键字后比较上一次最短子串长度
    2.尺取法,
*/
public class 最短摘要_B站 {

    public static void main(String[] args) {
        solve1(new String[]{"a", "b", "c", "seed", "h", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"c", "e"});
    }
    /*暴力揭发解法*/
    static void solve1(String[] s1, String[] s2){
        int res_l=Integer.MAX_VALUE;
        int left=-1;
        int right=-1;
        for (int i = 0; i < s1.length; i++) {
            for (int j = i+1; j < s1.length; j++) {
                if (containAll(s2,s1,i,j)){
                    if (j-i<res_l){
                        res_l=j-i;
                        left=i;
                        right=j;
                    }
                }
            }
        }
        print(s1,left,right);
    }

    /*尺取法*/
    static void solve2(String[] s1, String[] s2){

    }

    static void print(String[] str, int begin, int end){
        for (int i=begin; i<=end; i++){
            System.out.print(str[i]+" ");
        }
        System.out.println();
    }

    /*用一个散列表装载每个关键词的个数--这里考虑到了同一个关键词可能有多个*/
    static boolean containAll(String[] keywords,String[] s1, int begin, int end){
        Map<String,Integer> map1=new HashMap<>();
        //将所有关键词装入散列表
        for (int i = 0; i < keywords.length; i++) {
            String word=keywords[i];
            if (map1.get(word)==null)
                map1.put(word,1);
            else
                map1.put(word,map1.get(word)+1);
        }
        //将范围内的所有词装入另一个散列表
        Map<String, Integer> map2=new HashMap<>();
        for (int i = begin; i <= end; i++) {
            String word=s1[i];
            if (map2.get(word)==null)
                map2.put(word,1);
            else
                map2.put(word,map2.get(word)+1);
        }

        //判断map1和map2中的所有词是否数量一致
        for (Map.Entry<String, Integer> ele :  //Entry是Map里的内部类,包括一个键值对,访问使用getValue和getKey方法
        map1.entrySet()) { //entrySet返回所有键值对的集合
            if (map2.get(ele.getKey())==null || map2.get(ele.getKey())<ele.getValue()) {
                return false;
            }
        }
        return true;
    }


}
