
import java.util.HashMap;
import java.util.Scanner;

public class HJ20密码验证合格程序 {

    /*
        1. 暴力法, 直接一个一个地匹配, 时间复杂度O(n^2)
        2. 数据字典(哈希法), 遍历字符串,将所有长度为3的子字符串存入哈希表,
        利用哈希查找时间复杂度为O(1),总时间复杂度为O(n) --- 即遍历字符串,将子字符串存入哈希表的开销
     */

    public static void main(String[] args) {

        try(
                Scanner sc = new Scanner(System.in);
        ) {
            while (sc.hasNext()) {
                if (check(sc.nextLine())) {
                    System.out.println("OK");
                } else {
                    System.out.println("NG");
                }
            }
        }
    }

    public static boolean check(String str) {
        if(str.length()<9) // 少于九位数
            return false;

        int[] tp = new int[4];
        for (int i = 0; i < str.length(); i++) { // 密码类型少于3种
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                tp[0] = 1;
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                tp[1] = 1;
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                tp[2] = 1;
            else
                tp[3] = 1;
        }
        if (tp[0] + tp[1] + tp[2] + tp[3] < 3)
            return false;

        // 用数据字典(哈希法)判断是否有三位数及以上的公共子字符串
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 2; i++) {
            String sub = str.substring(i, i + 3);
            if (map.get(sub) != null) {
                return false;
            }
            map.put(sub, 1);
        }
        return true;
    }
}
