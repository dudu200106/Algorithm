package string_字符串.省题;

import java.util.ArrayList;

public class 人物相关性分析_字符串匹配_省题 {
    //RabinKarp
    final static int seed=31;
    public static void main(String[] args) {
        String str="This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
//        String str="This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob. This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
        int n=20;
        String a="Alice";
        String b="Bob";
        long h_a=hash(a);
        long h_b=hash(b);
        long[] help1=hash(str,5);
        long[] help2=hash(str,3);

        ArrayList<Integer> Alice=new ArrayList<>();
        ArrayList<Integer> Bob=new ArrayList<>();

        for (int i = 0; i < help1.length; i++) {
            if (h_a == help1[i]) {
                    Alice.add(i);
            }
        }
        for (int i = 0; i < help2.length; i++) {
            if (h_b == help2[i]) {
                    Bob.add(i);
            }
        }

        System.out.println(Bob);
        System.out.println(Alice);

        int ans = 0;
        for (int i = 0; i < Alice.size(); i++) {
            for (int j = 0; j < Bob.size(); j++) {
                int dist=Alice.get(i)-Bob.get(j);
                if(dist<n&&dist>0)
                    ans++;
                else if (dist>-n&&dist<0)
                    ans++;
            }
        }
        System.out.println(ans);
    }

    public static long hash(String str){ //普通
        long res=0;
        for (int j = 0; j < str.length(); j++) {
            char c=str.charAt(j);
            res=res*seed+c;
        }
        return res%Long.MAX_VALUE;
    }

    public static long[] hash(String str, int k){
        long[] hashArr=new long[str.length()]; //滚动哈希数组
        hashArr[0]=hash(str.substring(0,k));
        for (int i = k; i <str.length(); i++) {
            char newch=str.charAt(i);
            char oldch=str.charAt(i-k);
            long val=hashArr[i-k]*seed+newch - oldch*(long)Math.pow(seed,k);
            hashArr[i-k+1]= val%Long.MAX_VALUE;
        }
        return hashArr;
    }

}
