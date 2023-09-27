import java.util.*;

public class HJ26字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = new String(in.nextLine());
        HashMap<String, ArrayList<Character>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String key = str.substring(i,i+1).toLowerCase();
            if ("abcdefghijklmnopqrstuvwxyz".contains(key)){
                if (map.get(key) == null)
                    map.put(key,new ArrayList<>());
                map.get(key).add(ch);
            }
        }
        System.out.println(map);

        ArrayList<Character> res = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            ArrayList<Character> list = map.get(""+ i);
            if (list == null) continue;
            res.addAll(list);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < str.length(); k++) {
            if (Character.isAlphabetic(str.charAt(k))){
                sb.append(res.get(i++));
            }else {
                sb.append(str.charAt(k));
            }
        }

        System.out.println(sb);
    }

}

