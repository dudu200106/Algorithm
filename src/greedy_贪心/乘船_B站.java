package greedy_贪心;

import java.util.Arrays;

/**
 有n个人，第i个人重量为wi。每艘船的最大载重量均为C，且最多只能乘两个人。用最少的船装载所有人。

 求需要船的数量
 */
/*
* 贪心策略：考虑最轻的人i和最重的j应该做一艘, 除非他两个超重, 那最重的只能自己坐一艘, 然后考虑第二重的人...
 * 最轻和最重的人分别用双指针指向
*/

public class 乘船_B站 {
    public static void main(String[] args) {

        int[] w = {1, 2, 3, 4,6, 7, 5, 8, 9};
        int numOfPerson = w.length;
        int cap = 10;
        /* step.1 对所有人的重量排序*/
        Arrays.sort(w);
        int cntOfBoat = 0;
        int big = numOfPerson-1;
        int sma = 0;
        /* step.2 遍历首尾的最大和最小重量和*/
        while (numOfPerson>0){
            if (w[big]+w[sma]>cap) { //最重的自己一个人坐一艘过去
                cntOfBoat++;
                big--;
                numOfPerson--;
            }
            else{ //最大和最小两人坐一艘
                cntOfBoat++;
                big--;
                sma++;
                numOfPerson-=2;
            }
        }
        System.out.println(cntOfBoat);
    }
}
