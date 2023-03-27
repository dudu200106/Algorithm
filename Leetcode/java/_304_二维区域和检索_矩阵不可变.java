public class _304_二维区域和检索_矩阵不可变 {
    public static int[][] preSum;

    /** 在构造方法中预处理前缀和*/
    public _304_二维区域和检索_矩阵不可变(int[][] matrix) {

        int m =matrix.length;
        int n =matrix[0].length;
        preSum= new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                        + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    /**
     * 计算矩阵区间和
     * @param row1
     * @param col1 左上角
     * @param row2
     * @param col2 右下角
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (preSum[row2+1][col2+1] - preSum[row2+1][col1]
                - preSum[row1][col2+1]) + preSum[row1][col1];
    }
}
