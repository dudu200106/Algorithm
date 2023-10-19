import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_电话号码的字母组合 {
    public static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return res;
        dfs(digits, 0);
        return res;
    }

    public static StringBuilder combaration = new StringBuilder();
    public void dfs(String digi, int ind){
        if (ind == digi.length()){
            res.add(combaration.toString());
            return;
        }
        for (char ch: map.get(digi.charAt(ind)).toCharArray()) {
            combaration.append(ch);
            dfs(digi, ind+1);
            combaration.deleteCharAt(ind);
        }
    }
}
