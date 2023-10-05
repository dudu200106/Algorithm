package string_字符串;

import java.util.Arrays;
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
        System.out.println("sovle1:");
        solve1(new String[]{"a", "b", "c", "seed", "h", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"c", "e"});
        solve1(new String[]{"a", "b", "c", "seed", "h", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"h"});
        System.out.println("solve2:");
        solve2(new String[]{"a", "b", "c", "seed", "h", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"c", "e"});
        solve2(new String[]{"a", "b", "c", "seed", "h", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"h"});
    }

    /*暴力揭发解法*/
    static void solve1(String[] s1, String[] s2){
        int res_l=Integer.MAX_VALUE;
        int left=-1;
        int right=-1;
        for (int i = 0; i < s1.length; i++) {
            for (int j = i; j < s1.length; j++) {
                if (containAll(s2,s1,i,j)){
                    if (j-i+1<res_l){
                        res_l=j-i+1;
                        left=i;
                        right=j;
                    }
                }
            }
        }
        print(s1,left,right);
    }

    /*尺取法*/
    /*尺取法的简单过程就是首->尾->首->尾......一直在交替;
    * 一般应用在找数组/字符串的最短区间上;
    * 原理步骤:
    *   1.先找到符合要求服首部;
    *   2.若是在首部check就符合(判断是否全部符合匹配要求),则比较历史最短并决策(更新/continue);
    *   3.若是2不符合,再不断后移尾部,然后 check,比较历史最短并决策(更新/break);
    *   4.重复1,2,3步骤,移动首部,调整尾部;
    *   5.若是如果尾部已经到头了,则只重复2,check直到结束;
    * 注释: 若尾部已经到头了,首部还要继续向后移动--可能会产生更短的摘要,且尾部移动不了也判断不了了,只能在首部也放置check判断*/
    static void solve2(String[] s1, String[] keywords){
        int minLen=Integer.MAX_VALUE;
        int begin_res=-1;
        int end_res=-1;

        int lastEnd=0; //上一个摘要的结尾,初始化为0

        for (int i = 0; i < s1.length; i++) {
            String word1=s1[i];
            int index= Arrays.binarySearch(keywords,word1);
            if (index>-1) { //首部字符符合, 停下

                if (i >= lastEnd && containAll(keywords, s1, i, lastEnd)) { //符合判定, 且头部不超过尾部
                    if (lastEnd - i + 1 >= minLen) //是否更新摘要长度 -- 你算长度不要忘记 =1;
                        continue;
                    minLen = lastEnd - i + 1;
                    begin_res = i;
                    end_res = lastEnd;
                }

                //尾部
                if (lastEnd == 0) { //第一次找到符合的首部,则尾部j下移到他的位置,方便继续往后移
                    lastEnd = i;
                }
                l1:
                while (lastEnd < s1.length) { //不断调整尾部直至符合匹配

                    String word2 = s1[lastEnd];
                    int index2 = Arrays.binarySearch(keywords, word2);
                    if (index2 < 0) { //尾部在调整,若是连尾部的字符串都不包括在keywords里,直接continue,不用麻烦containAll
                        lastEnd++;
                        continue l1;
                    } else if (containAll(keywords, s1, i, lastEnd)) {
                        if (lastEnd - i + 1 < minLen) {
                            minLen = lastEnd - i + 1;
                            begin_res = i;
                            end_res = lastEnd;
                        } else
                            break;
                    } else {
                        lastEnd++;
                        continue;
                    }

                }

            }

        }
        if (minLen==Integer.MAX_VALUE)
            print(s1,begin_res,end_res);

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
