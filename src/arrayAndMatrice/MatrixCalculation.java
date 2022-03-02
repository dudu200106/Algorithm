package arrayAndMatrice;

/** 设计两个方法,分别用来计算两个矩阵的加法和乘法:
 *  加法: matrixAdd(int[][] m1, int[][] m2);
 *  乘法: matrixMultiply(int[][] m1, int[][] m2);
 */
public class MatrixCalculation {
    static long[][] matrixAdd(int[][] m1, int[][] m2){
        int m=m1.length,n=m1[0].length;
        //矩阵相加必须是同形矩阵
        if (m!=m2.length||n!=m2[0].length) throw new IllegalArgumentException();
        long[][] res=new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j]=m1[i][j]+m2[i][j];
            }
        }
        return res;
    }

    static long[][] matrixMultiply(int[][] m1, int[][] m2){
        int m= m1.length,n1=m1[0].length;
        //矩阵乘法满足条件: M x N 与 N x P, 第一个矩阵的列数n,等于第二个矩阵的行数n
        if (n1!=m2.length) throw new IllegalArgumentException();
        int n= m2[0].length;
        long[][] res = new long[m][n];

        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j]+=m1[i][k]+m2[k][j];
                }
            }
        }
        return res;
    }
}
