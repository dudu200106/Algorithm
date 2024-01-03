public class _58_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i =s.length()-1;
        int res = 0;
        while(i>=0 && s.charAt(i)!=' ' ){
            res++;
            i--;
        }
        return res;
    }

}
