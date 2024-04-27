import java.util.Scanner;

public class 美团笔试 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String pattern = "meituan";
        int res = 0;
        for (int i = 0; i < 7; i++) {
            if (str.charAt(i) != pattern.charAt(i)){
                res++;
            }
        }
        System.out.println(res);
    }

}
