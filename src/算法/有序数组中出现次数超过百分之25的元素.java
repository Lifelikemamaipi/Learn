package 算法;

/**
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/comments/
 * @author ：Good_M
 * @date ：Created in 2021 2021/4/21 22:23
 */
public class 有序数组中出现次数超过百分之25的元素 {


    /**
     * 因为有序，所以超过x%，则当前值和连着的length的x%若相同则返回
     * @param arr
     * @return
     */
    public int findSpecialInteger(int[] arr) {
        for (int i = 0, len = arr.length / 4; i < arr.length - len; i++){
            if (arr[i] == arr[i + len]){
                return arr[i];
            }
        }
        return arr[0];
    }

}
