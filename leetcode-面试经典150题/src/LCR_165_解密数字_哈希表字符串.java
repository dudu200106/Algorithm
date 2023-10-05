import java.util.Scanner;

public class LCR_165_解密数字_哈希表字符串 {
   /*
   * 极其类似斐波那契, 但多加了一个条件就是跨两步合不合法
   * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        System.out.println(dfs(code+""));
        System.out.println(crackNumber(code));

    }

    // 迭代版本,
    public static int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int one=1; // 向前只"跨一步"
        int two=1; // 向前夸两步 , 但此时不知道"跨两步"的数字合不合法
        for (int i = 0; i <= s.length()-2 ; i++) {
            // temp代表了取两位数字是否合法的情况
            int temp = Integer.parseInt(s.substring(i,i+2));
            int three = temp<=25 && temp>= 10 ? one+two : one;
            two = one;
            one = three;
        }
        return one;
    }

    public static int dfs(String str){
        if (str.length()==0 || str.length()==1){
            return 1;
        }
        if (Integer.parseInt(str.substring(0,2))<=25 &&
                Integer.parseInt(str.substring(0,2))>9){
            return dfs(str.substring(1)) + dfs(str.substring(2));
        }
        return dfs(str.substring(1));
    }

}
