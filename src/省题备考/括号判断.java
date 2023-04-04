package 省题备考;

import java.util.Scanner;
import java.lang.String;

/**
 *(代表蓝, [代表黄, {代表红
 * 输入一串({[}的括号序列, 判断是否左右成对
 * 是, 输出颜色, 如
 *     输入: "{()}[]"
 *     输出: "红蓝蓝红黄黄"
 * 否, 输出"输入错误"

 *解题思路: 运用栈, 判断最后栈是否为空
 */

public class 括号判断 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= in.next();
        if(!isValid(line)){
            System.out.println("输入错误");
        }else{
            color(line);
        }
    }

    public static void color(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char c= str.charAt(i);
            if(c=='(' || c==')')
                sb.append("蓝");
            if(c=='[' || c==']')
                sb.append("黄");
            if(c=='{' || c=='}')
                sb.append("红");
        }

        System.out.println(sb);
    }

    public static boolean isValid(String s){
        if(s.length()<=1)
            return false;
        // 用可变字符串, 来充当一个栈
        StringBuilder sb = new StringBuilder();
        boolean flag= true;

        for(int i=0; i<s.length(); i++){
            char c_t = s.charAt(i);  // 当前字符
            //当前字符为左括号, 那入栈一个右括号
            if(c_t == '('){
                sb.append(')');
            }
            else if('['==c_t){
                sb.append(']');
            }else if('{'==c_t){
                sb.append('}');
            }else{  // 如果当前元素为右括号, 则要判断栈顶元素是否相同, 相同就弹出栈顶元素
                int len=sb.length();
                if(len>0 && sb.charAt(len-1)== c_t){
                    sb.delete(len-1,len);  //弹出
                }else{
                    flag=false;
                    break;
                }
            }
        }
        //最后判断栈是否为空, 若不为空则说明最后入栈的括号为左括号, 并且没有有括号继续入栈
        if(sb.length()!=0){
            flag= false;
        }
        return flag;
    }

}
