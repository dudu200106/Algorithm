/**
 * @author Sean Du
 * @version 1.0.0
 * @date 2024/03/23
 */


/*
    偏爱的字符

题目描述：
小李天生偏爱一些字符，对于一个字符串，他总是想把字符串中的字符变成他偏爱的那些字符。
如果字符串中某个字符不是他所偏爱的字符，称为非偏爱字符，那么他会将该非偏爱字符替换为字符串中距离该字符最近的一个偏爱的字符。
这里的距离定义即为字符在字符串中的对应下标之差的绝对值。如果有不止一个偏爱的字符距离非偏爱字符最近，
那么小李会选择最左边的那个偏爱字符来替换该非偏爱字符，这样就保证了替换后的字符串是唯一的。
小李的所有替换操作是同时进行的。
假定小李有m个偏爱的字符，依次为c1,c2...cm，当小李看到一个长度为n的字符串s时，请你输出小李在进行全部替换操作后形成的字符串。

输入描述
第一行输入两个正整数n，m。
接下来一行输入m个字符c1,c2...cm，每两个字符之间用空格隔开，表示小李偏爱的字符。
接下来一行输入一个字符串s。

1≤n≤100000，1≤m≤26，保证题目中所有的字符均为大写字符，小李偏爱的字符互不相同，且偏爱字符至少出现一次。

输出描述
输出一行字符串，表示小李将给定的字符串s替换后形成的字符串。
样例输入
12 4
Z G B A
ZQWEGRTBYAAI

样例输出
ZZZGGGBBBAAA

提示
字符Q为非偏爱字符，且偏爱字符Z距离它最近，所以替换成Z；同理E距离G最近，替换成G；
对于字符W，偏爱字符Z和G与其距离相同，所以替换为左边的Z；
对于字符 I ，右边没有偏爱字符，左边第一个偏爱字符是A，所以替换成字符A。
同一个偏爱字符可能会在字符串中出现多次。

 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 这一题数据量是100000，那么时间复杂度只能是nlogn, 最后发现可以用二分
 * 将字符串中的偏爱字符按顺序记住就行, 最后遍历查找非偏爱字符在哪两个区间之中, 取最短距离
 */

public class 小米笔试_偏爱字符 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        String love = sc.nextLine();
        String str = sc.nextLine();
        System.out.println(solve(love, str));
    }

    public static String solve(String love, String str){
        StringBuilder sb = new StringBuilder(str);
        Set<String> loveSet = new HashSet<>();
        loveSet.addAll(Arrays.asList(love.split("")));
        List<Integer> loveIndexList = new ArrayList<>();
        loveIndexList.add(-1);
        for (int i = 0; i < str.length(); i++) {
            String ss = str.substring(i, i+1);
            if (loveSet.contains(ss)){
                loveIndexList.add(i);
            }
        }
        loveIndexList.add(str.length());
        for (int i = 0; i < sb.length(); i++) {
            if (!loveSet.contains(str.substring(i, i+1))){
                int loveStrIndex = find(loveIndexList, i);
                sb.replace(i, i+1, sb.charAt(loveStrIndex)+"");
            }
        }
        return sb.toString();
    }

    public static int find(List<Integer> list, int ind){
        int l=0, r=list.size()-1;
        while (r>l){
            if (r-l==1)
                break;
            int mid = (l+r)>>1;
            if (list.get(mid)>=ind){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        if (list.get(l)==-1 )
            return r;
        if (list.get(r)==list.get(list.size()-1))
            return l;
        return Math.abs(list.get(r)-ind) < Math.abs(ind-list.get(l)) ? r : l;
    }
}
