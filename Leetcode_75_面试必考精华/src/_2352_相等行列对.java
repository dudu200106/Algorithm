import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2352_相等行列对 {
    public int equalPairs(int[][] grid) {
        int len = grid.length;
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(Arrays.toString(grid[i]), map.getOrDefault(Arrays.toString(grid[i]),0)+1);
        }
        for (int j = 0; j < len; j++) {
            int[] arr = new int[len];
            for (int k = 0; k < len; k++) {
                arr[k] = grid[k][j];
            }
            String s = Arrays.toString(arr);
            int cnt = map.getOrDefault(s,0);
            if (cnt>0){
                res+=cnt;
            }
        }
        return res;
    }
}
