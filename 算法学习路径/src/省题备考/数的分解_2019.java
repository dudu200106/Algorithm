package 省题备考;

/** 填空题
 * 把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包 含数字 2 和 4，一共有多少种不同的分解方法？
 * 注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和 1001+1000+18 被视为同一种。
 *
 * 思路:
 *   这里其实就是种枚举与组合的变形, 且增加了一个check条件: 不含2和4
 *   1.三个数: s1<s2<s3----这样实现组合
 *   2.check(int num)----若含2和4 return FALSE
 */

public class 数的分解_2019 {
    public static void main(String[] args) {
        int cnt=0;
        for (int s1 = 1; s1 < 2019; s1++) {
            if (check(s1)){ //不含2和4
                for (int s2 = s1+1; s2 < 2019; s2++) {
                    if (check(s2)){
                        int s3= 2019-s1-s2;
                        if (check(s3)&&s3>s2) //组合实现的关键就是:不重复选取比目前数小的数字
                            cnt++;
                    }
                }
            }
        }
        System.out.println(check(20));
        System.out.println(check(104));
        System.out.println(cnt);
    }

    static boolean check(int num){
        String s=num + "";
        if (s.indexOf("2")!=-1)
            return false;
        else if (s.indexOf("4")!=-1)
            return false;
        else
            return true;
    }
}
