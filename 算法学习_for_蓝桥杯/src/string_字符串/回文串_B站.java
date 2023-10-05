package string_字符串;

public class 回文串_B站 {
    public static void main(String[] args) {
        solve();
    }

    /*判断是不是回文字符串*/
    public static Boolean isPalind(String str){
        StringBuilder sb=new StringBuilder();
        sb.append(str).reverse();
        return str.equals(sb.toString());
    }

    /*输出所有四位数的回文串--如:1221,7447
    * 1.暴力解法,穷举所有四位数(1000~9999),并输出其中的回文串
    * 2.直接输出*/
    static void solve(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.println(i*1000+j*100+j*10+i);//直接输出符合的数据
            }
        }
    }
}
