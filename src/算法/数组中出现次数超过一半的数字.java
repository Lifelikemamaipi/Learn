package 算法;

/**
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 * @author ：Good_M
 * @date ：Created in 2021 2021/4/21 22:06
 */
public class 数组中出现次数超过一半的数字 {


    /**
     * 摩尔投票
     * 思路：记录当前出现次数最多的数字，如果后面和出现最多的数字不相同，就把票数减一
     *      相当于不同的元素进行对消
     * 只能解数组中一定有超过一半的数字
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        //出现最多的数字
        Integer showMostNum = null;
        //当前数字出现的次数（投票）
        int curShowTime = 0;
        for (int num : nums) {
            //如果当前票数为0，就把当前数字当做出现次数最高的数字
            if (curShowTime == 0) {
                showMostNum = num;
            }
            //如果和之前当前出现最多的数字一样，就把出现次数+1，否则-1，相当于对消
            curShowTime += num == showMostNum ? 1 : -1;
        }
        return showMostNum;
    }

    /**
     * 正常思路
     * 先对数组进行升序排序，那么如果有出现超过一半的数字，那他必定出现在中间，所以只需要看中间数字次数是否超过数组一半即可
     * 这种解法可以适用于数组中不一定有出现超一半的数字
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        //出现最多的数字
        Integer showMostNum = null;
        //当前数字出现的次数（投票）
        int curShowTime = 0;
        for (int num : nums) {
            //如果当前票数为0，就把当前数字当做出现次数最高的数字
            if (curShowTime == 0) {
                showMostNum = num;
            }
            //如果和之前当前出现最多的数字一样，就把出现次数+1，否则-1，相当于对消
            curShowTime += num == showMostNum ? 1 : -1;
        }
        return showMostNum;
    }



    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }


}
