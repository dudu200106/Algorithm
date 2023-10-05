package 省题备考;

import java.util.Scanner;

public class 特别的数_2019 {
    public static void main(String[] args) {
        int res=0;
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 1; i <= n; i++) {
            if (check(i)){
                res+=i;
            }
        }
        System.out.println(res);
    }

    static boolean check(int i){
        for (int j=1; j<=5; j++){
            if (i==0) break;
            int temp=i%10;
            i/=10;
            if (temp==2||temp==0||temp==1||temp==9)
                return true;
        }
        return false;
    }
}
