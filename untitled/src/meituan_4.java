import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class meituan_4 {
    static int n ;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.next();
        }
        for (String str : strs[0].split("")) {
            dfs(1, str, strs);
        }
        System.out.println(res);
    }

    static int res = 0;
    public static void dfs(int cur, String preCh, String[] strs) {
        if (cur == n) {
            res = (1 + res) % 100000007;
            return;
        }
        HashSet<String> set1 = new HashSet<>();
        set1.addAll(Arrays.asList(strs[cur].split("")));
        if (set1.contains(preCh)) {
            set1.remove(preCh);
        }
        for (String ss : set1) {
            dfs(cur + 1, ss, strs);
        }
    }
}
