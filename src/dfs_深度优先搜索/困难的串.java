package dfs_深度优先搜索;

/**
 * 问题描述:如果一个字符串包含两个相邻的重复子串，则称它为容易的串，其他串称为困难的串,
 * 如:BB，ABCDACABCAB,ABCDABCD都是容易的，A,AB,ABA,D,DC,AABDB,CBABCBA都是困难的。

 输入正整数n,L，输出由字母表前L个大写英文字母组成的，字典序第n小的困难的串。
 例如，当L=3时，前7个困难的串分别为:
 A,AB,ABA,ABAC,ABACA,ABACAB,ABACABA
 n指定为4的话,输出ABAC...

 思路: 构造一棵多叉树, 每层可转移的平行状态(A,B,C...)顺着字典序下来, 并先对每个进行判断剪枝;
        其中设一静态常量cnt进行计数,到cnt=n时打印出此可行解(困难的串)
 */
public class 困难的串 {

    static int cnt=0;
    static int n;
    static int l; //字母表长度
    public static void main(String[] args) {
        n = 6;
        l = 3;
        dfs("");
    }

    /**
     * 模板:
     *  dfs(prefix : String)
     *      for character from 'A' to 'A'+l //从字母'A'到 'A'+l
     *          if(isHardStr(prefix, character))
     *              dfs(prefix + character)
     *              count++;
     *
     *  isHardStr(String prefix, char i){
     *
     *  }
     *
     * @param prefix
     */
    static void dfs(String prefix){
        if(cnt==n){
            System.out.println(prefix);
            System.exit(0);
        }

        for (char i = 'A'; i <'A'+l ; i++) {
            if (checkIsHard(prefix,i)){
                cnt++;
                dfs(prefix+i);
            }
        }
    }

    static boolean checkIsHard(String prefix, char ch){
        int count = 0;//截取的宽度
        for (int j = prefix.length() - 1; j >= 0; j -= 2) {
            final String s1 = prefix.substring(j, j + count + 1);
            final String s2 = prefix.substring(j + count + 1) + ch;
            if (s1.equals(s2))
                return false;
            count++;
        }
        return true;
    }
}
