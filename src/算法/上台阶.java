package 算法;

/**
 * 动态规划
 * 核心是寻找：1、最优子结构；2、边界；3、本次结果和最优子结构的关系式
 * https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg
 * @author ：Good_M
 * @date ：Created in 2020 2020/7/6 11:37
 */
public class 上台阶 {


    public static void main(String[] args) {
        System.out.println(climbStairs(34));
    }


    /**
     * 上台阶，每次上1或2，有几种上法
     * @param n 台阶数
     * @return 方法数
     */
    private static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        //离本次台阶还需1步，有几种方式
        int one = 2;
        //离本次台阶还需1步，有几种方式
        int two = 1;
        int result = 0;
        for (int i = 3; i <= n; i++){
            result = one + two;
            two = one;
            one = result;
        }
        return result;
    }








}
