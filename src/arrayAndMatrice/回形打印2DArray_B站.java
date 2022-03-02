package arrayAndMatrice;

public class 回形打印2DArray_B站 {
    static void printArr(int[][] arr){
        int leftUpRow=0,leftUPCol=0;
        int rightDownRow=arr.length-1, rightDownCol=arr[0].length-1;
        int r=0,c=0;
        int size=arr.length*arr[0].length;
        int count=0; //计数,防止超过数组数量重复遍历

        //终止条件,左上和右下角坐标错位,擦肩而过(或者count<arr.length*arr[0].length)
        while(leftUPCol<=rightDownCol&&leftUpRow<=rightDownRow){
            r=leftUpRow;c=leftUPCol; //每次都从左上角开始;

            while (c<=rightDownCol) {
                System.out.print(arr[r][c++] + " ");
                count++;
            }
            if (count==size) break;
            c = rightDownCol; //退出时越界一位,恢复;
            r++; //向下一位

            while(r<=rightDownRow) {
                System.out.print(arr[r++][c] + " ");
                count++;
            }
            if (count==size) break;
            r=rightDownRow;
            c--;

            while(c>=leftUPCol) {
                System.out.print(arr[r][c--] + " ");
                count++;
            }
            if (count==size) break;
            c=leftUPCol;
            r--;

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
