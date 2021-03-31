package 算法.sort;

/**
 * @author ：Good_M
 * @date ：Created in 2020 2020/3/7 10:37
 *
 * 希尔排序（该例子为正向排序的例子）
 *
 *
 *
 * 大致思路为从数组的一半开始，拿数组当前遍历到的元素，与上一个间隔的元素做比较，
 * 如果比上一个元素小则把上一个元素放到目前遍历的位置上，然后游标向上一个间隔做移动，再比较上上个间隔和当前位置的大小，以此类对
 * 最终间隔变为1，那么会挨个元素和前一个元素进行比较
 *
 *
 *
 * 其实当间隔为1是就是插入排序，本质上希尔排序就是插入排序的升级版，可以理解为他在插入排序前预处理了数组，使其比原始的数组更加有序一些
 * 以此来提高插入排序的效率
 *
 * 博客：
 * https://blog.csdn.net/weixin_41190227/article/details/86600821
 *
 */
public class ShellSortTest {


    public static void main(String[] args) {
        int[] old = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] ints = ShellSort(old);
        System.out.println(ints);
    }


    public static int[] ShellSort(int[] array) {
        int len = array.length;
        //从数组的一半开始，gap为当前游标和上一个数组元素的间隔
        int temp, gap = len / 2;
        while (gap > 0) {
            //控制游标的移动
            for (int i = gap; i < len; i++) {
                //取出当前游标所对应的元素
                temp = array[i];
                //确定当前游标上一个间隔的元素的位置，比如现在角标是5，间隔也是5，那么上一个元素的下标就是5-5=0
                int preIndex = i - gap;
                //这个循环主要判断是否存在上一个元素，以及上一元素是不是比当前元素大（正向排序的话，倒排则相反）
                //如果大的话则把上一个元素放到当前的位置，再去找上上个元素是不是我temp大
                //这块整体可以理解为：我这个一开始取出来的temp元素应该放在哪里，而不是对这次间隔所有的元素进行排序
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                //这一步是把找到位置的temp放在位置上
                array[preIndex + gap] = temp;
            }
            //缩小间隔继续查找
            gap /= 2;
        }
        return array;
    }
}
