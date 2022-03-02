package string_字符串;

/*类似压缩数组的做法,将连续出现的k个0替换成一个 --如:A0000B0C000->A00B0C0*/

public class 替换连续出现的k个0_B站 {
    public static void main(String[] args) {
        String s="A0000B0C000";
        System.out.println(solve(s,3));
        System.out.println(solve2(s,3));
    }

    /*java API*/
    static String solve(String str, int k){
        String regrex="0{"+ k +"}"; //正则表达式,相当"000"
        return str.replaceAll(regrex,"0");
    }

    /*StringBuilder生成新字符串*/
    static String solve2(String str, int k){
        int count=0;
        int num; //得出连续n个0要替换的0的个数:count/k + count%k
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (c=='0'){
                count++;
            }else{
                num=count/k+count%k; //结算, 要替换成几个0
                for (int j=0 ;j<num; j++){ //结算,将前面有
                    sb.append('0');
                }
                count=0;
                sb.append(c);
            }
        }
        num=count/k+count%k; //结算, 要替换成几个0
        for (int j=0;j<num;j++){ //将末尾的
            sb.append('0');
        }
        return sb.toString();
    }
}
