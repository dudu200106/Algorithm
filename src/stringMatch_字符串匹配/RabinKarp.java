package stringMatch_字符串匹配;

/**
 * 滚动hash法
 * 对目标字符串按d进制求值,mod h 取余作为其hash
 * 对源串,依次求出m个字符的hash,保存在数组中(滚动计算)
 * 匹配时,只需比对目标串的hash值和预存的源串的hash值表
 */
public class RabinKarp {

    public static void main(String[] args) {
        String s = "ABABABA"; //母串--parent
        String p = "ABA"; //模式串--pattern
        match1( s,p);
        match2(s,p);
    }

    /**
     *
     * @param s parent
     * @param p pattern
     *
     * 朴素的暴力解法:
     *          以每一个母串字符为首部,然后扫描首部之后的n-1个位;
     *          若是失配, 首部后移;
     *          若匹配成功,在则输出匹配的母串首地址
     */
    static void match1(String s,String p) { //O(M*N)
        int pLen = p.length();
        int sLen = s.length();

        for (int i = 0; i < s.length() - sLen % pLen; i++) { //O(m)
            int pi = 0; //p指针
            int si = i; //s指针
            for (int j = 0; j < pLen; j++) {
                char s_c = s.charAt(i + j);
                char p_c = p.charAt(j);
                if (s_c != p_c) {
                    break;
                }
                if (j == pLen - 1)
                    System.out.println("match:" + i);
            }
        }
    }

    static void match2(String s, String p){
        long[] hashOfS=hash(s,p.length());
        System.out.println("Hash value of pattern string： " +hashOfS);
        long hashOfP=hash(p);
        for (int i = 0; i < hashOfS.length; i++) {
            if (hashOfS[i]==hashOfP){
                System.out.println("match:" + i);
            }
        }
    }

    final static int Seed=31; //使用一个质数作为计算哈希值的种子
    /**
     * 用以和母串比较哈希值, 哈希值相同就说明:以s[i]开头的母串子串匹配p成功
     * 但复杂度没有降低,仍然是O(m*n)
     * @param str
     * @return 长度为n的p字符串哈希值
     */
    static long hash(String str){
        long res=0;
        for (int i = 0; i < str.length(); i++) {
            res=res*Seed + str.charAt(i);
        }
        return res % Long.MAX_VALUE; //哈希值可能过大,防止溢出返回余数就行
    }

    /**
     * 滚动哈希数组
     *      --相当于预处理简化问题,只需比较各个子串的哈希值就行了;
     *      使用滚动哈希,就不用每次计算子串的时候,要从头开始计算N次,直接
     * 以每个母串字符为首部,长度为n(P的长度)的字符串哈希值数组
     * @return 每个长度为n的字符串的哈希数组
     * 注: 可能会存在哈希冲突, 但是可能性极小,竞赛几乎不会遇到
     */
    static long[] hash(String s, int n){
        long[] res=new long[s.length()-n+1];

        res[0]=hash(s.substring(0,n));
        for (int i = n; i <s.length() ; i++) {
            char newCh =s.charAt(i);
            char oldCh =s.charAt(i-n);
            long val=(res[i-n]*Seed+newCh) - ex2(Seed,n)*oldCh;
            res[i-n+1]=val;
        }
        return res;
    }

    /*快速幂*/
    public static long ex2(long n, long m) {
        if (n == 0) return 1;
        long pingFangShu = n; //n 的 1 次方
        long result = 1;
        while (m != 0) {
            //遇1累乘现在的幂
            if ((m & 1) == 1)
                result *= pingFangShu;
            //每移位一次，幂累乘方一次
            pingFangShu = pingFangShu * pingFangShu;
            //右移一位
            m >>= 1;
        }
        return result;
    }
}
