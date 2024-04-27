import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sean Du
 * @version 1.0.0
 * @date 2024/03/22
 */
public class xiaomi_2 {
    public static void main(String[ ] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        int[] arr = new int[n];
        while(true){
            for(int i=0; i<arr.length; i++){
                if (n==0){
                    System.out.println(i);
                    return;
                }
                if(arr[i]!=0)
                    continue;
                if(cnt++ % 3 == 0){
                    arr[i] = 1;
                    n--;
                }
            }
        }
    }
}
