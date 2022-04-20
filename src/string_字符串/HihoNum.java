package string_字符串;

public class HihoNum {
    public static void main(String[] args) {
        String str ="ho99ih000hooih";
        System.out.println(solve(str));
    }

    static String solve(String s) {
        String hiho="hiho";
        int start_res=0;
        int end_res=0;
        int minLen=Integer.MAX_VALUE;
        int head=0;
        int row=0;

        while (head<=s.length()-4) {
            //头
            char ch =s.charAt(head);
            if (hiho.indexOf(ch)>=0) { //找到有用的字符,停下

                //这一题头部正好不用判定了 -- 头部判定的作用体会在row==s.length时, head还得继续滑动-->最短摘要

                if (row == 0) { //第一次移动首部,得将当前末尾提到前面来
                    row = head;
                }

                //尾部移到符合判定的有用字符
                while (row < s.length()) {
                    char cr = s.charAt(row);
                    if (hiho.indexOf(cr) >= 0) { //有用

                        if (containAll(s, head, row)) { //符合判定
                            if (check(s,head,row) && row - head + 1 < minLen) {
                                minLen = row - head + 1;
                                start_res = head;
                                end_res = row;
                            }
                            break; //有用且符合判定, row停下
                        }
                        else
                            row++; //有用 && 不符合判定, 窗口尾部滑动
                    }
                    else
                        row++; //没有用, 窗口尾部滑动
                }

            }
            head++;

        }

        if (minLen==Integer.MAX_VALUE){ //未匹配到模式串
            System.out.println(start_res + " " + end_res);
            return "";
        }
        else {
            System.out.println(start_res + " " + end_res);
            return s.substring(start_res, end_res + 1);
        }

    }

    static boolean containAll(String s, int head, int row) {
        int h=0;
        int i=0;
        int o=0;

        for (int j = head; j <= row; j++) {
            if (s.charAt(j)=='h') h++;
            if (s.charAt(j)=='i') i++;
            if (s.charAt(j)=='o') o++;
        }
        if (h>=2 && i>=1 && o>=1)
            return true;
        else
            return false;
    }

    static boolean check(String s, int head, int row){
        int h=0;
        int i=0;
        int o=0;

        for (int j = head; j <= row; j++) {
            if (s.charAt(j)=='h') h++;
            if (s.charAt(j)=='i') i++;
            if (s.charAt(j)=='o') o++;
        }
        if (h==2 && i==1 && o==1) {
            return true;
        }
        else {
            return false;
        }
    }


}
