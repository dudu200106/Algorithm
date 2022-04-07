package string_字符串;

public class HihoNum {

    static String solve(String s) {
        String hiho="hiho";
        int start_res=0;
        int end_res=0;
        int minLen=Integer.MAX_VALUE;
        int head=0;
        int row=0;

        while (head<s.length()-4) {
            //头
            char ch =s.charAt(head);
            if (hiho.indexOf(ch)>0) { //停下
                if (head>=row && containAll(s,head,row)) { //注意头不要超过尾部
                    if (row-head+1 < minLen) { //全部包含且更新了,那尾部继续往后也没有作用,
                        start_res=head;
                        end_res = row;
                        minLen = row-head+1;
                    }
                    head++;
                }

            }
            else {
                head++;
            }


            if (row==0) { //第一次的时候得将当前末尾提到头前
                row = head +1;
            }

            //尾部
            while (row<s.length()) {
                char ch1= s.charAt(row);
                if (hiho.indexOf(ch1)<0) {
                    row++;
                    continue;
                }
                else if (containAll(s, head, row)) {
                    if (head - row +1 < minLen) {
                        minLen =head-row +1;
                        start_res =head;
                        end_res =row;
                    }
                    break; //停下, 不用row++
                }
                row++;

            }

        }
        if (minLen==Integer.MAX_VALUE)
            return "";
        else
            return s.substring(start_res,end_res+1);

    }

    static boolean containAll(String s, int head, int row) {
        int h=0;
        int i=0;
        int o=0;

        for (int j = head; j <= row; j++) {
            if (s.charAt(i)=='h') h++;
            if (s.charAt(i)=='i') i++;
            if (s.charAt(i)=='o') o++;
        }
        if (h==2 && i==1 && o==1) {
            return true;
        }
        else {
            return false;
        }
    }


}
