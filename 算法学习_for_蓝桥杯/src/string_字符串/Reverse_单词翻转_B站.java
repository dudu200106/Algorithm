package string_字符串;

/**
 *将字符串按单词翻转,如here you are 翻转成are you here
 *
 * 思路: 切分单词后再翻转单词--类似翻转字符串,把单词当做整体
 */
public class Reverse_单词翻转_B站 {

    public static void main(String[] args) {
        String s="here you are";
        System.out.println(wordReverse(s));
    }
    static String wordReverse(String str){
        //切分单词
        String[] strs=str.split(" "); //按照空格划分,也可以写成\\s (注:划分语法split("\正则表达式"),"\s"是正则式,引号内的反斜杠是"\\"--即转义一次,再正则转义一次)
        //翻转单词
        StringBuilder sb=new StringBuilder();
        for (int i = strs.length-1; i >=0 ; i--) {
            sb.append(strs[i]).append(' ');
        }
        return sb.deleteCharAt(sb.length()-1).toString(); //返回时最好删掉最后一个空格,再toString();
    }
}
