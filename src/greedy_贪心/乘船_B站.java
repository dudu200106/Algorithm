package greedy_贪心;

import java.util.Arrays;

/**
 有n个人，第i个人重量为wi。每艘船的最大载重量均为C，且最多只能乘两个人。用最少的船装载所有人。

 求需要船的数量
 */
/*
* 贪心策略：考虑最轻的人i，如果每个人都无法和他一起坐船（重量和超过C），则唯一的方案是每个人坐一艘
 否则，他应该选择能和他一起坐船的人中最重的一个j
 * 最轻和最重的人分别用双指针指向
*/

public class 乘船_B站 {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numOfPerson = w.length;
        int cap = 10;

        Arrays.sort(w);
        int cntOfBoat = 0;
        int big = numOfPerson-1;
        int sma = 0;
        while (numOfPerson>0){
            if (w[big]+w[sma]>cap) {
                cntOfBoat++; //最大的自己一个人坐一艘过去
                big--;
                numOfPerson--;
            }
            else{
                cntOfBoat++; //最大和最小两人坐一艘
                big--;
                sma++;
                numOfPerson-=2;
            }
        }
        System.out.println(cntOfBoat);
    }
}
