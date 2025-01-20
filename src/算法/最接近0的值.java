package 算法;

/**
 * 【简单】https://leetcode.cn/problems/find-closest-number-to-zero/?envType=daily-question&envId=2025-01-20
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 *
 *
 * @author ：Good_M
 * @date ：Created in 2025 2025/1/20 22:01
 */
public class 最接近0的值 {

    public static void main(String[] args) {
        int[] a = {-4, -3, 2, 1,-1};
        System.out.println(findClosestNumber(a));
    }

    public static int findClosestNumber(int[] nums) {
        int finalRes = 0;
        Integer distance = null;

        for (int i = 0; i < nums.length; i++) {
            if (distance == null) {
                distance = Math.abs(nums[i]);
                finalRes = nums[i];
                continue;
            }
            if (Math.abs(nums[i]) < distance || (Math.abs(nums[i]) == distance && nums[i] > finalRes)) {
                distance = Math.abs(nums[i]);
                finalRes = nums[i];
            }
        }

        return finalRes;
    }
}
