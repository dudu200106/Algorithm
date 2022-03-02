package arrayAndMatrice;

public class 边界为1的最大square_B站 {
    public static void main(String[] args) {
        int[][] matric={{0,0,1,1,0},
                        {0,1,1,0,0},
                        {1,1,0,1,0},
                        {1,0,1,1,0}};
        System.out.println(solve(matric));
    }

    static int solve(int[][] arr){
        int n=arr.length;
        while(n>0){ //from 5 to 0
            for (int i = 0; i <=arr.length-n; i++) {
                l3:
                for(int j = 0; j <=arr.length-n; j++) {
                    int r=i;
                    int c=j;
                    while(c<j+n){ //上
                        if (arr[r][c]==0) continue l3;
                        c++;
                    }
                    c--;
                    while(r<i+n){ //现在来到了右边
                        if (arr[r][c]==0) continue l3;
                        r++;
                    }
                    r--;
                    while(c>=j){ //现在来到了下边
                        if (arr[r][c]==0) continue l3;
                        c--;
                    }
                    c++;
                    while(r>=i){ //现在来到了左边
                        if (arr[r][c]==0) continue l3;
                        r--;
                    }
                    return n; //到了这里还没跳,说明满足条件
                }
            }
            n--;
        }
        return n;
    }
}
