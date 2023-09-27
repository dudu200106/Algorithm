import java.util.Scanner;

public class HJ29字符串加解密 {

    /**
     * 这一题主要是对Character下面api运用,以及
     * 取余方法同定点数加减关系 -- 计算机中只用加法,用加法实现减法的原理
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        String en = in.nextLine();

        System.out.println(coding(c));
        System.out.println(enCoding(en));
    }

    static String coding(String s){
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                sb.append((ch-'0'+1)%10);
            }else{
                if(Character.isUpperCase(ch)){
                    int ind = (ch-'A'+1)%26;
                    sb.append((char)('a'+ind));
                }else{
                    int ind = (ch-'a'+1)%26;
                    sb.append((char)('A'+ind));
                }
            }
        }
        return sb.toString();
    }

    static String enCoding(String s){
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                sb.append((ch-'0'+9)%10);
            }else{
                if(Character.isUpperCase(ch)){
                    int ind = (ch-'A'+25)%26;
                    sb.append((char)('a'+ind));
                }else{
                    int ind = (ch-'a'+25)%26;
                    sb.append((char)('A'+ind));
                }
            }
        }
        return sb.toString();
    }

}
