import java.util.*;

public class HJ64MP3光标位置 {
    public static int ind = 1;
    public static int h;
    public static int r;
    public static int psize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        psize = sc.nextInt();
        char[] moves = sc.next().toCharArray();
        h = 1;
        r = psize >= 4 ? 4 : psize;
        for (char cc : moves) {
            move(cc);
        }
        for(int j=h; j<=r; j++){
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println(ind);
    }

    /* 1. 一个容量为4的队列, 初始化4条歌曲,若是条数不够跳转到下一种情况*/
    /* 2. 记录队列的头和尾, 如果到了头和尾还要向上或者乡向下移动,则出队入队*/

    static void move(char act) {
        if (act == 'U') {
            if (ind == h) {
                if (h == 1) {
                    r = psize;
                    h = psize >= 4 ? psize - 3 : 1;
                    ind = r;
                } else {
                    h--;
                    r--;
                    ind = h;
                }
            } else {
                ind--;
            }
        } else {
            if (ind == r) {
                if (r == psize) {
                    h = 1;
                    r = psize >= 4 ? 4 : psize;
                    ind = h;
                } else {
                    h++;
                    r++;
                    ind = r;
                }
            } else {
                ind++;
            }
        }
    }
}
