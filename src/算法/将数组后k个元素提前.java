package 算法;

/**
 *
 * 将数组后k个元素放到数组最开始，只考虑空间复杂度
 * @author ：Good_M
 * @date ：Created in 2020 2020/7/2 21:16
 */
public class 将数组后k个元素提前 {

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 3, 4, 5 ,6 ,7};
        for (int i : revertPartArray(ints,3)) {
            System.out.println(i);
        }

    }

    /**
     * 先将数组整体反转，然后将数组从k的位置分成两段，然后再分别反转每一段
     * @param old   原数组
     * @param k     k
     * @return      结果
     */
    public static int[] revertPartArray(int[] old, int k){
        revertArray(old,0,old.length-1);
        revertArray(old,0,k-1);
        revertArray(old,k,old.length-1);
        return old;
    }

    public static int[] revertArray(int[] temp,int start,int end){
        for (;;start++,end--){
            if ( start >= end ) {
                return temp;
            }
            //使用位运算在不开辟空间的前提下交换两个数
            temp[start] = temp[start] ^ temp[end];
            temp[end] = temp[start] ^ temp[end];
            temp[start] = temp[start] ^ temp[end];
        }
    }

}
