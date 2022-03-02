package dynamicPlanning_动态规划;
import java.util.Scanner;

public class Main {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m= sc.nextInt();
        String str1=sc.next();
        String str2=sc.next();

        System.out.println(solusion(n,m,str1,str2));
    }

    static int solusion(int n,int m,String s1, String s2){
        int len1=n;
        int len2=m;
        int[][] dp=new int[len1+1][len2+1];

        /*可以不用初始化数据,递推dp数组的时候从1开始就行
        //初始化第一行(),s1的字符代表行
        int flag=0; //代表还没找到相同字符
        for (int i = 1; i <= len2; i++) {
            if (flag==1){
                dp[1][i]=1;
            }
            else if (s1.charAt(0)==s2.charAt(i-1)) {
                flag=1;
                dp[1][i] = 1;
            }
            else
                dp[1][i]=0;
        }
        //初始化第一列(),s2字符为列
        flag=0;
        for (int j = 1; j <= len1; j++) {
            if (flag==1){
                dp[j][1]=1;
            }
            else if (s1.charAt(j-1)==s2.charAt(0)) {
                flag=1;
                dp[j][1] = 1;
            }
            else
                dp[j][1]=0;
        }*/

        //开始递推
        //dp选择与择优:i和j分别代表了两个字符串的范围
        for (int i = 1; i <= len1; i++) { //s1
            for (int j = 1; j <= len2; j++) { //s2
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1; //新增了俩相等字符,直接在原状态dp值上+1,它肯定是左上角三个值最大的
                }
                else { //俩新增字符不同,就找max( dp[i-1][j],dp[i][j-1] )
                    int maxOfLeftUp=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = maxOfLeftUp;
                }
            }
        }
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        return dp[len1][len2];
    }
}
