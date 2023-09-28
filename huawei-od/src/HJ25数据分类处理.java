import java.util.*;

public class HJ25数据分类处理 {

    public static HashMap<Integer, ArrayList<Integer[]>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ilen = sc.nextInt();
        int[] i=new int[ilen];
        for (int j = 0; j < ilen; j++) {
            i[j] = sc.nextInt();
        }

        int rlen = sc.nextInt();
        TreeSet<Integer> r = new TreeSet<>();
        for (int j = 0; j < rlen; j++) {
            r.add(sc.nextInt());
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int rr : r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k = 0; k < ilen; k++) {
                int ii = i[k];
                if((ii+"").contains(rr+"") ){
                    temp.add(k);
                    temp.add(ii);
                }
            }
            if (temp.size()!=0){ // 注意这里,
                res.add(rr);
                res.add(temp.size()>>1);
                res.addAll(temp);
            }
        }

        System.out.print(res.size()+" ");
        for (int e : res){
            System.out.print(e +" ");
        }



//        for (int k = 0; k < i.length; k++) {
//            check(k, i[k], r);
//        }

//        ArrayList<Integer> res = new ArrayList<>();
//        for (int ele : r){
//            ArrayList<Integer[]> temp = map.get(ele); // 获取key对应列表
//            if (temp.size() == 0)
//                continue;
//            res.add(ele);
//            res.add(temp.size());
//            for (Integer[] kv: temp){
//                res.add(kv[0]);
//                res.add(kv[1]);
//            }
//        }
//        System.out.print(res.size()+" ");
//        for (int e : res){
//            System.out.print(e +" ");
//        }
    }

//    static void check(int index, int num, TreeSet<Integer> r){
//        for(int e: r){
//
//            if ((num+"").contains(e+"")){
//                if (map.get(e) == null){
//                    map.put(e,new ArrayList<>());
//                }
//                Integer[] arr = {index, num};
//                map.get(e).add(arr);
//            }
//        }
//    }
}
