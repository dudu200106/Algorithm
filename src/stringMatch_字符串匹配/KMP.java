package stringMatch_字符串匹配;

public class KMP {
    public static void main(String[] args) {
        String sc = "babababcbabababb";
        int index = indexOf(sc,"bababb");
        int count =indexOf2(sc,"bababb");
        System.out.println(index);
    }

    static int indexOf(String str, String p){
        int i=0;
        int scan=i;
        int j=0;
        while (i<str.length()){
            char c_s=str.charAt(scan);
            char c_p=p.charAt(j);
            if (c_s==c_p){
                if (j==p.length()-1)
                    return i;
                j++;
                scan++; //scan++可能会越界, 也可以考虑j==p.length()放在此处
               /* if (j==p.length())
                    return i;*/
            }
            else { //失配母串下标i就得回溯至原位置并加一,j重置为0
                i++;
                j=0;
                scan=i;
            }
        }
        return -1; //母串s不存在模式串p
    }

    static int indexOf2(String str, String p){

        if (str.length()==0||p.length()==0)return -1;
        if (p.length()>str.length())return -1;
        int[] next= next(p); //next[j]代表了若是j失配, j将跳回到哪个位置
        int cnt=0;
        int i=0;
        int j=0;
        while(i<str.length()) {
            //两种情况:1.j下标已经是第一个字符了,且next[0]==-1又失配,j无回溯位置了,只能母串模式串重新匹配下一个字符--j++和i++
            //        2. 下标相互匹配, 继续匹配下一个字符
            if (j==-1||str.charAt(i)==p.charAt(j)){ //若是j==-1, 那么直接短路为true, 不用执行右边的逻辑判断语句
                j++;
                i++;
            }
            else //如果j != -1，且当前字符匹配失败，则令 i 不变，j = next[j]
                j=next[j];
            if (j==p.length()){ //现在i和j都因为最后一个字符相等多移动了一位, 匹配下一个时得-1
                cnt++;
                i--; //完全匹配成功, 将j下标移动到最长前缀那里
                j=next[j-1];
            }
        }
        return cnt;
    }

    /*DP状态转移方程: next[i]=max{j} max{j}指的是:以i-1结尾的后缀,与0开头的前缀的最大相同子串长度;
                    每个相同前后缀的长度j都是next[i]的候选值, 只有最长的j才是最优解-- 即同时满足两个条件的才是next[i]:
                    1.候选值(前后缀相同), 2.最长的候选值(前后缀相同)长度
     具体决策如下:
    */
    static int[] next(String str){
        int[] next=new int[str.length()]; //防止str只有一位数
        next[0]=-1;
//        if(str.length()==1) return next;//防止str只有一位数
        next[1]=0; //这两个是固定的, 相当于DP的初始化的状态数据

        int j=2;//它的j-1才是后缀, 判断后缀和前缀的
        int scan=next[j-1]; //跳到它的失配回溯位置
        while(j<str.length()){
            if (scan<0||str.charAt(j-1)==str.charAt(scan)) { //(若要论DP的含义,就是利用了历史最优解和他们的问题,通过决策实现当前最优解)
                next[j] = next[j-1] + 1; //利用了next数组的含义: 要是这个回溯后位置的字符,与新加入的后缀结尾字符相同,你们就相当于相同的前后缀同时+1了
                scan=next[j++];
                /*也可以scan++ (因为scan==next[j-1]) */
            }
            else
                scan=next[scan]; //若是结尾字符和回溯字符也失配, 继续调到回溯字符的回溯位置,直至上方条件成立
        }
        return next;
    }

}
