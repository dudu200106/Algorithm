import java.util.ArrayList;
import java.util.List;

/**
 * 使用栈 st 模拟行星碰撞，从左往右遍历行星数组 asteroids，
 * 当我们遍历到行星 aster 时，使用变量 alive记录行星 aster 是否还存在（即未爆炸）。
 *
 * 当行星 aster 存在且 aster<0，栈顶元素非空且大于 0 时，说明两个行星相互向对方移动：
 *      如果栈顶元素大于等于 −aster，则行星 aster发生爆炸，将 alive 置为 false；
 *      如果栈顶元素小于等于 −aster，则栈顶元素表示的行星发生爆炸，执行出栈操作。
 *
 * 重复以上判断直到不满足条件，如果最后 alive 为真，说明行星 aster 不会爆炸，则将 aster 入栈。
 *
 */
public class _735_小行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        int row = -1;
        for (int num : asteroids){
            if (num>0){
                stack.add(num);
                row++;
            }else {
                if (row==-1){
                    stack.add(num);
                    row++;
                    continue;
                }
                while (row>= -1 ){
                    if (row==-1 || stack.get(row)<0){
                        stack.add(num);
                        row++;
                        break;
                    }
                    if (stack.get(row)< -num){
                        stack.remove(row--);
                    }else if (stack.get(row) == -num){
                        stack.remove(row--);
                        break;
                    }else {
                        break;
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }

    /**
     * 改进版本
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision_2(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        int row = -1;
        for (int num : asteroids){
            boolean alive = true;
            while (num<0 && alive && !stack.isEmpty() && stack.get(row)>0){
                alive = stack.get(row) < -num;
                if (stack.get(row) <= -num){
                    stack.remove(row--);
                }
            }
            if (alive){
                stack.add(num);
                row++;
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }
}
