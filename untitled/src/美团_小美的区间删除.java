import java.util.Scanner;

/**
 * @author Sean Du
 * @version 1.0.0
 * @date 2024/03/30
 */
public class 美团_小美的区间删除 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 构造前缀积、后缀积数组
        int[] preMul = new int[n];
        int[] subMul = new int[n];
        preMul[0] = arr[0];
        subMul[n-1] = arr[n-1];
        for (int j = 1; j < n; j++) {
            preMul[j] = preMul[j-1] * arr[j];
            subMul[n-j-1] = subMul[n-j] * arr[n-j-1];
        }
        // 固定滑动窗口取值
        int cnt =0;
        for (int len = 1; len < n; len++) {
            for (int m = 0; m <= n-len; m++) {
                int leftMult = m-1>=0 ? preMul[m-1] : 1;
                int rightMult = m+len<n ? subMul[m+len] : 1;
                if (check(leftMult*rightMult, k)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean check(int num, int k){
        for (int i = 0; i < k; i++) {
            if (num%10>0){
                return false;
            }
            num/=10;
        }
        return true;
    }
}
