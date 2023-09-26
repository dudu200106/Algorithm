
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ17坐标移动 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String[] moves = str.split(";");
        int[] p = new int[2];
        for(String i: moves){
            int len = i.length();
            if(!check(i) || 1==len || len>3)
                continue;
            char ch = i.charAt(0);
            int step = 0;
            for (int j = len-1; j>=1 ; j--) {
                char cc= i.charAt(j);
                if (cc>'9' || cc < '0')
                    break;
                step += (cc - '0')*Math.pow(10,len-j-1);
//                step += (cc - '0');
            }
            switch(ch){
                case 'A':
                    p[0] -= step;
                    break;
                case 'D':
                    p[0] += step;
                    break;
                case 'W':
                    p[1] += step;
                    break;
                case 'S':
                    p[1] -= step;
                    break;
            }
        }
        System.out.println(p[0]+","+p[1]);
    }

    static boolean check(String s){
        return s.startsWith("A") || s.startsWith("D") || s.startsWith("W") || s.startsWith("S");
    }

}
