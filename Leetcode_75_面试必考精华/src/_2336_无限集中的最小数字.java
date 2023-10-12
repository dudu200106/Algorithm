import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _2336_无限集中的最小数字 {
    int min = 1; // 代表原自然数无穷集中最小元素
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public _2336_无限集中的最小数字() {
    }

    public int popSmallest() {
        if (queue.isEmpty()){
            return min++;
        }
        int cur = queue.poll();
        set.remove(cur);
        return cur;
    }

    public void addBack(int num) {
        // 如果添加的元素比原集合最小值小, 那么添加入优先队列, pop的时候先把优先队列中的最小值都弹出了
        // 如果要添加进优先队列的数, 已存在, 则不添加
        if (num < min && !set.contains(num)){
            set.add(num);
            queue.offer(num);
        }
    }
}
