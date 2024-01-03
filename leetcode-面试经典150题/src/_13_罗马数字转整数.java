import java.util.HashMap;
import java.util.Map;

public class _13_罗马数字转整数 {

    public static Map<Character, Integer> map ;
    static {
        map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int romanToInt(String s) {
        int n =s.length();
        int res = 0;
        for (int j = 0; j < n; j++) {
            int curVal = map.get(s.charAt(j));
            if (j+1<n && curVal < map.get(s.charAt(j+1))){
                res -= curVal;
            }else {
                res += curVal;
            }
        }
        return res ;
    }

}
