package dfs_深度优先搜索;

/**
 * 问题描述:如果一个字符串包含两个相邻的重复子串，则称它为容易的串，其他串称为困难的串,
 * 如:BB，ABCDACABCAB,ABCDABCD都是容易的，A,AB,ABA,D,DC,ABDAB,CBABCBA都是困难的。

 输入正整数n,L，输出由前L个字符(大写英文字母)组成的，字典序第n小的困难的串。
 例如，当L=3时，前7个困难的串分别为:
 A,AB,ABA,ABAC,ABACA,ABACAB,ABACABA
 n指定为4的话,输出ABAC

 思路: 构造一棵多叉树, 每层可转移的平行状态(A,B,C...)顺着字典序下来, 并先对每个进行判断剪枝;
        其中设一静态常量cnt进行计数,到cnt=n时打印出此可行解(困难的串)
 */
public class 困难的串 {
    static int cnt=0;
    public static void main(String[] args) {
        int n = 6;
        int l = 3;
        dfs(n, l, "");
        // isHard("0123020120",1);
    }

    static void dfs(int n, int l, String prefix){
        if(cnt==n){
            System.out.println(prefix);
            System.exit(0);
        }
        for (char i = 'A'; i <'A'+l ; i++) {
            if (checkIsHard(prefix,i)){
                cnt++;
                dfs(n,l,prefix+i);
            }
        }
    }

    static boolean checkIsHard(String str, char a){
        int lent=1; //截取前缀长度
        for (int i = str.length(); i-lent >=0 ; i--) {//比较
            String before = str.substring(i - lent, i); //右边不包括
            String after = str.substring(i) + a;
            /*System.out.println("lent: " + lent); //测试截取长度和前后子字符串
            System.out.println(before + " " + after);*/
            if (before.equals(after)) {
                return false;
            }
            lent++;
        }
        return true;
    }
}
