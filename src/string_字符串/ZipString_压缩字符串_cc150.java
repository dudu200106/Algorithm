package string_字符串;

/**
 * 实现基本的字符串压缩功能:如"aabcccccaaa"压缩后会变成"a2b1c5a3",若是压缩后长度没有变短则返回原字符串
 */

public class ZipString_压缩字符串_cc150 {
    public static void main(String[] args) {
        String s="aabcccccaaa";
        System.out.println(zip(s));
    }

    public static String zip(String str){
        StringBuilder sb=new StringBuilder();
        char last=str.charAt(0);
        int count=1; //对每个重复字符计数
        for (int i = 1; i < str.length(); i++) {
            if (last==str.charAt(i)){
                count++;
            }
            else { //不相等,结算
                sb.append(last).append(count);
                last = str.charAt(i); //
                count=1; //计数刷新
            }
        }
        sb.append(last).append(count);//返回前加入最后的字符及计数

        if (sb.length()>=str.length())
            return str;
        else return sb.toString();
    }
}
