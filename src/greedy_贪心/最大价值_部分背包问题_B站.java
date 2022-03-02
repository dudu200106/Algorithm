package greedy_贪心;

import java.util.Arrays;

/**
 有n个物体，第i个物体的重量为wi，价值为vi。在总重量不超过C的情况下让总价值尽量高。
 每一个物体都可以只取走一部分，价值和重量按比例计算。
 求最大总价值

 注意：每个物体可以只拿一部分，因此可以可切割一部分,让总重量恰好为C。
 */
/*思路: 创建一个Thing类,顺着价值最高的物品装入, 最后还差多少则补上*/
public class 最大价值_部分背包问题_B站 {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        int[] v = {3, 4, 3, 1, 4};
        int n = w.length;
        double cap = 10;
        Thing[] th=new Thing[n];
        for (int i = 0; i < n; i++) {
            th[i]=new Thing(w[i],v[i]);
        }
        Arrays.sort(th);
        for (int j = 0; j < n; j++) { //打印出排序好的Thing
            System.out.println(th[j].toString());
        }

        double maxValue=0;
        for (int i = n-1; i>=0; i--) {
            double weight=th[i].w;
            double value=th[i].v;
            if (cap>0){
                if (weight<=cap) { //容量比下一个物品重量大
                    cap -=weight;
                    maxValue +=value;
                    System.out.println("surplus cap： " + cap);
                }
                else{ //容量不够装，切下当前物品的一部分将剩余的容填满；
                    maxValue+=th[i].getPrice()*cap;
                    cap=0;
                }
            }
            else break;
        }
        System.out.println(maxValue);
    }


    public static class Thing implements Comparable<Thing>{
        double w;
        double v;

        public Thing(double w,double v){
            this.w=w;
            this.v=v;
        }

        public double getPrice(){
            return this.v / this.w;
        }

        @Override
        public int compareTo(Thing o) {
            if (this.getPrice()>o.getPrice()) return 1;
            else if (this.getPrice()==o.getPrice()) return 0;
            else return -1;
        }

        public String toString() {
            return "Obj{" +
                    "w=" + w +
                    ", v=" + v +
                    ", price=" + getPrice() +
                    '}';
        }
    }
}
