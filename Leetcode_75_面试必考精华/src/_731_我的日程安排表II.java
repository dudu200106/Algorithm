import java.util.ArrayList;
import java.util.Arrays;

public class _731_我的日程安排表II {

    static ArrayList<Integer[]> first;
    static ArrayList<Integer[]> overlap;

//    public MyCalendarTwo() {
//        overlap = new ArrayList<>();
//        first = new ArrayList<>();
//    }

    public boolean book(int start, int end) {
        for (Integer[] arr: overlap){
            int l= arr[0], r=arr[1];
            if (l<end && r>start){
                return false;
            }
        }

        for (Integer[] arr: first){
            int l= arr[0], r=arr[1];
            if (l<end && r>start){
                if (start<l)
                    overlap.add(new Integer[]{start, l});
                if(end>r)
                    overlap.add(new Integer[]{r, end});
            }
        }
        first.add(new Integer[]{start, end});
        return true;
    }

}
