import java.util.Deque;
import java.util.LinkedList;

public class _649_Dota2参议院 {
    public String predictPartyVictory(String senate){
        Deque<Integer> r_queue = new LinkedList<>();
        Deque<Integer> d_queue = new LinkedList<>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
            char ch = senate.charAt(i);
            if (ch=='R' ){
                r_queue.offer(i);
            }else{
                d_queue.offer(i);
            }
        }
        while(!r_queue.isEmpty() && !d_queue.isEmpty()){
            int rseq = r_queue.poll();
            int dseq = d_queue.poll();
            if (rseq<dseq){
                r_queue.offer(len++);
            }else {
                d_queue.offer(len++);
            }
        }
        return d_queue.isEmpty() ? "Radiant" : "Dire";
    }
}
