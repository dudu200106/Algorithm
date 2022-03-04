package string_字符串.省题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 人物相关性分析_尺取法_2020JB {

    public static void main(String[] args) {
        String str="This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
        String[] s =str.split("\\ ");
        String[] p ={"Alice","Bob"};

        System.out.println(containAll(s,5,7));
        System.out.println(len(s,5,7));
        System.out.println(solve2(s,p,20));

        /*String word2=shift(s[7]);
        int index2=Arrays.binarySearch(p,word2);
        System.out.println(word2 +" "+ index2);*/
    }

    static int solve2(String[] s1, String[] keywords, int k){
        int cnt=0;

        int j=0; //上一个摘要的结尾,初始化为0

        for (int i = 0; i < s1.length; i++) {
            String word1=shift(s1[i]);
            int index= Arrays.binarySearch(keywords,word1);
            if (index<0){ //首部不符合,直接下一个
                System.out.println("i continue:" +i +" "+ j);
                continue;
            }
            else if (i>=j&&containAll(s1,i,j)){ //i>=j是防止移动首部时,越过尾部
                if (len(s1,i,j)<=k){ //计算Alice与Bob间有多少字符, 判断是否小于k
                    cnt++;
                }
                else
                    continue ;
            }

            //尾部
            if(j==0){ //若是找到第一个符合的首部,则尾部j下移到他的位置,方便继续往后移
                j=i;
            }
            while(j<s1.length){ //不断调整尾部直至符合匹配
                String word2=shift(s1[j]);
                int index2=Arrays.binarySearch(keywords,word2);
                if (index2<0){ //尾部在调整,若是连尾部的字符串都不包括在keywords里,直接continue,不用麻烦containAll
                    j++;
                    System.out.println("j continue:" +i +" "+ j);
                    continue ;
                }
                else if (containAll(s1,i,j)){
                    if (len(s1,i,j)<=k){ //计算Alice与Bob间有多少字符
                        cnt++;
                    }
                    else
                        break;
                }
                else
                {
                    j++;
                    continue;
                }
            }
        }
        return cnt;
    }

    /*用一个散列表装载每个关键词的个数--这里考虑到了同一个关键词可能有多个*/
    static boolean containAll(String[] s1, int begin, int end){
        String first =shift(s1[begin]);
        String last =shift(s1[end]);

        if(first.equals("Alice")&&last.equals("Bob"))
            return true;
        else if (first.equals("Bob")&&last.equals("Alice"))
            return true;
        else
            return false;
    }

    static int len(String[] s, int begin,int end){
        int res=1;
        for (int k = begin+1; k <end ; k++) {
            res+=(s[k].length()+1);
        }
        return res;
    }

    static String shift(String str){
        if (str.charAt(str.length()-1)=='.')
            str=str.substring(0,str.length()-1);
        return str;
    }
}
