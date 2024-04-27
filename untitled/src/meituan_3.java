import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sean Du
 * @version 1.0.0
 * @date 2024/04/06
 */
public class meituan_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long[] arr1 = new long[n-1];
        long[] arr2 = new long[n-1];
        for (int i = 0; i < n-1; i++) {
            arr1[i] = Long.parseLong(sc.next());
        }
        for (int i = 0; i < n-1; i++) {
            arr2[i] = Long.parseLong(sc.next());
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long[] temp1 = new long[n-1];
        long[] temp2 = new long[n-1];
        int l=-1, r=n-1;
        for (int i = n-2; i >=0 ; i--) {
            temp1[i] = i>0 ? arr1[i]-arr1[i-1] : arr1[i];
            temp2[i] = i>0 ? arr2[i]-arr2[i-1] : arr2[i];
            if (r==n-1 && temp1[i]!=temp2[i]){
                r=i;
            }
            if (temp1[i] != temp2[i]){
                l=i;
            }
        }
        temp1[0] = arr1[0];
        temp2[0] = arr2[0];

        long[] res = new long[n];
        if (r-l<1) return;
        for (int i = 0; i <= l; i++) {
            res[i] = temp1[i];
        }
        if (temp1[l]==temp2[l+1]){
            for (int k = 0; k+l<=r ; k++) {
                res[l+k]= temp2[l+k];
            }
            res[r+1] = temp1[r];
        }else {
            for (int k = 0; k+l<=r ; k++) {
                res[l+k]= temp1[l+k];
            }
            res[r+1] = temp2[r];
        }
        for (int j = r+1; j < n-1; j++) {
            res[j+1] = temp1[j];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
