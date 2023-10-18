import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _1207_独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int key: map.keySet()) {
            set.add(map.get(key));
        }
        return set.size()==map.size();
    }
}
