package stringMatch_字符串匹配;

/*
       next[i]的含义: 当第i个模式串字符失配时, 模式串的指针j指向i-1结尾后缀相同前缀末尾的后一位 -- 即next[i]位,
        重新与失配字符匹配; 若不匹配直到j=next[...next[i]]=-1, j++, next[i]=j/0/-1+1;
       DP状态转移方程: next[i]=
                       -1, (i=0, 即首字符无xt前缀)
                       0, (其他情况--前缀无任何匹配)
                       max{j}
                           ---(满足以下要求:)
                               1. 以j-1结尾的后缀的相同前缀(多个候选值)
                           `   2. 是候选值中,相同前缀中长度最长的结尾下标+1

       具体决策如下:
           注: 为了方便, next[i+1]其实代表 以i结尾的后缀的相同前缀的下标后一位, 方便失配后j跳转与i+1位字符进行二次比较
   */

public class KMP {
    public static void main(String[] args) {
        String sc = "babababcbabababb";
        int index1 = indexOf(sc,"bababb");
        int count =indexOf2(sc,"bababb");
        int ind =index_simple(sc,"bababb");
        System.out.println(index1);
        System.out.println(count);
        System.out.println(ind);
    }

    /**
     * 暴力枚举  相当于原始版本, KMP是迭代第二版
     * @param str
     * @param p
     * @return
     */
    static int indexOf(String str, String p){
        int i = 0, j = 0;
        while (i<str.length() && j<p.length()){
            if (str.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            else { //失配母串下标i就得回溯至原位置并加一,j重置为0
                i= i-j+1;
                j=0;
            }
        }
        if (j==p.length())
            return i-j;
        return -1; //母串s不存在模式串p
    }

    static int indexOf2(String str, String p){
        if (str.length()==0||p.length()==0)return -1;
        if (p.length()>str.length())return -1;
        int[] next= next(p); //next[j]代表了若是j失配, j将跳回到哪个位置
        int cnt = 0;
        int i = 0, j = 0;
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

    /**
     * 最简单的next数组模版  注意这里的next数组就是下一步跳转的意思了
     * @param str
     * @return
     */
    static int[] next(String str){
        int[] next=new int[str.length()];
        // 初始dp状态
        next[0]=-1;
        int i = 0; // 当前待求next[i]的字符
        int j = next[i]; //j=-1,-- j是当前最长相同前缀的末尾指针+1
        //(若要论DP的含义,就是利用了历史最优解和他们的问题,通过决策实现当前最优解)
        while(i<str.length()-1){
            if (j==-1||str.charAt(i)==str.charAt(j)) { // 前缀没有匹配的(到头了都没有相同的字符) 或者 字符i与字符j相等
                //利用了next数组的含义: 前后缀相同, 若是新增前后缀后面字符相等, 则同时+1
                next[++i] = ++j;
            }
            else //否则字符j与字符i失配, j回溯到next[j], 再与i进行比较
                j=next[j]; //若是结尾字符和回溯字符也失配, 继续调到回溯字符的回溯位置,直至上方条件成立
        }
        return next;
    }


    /**
     * KMP模版  所以说本质上, KMP算法就是两次前后缀字符串的匹配
     * @param str
     * @param p
     * @return
     */
    public static int index_simple(String str, String p){
        int[] next = next_simple(p);
        int m = 0;
        for (int k = 0; k < str.length(); k++) {
            while(m!=-1 && str.charAt(k)!=p.charAt(m+1))
                m = next[m];
            if (str.charAt(k)==p.charAt(m+1))
                m++;
            // 注意一下这步与next_simple中的区别
            if (m == p.length()-1)
                return k-m;

        }
        return -1;
    }

    public static int[] next_simple(String str){
        int n = str.length();
        int[] next = new int[n];
        next[0] = -1;
        int j = -1;
        for (int i=1;i<n; i++){
            while (str.charAt(j+1)!=str.charAt(i) && j!=-1)
                j=next[j];
            if (str.charAt(j+1)==str.charAt(i) )
                j++;
            // 注意以下这步与index_simple中的区别
            next[i]=j;
        }
        return next;
    }



    static int[] next2(String str){
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
