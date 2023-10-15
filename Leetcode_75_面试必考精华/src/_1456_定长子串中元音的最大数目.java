public class _1456_定长子串中元音的最大数目 {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (check(s.charAt(i))){
                cnt++;
            }
        }
        int res = cnt;
        for (int j = k; j < s.length(); j++) {
            if (check(s.charAt(j))){
                cnt++;
            }
            if (check(s.charAt(j-k))){
                cnt--;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public boolean check(char ch){
        return "aeiou".indexOf(ch)>=0;
    }
}
