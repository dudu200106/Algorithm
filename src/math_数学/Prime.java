package math_数学;


import java.util.HashMap;
import java.util.Map;

public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(9));
        System.out.println(isPrime(7));

        HashMap<Integer, Integer> res= primeFacter(13);
        StringBuilder sb=new StringBuilder();
        for (Map.Entry<Integer,Integer> entry: res.entrySet()) {
            int key=entry.getKey();
            int count=entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append('*').append(key);
            }
        }
        System.out.println(sb.deleteCharAt(0));
    }

    /**
     *
     * @param num
     * @return num是不是素数/质数
     */
    static boolean isPrime(int num){
        for (int i = 2; i*i <=num ; i++) {
            if (num%i==0)
                return false;
        }
        return true;
    }

    /**
     * 唯一分解定理: 大于1的正整数, 都能被分解成若干个质数的乘积: N=p1*p2*p3*...(pn都是正整数,可以重复)
     * 质因数: 即使num的因数, 有是个质数
     * @param num
     * @return num的因子
     */
    static HashMap<Integer,Integer> primeFacter(int num){
        HashMap<Integer,Integer> map  =new HashMap();
        for (int i = 2; i <=num ; i++) { //自小到大遍历至它本身,保证从小到大除尽num的质因数
            while (num % i == 0) { //直至质因数i, 不能再除尽num,数值为i的质因数完了,下一个(1~i-1中的质因数及其数量都已经包含在map里了)
                Integer val=map.get(i);
                if (val == null)
                    map.put(i, 1);
                else
                    map.put(i, val + 1);
                num/=i;
            }
        }
        return map;
    }
}
