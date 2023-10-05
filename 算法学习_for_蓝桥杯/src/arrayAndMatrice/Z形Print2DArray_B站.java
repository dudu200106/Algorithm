package arrayAndMatrice;

/**Z形打印数组
 * 思路: 在二维数组内上坡和下坡,遇到边界则向右或者向下
 */

/*模板:
* 上下坡标识:flag=true--下坡
* while(退出条件:row && col皆小于边界)
*   if(flag) //上坡
*       1.碰到上边界转向
*       2.碰到右上角转向
*       3.其余,只是上坡
*   if(flag) //下坡
*       ...
*       ...
*       ...
*
* */
public class Z形Print2DArray_B站 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}};
        boolean flag=true; //flag代表在数组内是上坡hash下坡
        int r=0,c=0;

        while (r<matrix.length&&c<matrix[0].length){
            if (flag){  //flag==true,上坡
                System.out.print(matrix[r][c]+" ");
                if(r==0&&c<matrix[0].length-1){ //撞到上边界,非右上角
                    c++;
                    flag=!flag; //转向
                }
                else if (c==matrix[0].length-1){
                    r++;
                    flag=!flag; //转向
                }
                else {
                    c++;
                    r--;
                }
            }else { //flag=false,下坡/
                System.out.print(matrix[r][c]+" ");
                if(r== matrix.length-1&&c>0){ //撞到下边界,非右下角
                    c++;
                    flag=!flag; //转向
                }
                else if (c==0){
                    r++;
                    flag=!flag; //转向
                }
                else {
                    c--;
                    r++;
                }
            }
        }
        System.out.println();

        /*for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/
    }
}
