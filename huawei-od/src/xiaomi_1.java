import com.sun.xml.internal.org.jvnet.fastinfoset.sax.EncodingAlgorithmAttributes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sean Du
 * @version 1.0.0
 * @date 2024/03/22
 */
public class xiaomi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] m_arr = new int[m+n];
        int[] n_arr = new int[n];
        for (int i = 0; i < m; i++) {
            m_arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            n_arr[i] = sc.nextInt();
        }
        int p1 = m-1;
        int p2 = n-1;
        int ind = m+n-1;
        while(ind>=0){
            if (p2 < 0)
                break;
            if (p1 < 0){
                m_arr[ind--] = n_arr[p2--];
                continue;
            }
            m_arr[ind--] = m_arr[p1] > n_arr[p2] ? m_arr[p1--] : n_arr[p2--];
        }
        System.out.println(Arrays.toString(m_arr));
    }
}
