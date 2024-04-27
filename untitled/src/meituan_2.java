import java.util.Scanner;

/**
 * @author Sean Du
 * @version 1.0.0
 * @date 2024/04/06
 */
public class meituan_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String a = in.next();
            int len = a.length();
            if (a.charAt(len-1) != 'i'){
                res++;
            }else {
                int l = len-2;
                while (Character.isDigit(a.charAt(l))){
                    l++;
                }
                if (Integer.parseInt(a.substring(l, len-1))==0){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}
