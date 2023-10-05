package greedy_贪心;

/**
 * 字典序: 比较两个字符串的方法顺序
 * 比较顺序从左到右,由高到低(类似十进制数值的比较,进位更小的越小),第一个位置的字符串更小的最小,相等则继续比较第二个...重复至比较出更小的字符
 *
 * 最小字典序的问题可以利用字符串比较的原理, 当遇到收尾字符相同时, 比较剩余串和他的翻转串那个更小(这里就像考虑了后效性),将更小的首字符加入
 */
public class 最小字典序_挑战程序竞赛 {
    public static void main(String[] args) {
        String s="ACDBCB";
        StringBuilder t=new StringBuilder();
        int a=0, b=s.length()-1;
        while(a<=b){
            if (s.charAt(a)>s.charAt(b))
                t.append(s.charAt(b--));
            else if (s.charAt(a)<s.charAt(b))
                t.append(s.charAt(a++));
            else { //比较剩下没加入进去的子串S,和他的翻转串S'大小
                String s1=s.substring(a,b+1);
                StringBuilder sb=new StringBuilder(s1);
                String s2= sb.reverse().toString();
                if (s1.compareTo(s2)<0){
                    t.append(s.charAt(a++));
                }
                else
                    t.append(s.charAt(b--));
            }
        }
        System.out.println(t.toString());
    }
}
