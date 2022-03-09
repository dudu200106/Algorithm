package math_数学;

/**
 * 从昏迷中醒来，小明发现自己被关在X星球的废矿车里。
 矿车停在平直的废弃的轨道上。
 他的面前是两个按钮，分别写着“F”和“B”。

 小明突然记起来，这两个按钮可以控制矿车在轨道上前进和后退。
 按F，会前进97米。按B会后退127米。
 透过昏暗的灯光，小明看到自己前方1米远正好有个监控探头。
 他必须设法使得矿车正好停在摄像头的下方，才有机会争取同伴的援助。
 或许，通过多次操作F和B可以办到。

 矿车上的动力已经不太足，黄色的警示灯在默默闪烁...
 每次进行 F 或 B 操作都会消耗一定的能量。
 小明飞快地计算，至少要多少次操作，才能把矿车准确地停在前方1米远的地方。

 请填写为了达成目标，最少需要操作的次数。

 思路: 可以转换为一组贝祖等式
 97x-127y=1
 ax+by=m
 就相当于求一组贝祖等式的线性方程
 */

public class 一步之遥 {

    public static void main(String[] args) {
        try {
            int d=Ext_gcd.linearEquatition(97,-127,1);
            int x=Ext_gcd.x;
            int y=Ext_gcd.y;
            //输出最短操作次数
            System.out.println(Math.abs(x) + Math.abs(y));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Ext_gcd { //私有静态类, 可以得到最基础的贝祖数
        static int x, y;

        static int egcd(int a, int b) {
            if (b == 0) { //返回条件
                x = 1;
                y = 0;
                return a;
            }

            int gcd = egcd(b, a % b);
            int x1 = x; //保存出栈后的上一个x
            x = y; //本次x=y1
            y = x1 - (a / b) * y; //y=x1-(a/b)y1
            return gcd;
        }

        static int linearEquatition(int a, int b, int m) throws Exception {
            int d = egcd(a, b);
            if (m % d != 0) {
                throw new Exception("无解");
            }
            int n = m / d;
            x *= n;
            y *= n;
            return d;
        }
    }

}
