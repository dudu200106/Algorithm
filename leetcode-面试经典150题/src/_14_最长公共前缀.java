public class _14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length<=1){
            return strs[0];
        }
        StringBuilder prefix = new StringBuilder();
        boolean flag =true;
        int ind =0;
        while(flag){
            char pc = strs[0].charAt(ind);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(ind) != pc){
                    flag =false;
                    break;
                }
            }
            if (flag){
                prefix.append(pc);
                ind++;
            }
        }
        return prefix.toString();
    }

}
