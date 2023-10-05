import java.math.BigDecimal;
import java.util.Scanner;

public class HJ95人民币转换 {

    static String[] up = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    static String[] dan = {"", "万","亿"}; // 单位


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
        System.out.println(input);
        System.out.println(solve(new BigDecimal(input+"")));
    }

    static String solve(BigDecimal input){
        System.out.println(input);
        long decimal = input.multiply(new BigDecimal(100)).longValue();
        System.out.println(decimal);
        long num = decimal/100;
        int xiao = (int)(decimal%100);

        StringBuilder sb = new StringBuilder();
        if(num>0)
            sb.append("元");
        int times = 0;
        while (num>0) {
            int temp = (int)(num%10000);
            num/=10000;
            sb.insert(0,dan[(times++)%3]);
            sb.insert(0, solveZheng(temp));
        }

        String res = sb.append(solveXiao(xiao)).toString();
        return "人民币" + (res.substring(0,1).equals("零")? res.substring(1) : res);
    }

    static String solveZheng(int num){
        StringBuilder sb =new StringBuilder();
        int ge = num%10;
        int shi = (num/10)%10;
        int bai = (num/100)%10;
        int qian = (num/1000)%10;
//        System.out.println(qian + "仟" +bai+ "佰" +shi+ "拾" + ge);

        if (qian!=0)
            sb.append(up[qian]).append("仟");
        if (bai!=0) {
            if (qian == 0)
                sb.append("零");
            sb.append(up[bai]).append("佰");
        }
        if (shi!=0){
            if (bai==0)
                sb.append("零");
            sb.append(shi==1 ? "" : up[shi]).append("拾");
        }
        if (ge!=0) {
            if (shi==0)
                sb.append("零");
            sb.append(up[ge]);
        }
        return sb.toString();
    }

    static String solveXiao(int xiao){
        StringBuilder sb = new StringBuilder();
        if (xiao==0)
            return "整";
        if(xiao/10%10!=0){
            sb.append(up[xiao/10%10]).append("角");
        }
        if(xiao%10!=0){
            sb.append(up[xiao%10]).append("分");
        }
        return sb.toString();
    }

}
