package string_字符串;

/**
 *给定一个字符串,将所有空格替换成"%20".
 * 假设该字符串末尾留有足够长的空间来存放新增字符,且知道字符串的长度(包括空格)
 * 注: java里的Arrays工具类有替换方法replaceAll(),这里得用字符数组来做,不然太简单
   解法: 设置两个双指针p1和p2, p1=string.length-1,p2=替换后新string的长度-1
        p1为先行指针,顺序扫描字符;p2为后行指针,放置p1扫描并复制或者替换后的字符
 */

public class URL化_替换字符数组的空格_cc150 {
    public static void main(String[] args) {
        int length=11;
        char[] c=new String("Tom J Trump      ").toCharArray();
        System.out.println(replace(c,length));
     }

    static String replace(char[] chars, int len){
        //计算空格数量,从而得出替换后的新字符串长度
        int cnt=0;
        for (int i = 0; i < len; i++) {
            if (chars[i]==' ')
                cnt++;
        }
        int len_new=len+cnt*2; //每个空格替换后多出两个空间
        int p1=len-1;
        int p2=len_new-1;
        for ( ; p1 >= 0; p1--) {
            if (chars[p1]==' '){
                chars[p2--]='0';
                chars[p2--]='2';
                chars[p2--]='%'; //p2-=2;
            }
            else
                chars[p2--]=chars[p1];
        }
        return new String(chars);
    }
}

