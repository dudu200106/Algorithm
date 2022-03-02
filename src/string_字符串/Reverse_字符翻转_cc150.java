package string_字符串;

/**
 * 将字符串按字符翻转,如abcde 翻转成edcba
 *
    java里的String类型是不可变类型,所以要么使用javaAPI下,可变的字符串类型如StringBuffer,StringBuilder,他俩自带Reverse()方法;
    StringBufferhe StringBUilder的区别是:前者是线程安全的, 后者线程不安全,但执行性能快,若不考虑线程安全首先考虑StringBuilder;
    当然也可创建一个字符数组来储存翻转后的数据,再用String(charArr)的构造方法返回一个结果字符串
*/
public class Reverse_字符翻转_cc150 {
    public static void main(String[] args) {
        String t=new String("abcde");
        System.out.println(reverse(t));
        System.out.println(reverse2(t));
    }

    public static String reverse(String str){
        StringBuilder strBd=new StringBuilder(str);
        return strBd.reverse().toString();
    }

    public static String reverse2(String str){
        int len=str.length();
        char[] charArr=new char[len];
        for (int i = 0; i < len; i++) {
            charArr[i]=str.charAt(len-i-1);
        }
        return new String(charArr);
    }
}
