package arrayAndMatrice;

public class 回形打印2DArray_B站 {
    /**
     * 分作上下左右四部分, 每次打印一圈, 为了保险计数, 等于矩阵元素数则跳出循环,结束
     * @param arr
     */

    /* 模板:
    * 终止条件,计数count<arr.length*arr[0].length--(最为保险的方式)
    *   1.最上行
    *   2.最右行
    *   3.最下行
    *   4.最左行
    * */
    static void printArr(int[][] arr){
        int leftUpRow=0,leftUPCol=0;
        int rightDownRow=arr.length-1, rightDownCol=arr[0].length-1;
        int r=0,c=0;
        int size=arr.length*arr[0].length;
        int count=0; //计数,防止超过数组数量重复遍历

        //终止条件,左上和右下角坐标错位,擦肩而过(或者count<arr.length*arr[0].length)
        while(leftUPCol<=rightDownCol&&leftUpRow<=rightDownRow){
            r=leftUpRow;c=leftUPCol; //每次都从左上角开始;

            /* 最上行 */
            while (c<=rightDownCol) {
                System.out.print(arr[r][c++] + " ");
                count++;
            }
            if (count==size) break;
            c = rightDownCol; //退出时越界一位,恢复;
            r++; //向下一位

            /* 最右行 */
            while(r<=rightDownRow) {
                System.out.print(arr[r++][c] + " ");
                count++;
            }
            if (count==size) break;
            r=rightDownRow;
            c--;

            /* 最下行 */
            while(c>=leftUPCol) {
                System.out.print(arr[r][c--] + " ");
                count++;
            }
            if (count==size) break;
            c=leftUPCol;
            r--;

            /* 最左行 --注意r>leftUpRow,因为左上角的那个点已经被最上行的打印了*/
            while (r>leftUpRow) {
                System.out.print(arr[r--][c] + " ");
                count++;
            }

            leftUpRow++;leftUPCol++;//打印了一圈后,左上角和右下角的坐标往中间移动一位
            rightDownRow--;rightDownCol--;
        }
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12}};
        printArr(arr);
    }
}
