import java.util.Scanner;

public class bishi {

    public static void main(String[] args){
        int alph= 0;
        int kong= 0;
        int digi= 0;
        int other= 0;

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>= '0' && ch<='9'){
                digi++;
            }else if(ch==' '){
                kong++;
            }else if((ch>= 'a' && ch<='z') || ch>= 'A' && ch<='Z'){
                alph++;
            }else{
                other++;
            }
        }

        System.out.println("字母个数="+ alph +",数字个数=" +digi+ ",空格个数="+ kong +",其他字符个数=" + other);

    }

}
