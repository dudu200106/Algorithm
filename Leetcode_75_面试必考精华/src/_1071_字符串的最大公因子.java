public class _1071_字符串的最大公因子 {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1+str2).equals(str2+str1)){
            int len = gcb(str1.length(), str2.length());
            return str1.substring(0, len);
        }
        return "";
    }

    public int gcb(int a, int b){
        if (a<b){
            int temp = a;
            a=b;
            b=temp;
        }
        return b==0? a : gcb(b, a%b);
    }
}
