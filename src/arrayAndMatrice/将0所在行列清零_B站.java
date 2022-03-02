package arrayAndMatrice;

public class 将0所在行列清零_B站 {
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},
                    {5,0,0,8},
                    {9,10,11,12}};
        int[] r=new int[arr.length];
        int[] c=new int[arr[0].length];

        //遍历,记录含有0的行,列
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==0){
                    r[i]=1;
                    c[j]=1;
                }
            }
        }
        //遍历,若是是0的行和列,用零覆盖
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (r[i]==1||c[j]==1){
                    arr[i][j]=0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
