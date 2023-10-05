package stringMatch_字符串匹配;

import java.util.Arrays;

/**
 * Sunday的策略是:
 *      当有字符失配时, 比较模式串对应,母串匹配位置的下一位字符c,若是从未出现在模式串中,则模式串右移p.length+1位;
 *      否则就找到模式串只最右出现字符c的位置i, 向右移动p.length-i位, 让他与末尾下一位字符对齐
 * Sunday的时间复杂度: 平均是O(n/m)以下(亚线性,比线性小), 最坏情况是O(n*m)的--所以Sunday算法适用于随机字符串的匹配
 * 与KMP算法相比: KMP算法被认为是实用性不是最高的算法, 因为他的平均和最坏情况时间复杂度虽然都是线性的,但在匹配随机字符串中, 哪有这么多的最坏情况
 */
public class Sunday {
    public static void main(String[] args) {
        String sc = "babababcbabababb";
        int index = match_sun(sc,"bababb");
        System.out.println(index);
    }

    static int match_sun(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if (lenP > lenS) return -1;
        if (lenP == 0) return -1;

        //step.1 生成一个模式串的偏移表--shift[MAX_ACCSI], 代表若下一个字符是i的偏移量
        int[] shift = new int[256]; //扩展ASSCI码的长度
        Arrays.fill(shift,lenP+1);

        for (int i = 0; i < lenP; i++) {
            shift[p.charAt(i)] = lenP - i;
        }

        //step.2 开始遍历
        int sc = 0; //s开始的下标
        while (sc <= lenS - lenP) {

            int j=0; //p的下标,每次都从0开始
            /* 要么匹配成功,尾部+1; 要么失配,比对目标串尾下一个字符是否在目标串中*/
            while(s.charAt(sc+j)==p.charAt(j)){
                j++;
                if (j>=lenP) {
                    System.out.println("yes");
                    return sc;
                }
            }
            sc+=shift[s.charAt(sc+lenP)];

        }
        System.out.println("no");
        return -1;
    }
}
