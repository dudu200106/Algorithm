public class _125_验证回文串 {


    /**
     * 基于StringBuilder api 的做法, 比双指针版本的简要
     *
     *  当然，如果是要判断一个字符串中很多的子串是不是回文字符串，一个个的判断实在是太复杂了；
     *  那种情况下，最好是用中心扩散法 或者 动态规划
     * @param s
     * @return
     */
    public boolean isPalindrome02(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)){
                sb.append(s.charAt(i));
            }
        }
        StringBuilder reverse = new StringBuilder(sb);
        reverse.reverse();
        return reverse.toString().equals(sb.toString());
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            while (l<r && !Character.isDigit(s.charAt(l) ) && !Character.isLetter(s.charAt(l)) ){
                l++;
            }
            while (l<r && !Character.isDigit(s.charAt(r) ) && !Character.isLetter(s.charAt(r)) ){
                l++;
            }
            if (s.charAt(r++)!=s.charAt(l++)){
                return false;
            }
        }
        return true;
    }

    public int fibo(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }


   


}
