package string_字符串;

/**
 * 旋转词:指的是两个字符串符合"从左到右按照顺序,将首部字符旋转插到末尾"规律字符串--ABCDE <->CDEAB
 * 变形词:打乱顺序,长度一致的两个字符串--ABCDE <->BCDAE
 *
 * 设计分别实现旋转词和变形词的方法:
 */
public class 旋转词和变形词_B站 {
    public static void main(String[] args) {
        String str1="abcd";
        String str2="cdeab";
        String str3="acbd";
        System.out.println(revolve(str1,str2));
        System.out.println(revolve(str3,str2));

        System.out.println(transform(str1,str2));
        System.out.println(transform(str1,str3));

        System.out.println("注: 正确答案应该是:\n true\n false\n false\n true");
    }

    /*str1能不能包含在str2的旋转词中,如ABCD能不能由CDEAB的字符旋转得到
    -->将两个原字符串str2拼起来,如CDEAB+CDEAB=CDE ABCD EAB,判断其中是否包含ABCD(contain目标字符串str1)*/
    static boolean revolve(String str1,String str2){
        String temp=str2+str2;
        if (temp.contains(str1))
            return true;
        else
            return false;
    }

    static boolean transform(String str1, String str2){
        int[] help =new int[256];

        for (int i = 0; i < str1.length(); i++) {
            char c=str1.charAt(i);
            help[c]=1;
        }

        for (int i = 0; i < str2.length(); i++) {
            char c=str2.charAt(i);
            if (help[c]==0)
                return false;
        }
        return true;
    }
}
