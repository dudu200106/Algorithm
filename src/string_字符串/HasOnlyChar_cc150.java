package string_字符串;
/*
    判定一个字符串里的所有字符唯一--只出现过一次
*/
public class HasOnlyChar_cc150 {
    public static void main(String[] args) {
        String str="abcdefga";
        int[] help=new int[256]; //ASCII码 出现记录数组
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (help[c]==1) {
                System.out.println("false");
                System.exit(0);
            }
            else
                help[c]=1;
        }
        System.out.println("true");
    }
}
