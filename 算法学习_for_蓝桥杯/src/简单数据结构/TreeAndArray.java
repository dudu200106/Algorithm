package 简单数据结构;

public class TreeAndArray {

    /**
     * 二叉堆，默认数组已经堆化，；
     * 1.若i为父节点下标，二子节点：2i+1,2i+2;
     * 2.若n为孩子节点,父节点: (n-1)/2 (int类型除法)
     * @param arr
     * @param index
     */

    /*先序遍历*/
    public static void preOrder(int[] arr, int index){ //其中，数组表示数据的“物理存储位置”，index是目前节点下标
        if(index>=arr.length) //退出条件,index的子节点越界,说明index就是叶子结点
            return;
        System.out.print(arr[index] +" "); //出栈时的输出位置正好体现了遍历的名称
        preOrder(arr,2*index+1);
        preOrder(arr,2*index+2);
    }

    /*中序遍历*/
    public static void inOrder(int[] arr, int index){
        if(index>=arr.length)
            return;
        preOrder(arr,2*index+1);
        System.out.println(arr[index]);
        System.out.print(arr[index] +" ");
    }

    /*后序遍历*/
    public static void laterOrder(int[] arr, int index){
        if(index>=arr.length)
            return;
        preOrder(arr,2*index+1);
        preOrder(arr,2*index+2);
        System.out.print(arr[index] +" ");
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }

        preOrder(arg,0);
    }
}

