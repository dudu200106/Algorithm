package math_数学;

/**
 * Description
 * 两只青蛙在网上相识了，它们聊得很开心，于是觉得很有必要见一面。
 * 它们很高兴地发现它们住在同一条纬度线上，于是它们约定各自朝西跳，直到碰面为止。
 * 可是它们出发之前忘记了一件很重要的事情，既没有问清楚对方的特征，也没有约定见面的具体位置。
 * 不过青蛙们都是很乐观的，它们觉得只要一直朝着某个方向跳下去，总能碰到对方的。
 * 但是除非这两只青蛙在同一时间跳到同一点上，不然是永远都不可能碰面的。
 * 为了帮助这两只乐观的青蛙，你被要求写一个程序来判断这两只青蛙是否能够碰面，会在什么时候碰面。
 * 我们把这两只青蛙分别叫做青蛙A和青蛙B，并且规定纬度线上东经0度处为原点，由东往西为正方向，单位长度1米，这样我们就得到了一条首尾相接的数轴。
 * 设青蛙A的出发点坐标是x，青蛙B的出发点坐标是y。青蛙A一次能跳m米，青蛙B一次能跳n米，两只青蛙跳一次所花费的时间相同。
 * 纬度线总长L米。现在要你求出它们跳了几次以后才会碰面。
 *
 * Input
 * 输入只包括一行5个整数x，y，m，n，L，其中x≠y < 2000000000，0 < m、n < 2000000000，0 < L < 2100000000。
 *
 * Output
 * 输出碰面所需要的跳跃次数，如果永远不可能碰面则输出一行"Impossible"
 *
 * Sample Input
 *
 * 1 2 3 4 5
 *
 * Sample Output
 *
 * 4
 *
   思路:
        不同于上一题的一步之遥, 前者是在一条直线上的,而这里的题目要求围绕着纬度周长为L的"环";
        那么, 就可以利用同余方程代表其实际物理意义--绕一圈多出来的部分就相当于余数,最终要是余数相等,就代表二者重合
        即:x+km≡y+kn(mod L)
        在将它转化为一般的线性方程:
 */
public class 青蛙约会 {
    public static void main(String[] args) {

    }


    private static class Egcd{
        static int  x,y; //静态全局变量, 防止使得贝祖等式处理的数

        static int egcd(int a,int b){
            if (b==0){ //递归跳出方法
                x=1;
                y=0;
                return a;
            }

            int d=egcd(b,a%b);
            int x1=x;
            x=y;
            y=x1-(a/b)*y;
            return d;
        }

        /**
         * 解出线性方程ax+by=m的解, 放在静态成员变量x,y中
         * @param a
         * @param b
         * @param m
         * @return gcd(a.b)
         * @throws Exception
         */
        static int linearEquation(int a,int b,int m) throws Exception{
            int d=egcd(a,b);
            if (m%d!=0)//判断m是否为gcd(a,b)的倍数
                throw new Exception("等式不成立");
            int n=m/d;
            x*=n;
            y*=n;
            return d;
        }
    }
}
