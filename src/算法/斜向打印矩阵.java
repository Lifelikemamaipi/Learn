package 算法;

/**
 * @author ：Good_M
 * @date ：Created in 2024 2024/12/17 21:52
 * 将二维数组斜向打印，如
 * {
 *     {1,2,3},
 *     {4,5,6},
 *     {7,8,9},
 *     {10,11,12}
 * }
 * 输出结果为1、2、4、3、5、7、6、8、10、9、11、12
 *
 *
 *
 */
public class 斜向打印矩阵 {

    public static void main(String[] args) {
        int[][] a = {
                     {1,2,3},
                     {4,5,6},
                     {7,8,9},
                     {10,11,12}
                    };
        sidelingArray(a);

    }

    private static void sidelingArray(int[][] array){
        int one = array.length;
        int two = array[0].length;


        for (int i = 0; i < two; i++) {
            printElem(array,0,i);
        }

        for (int j = 1; j < one; j++) {
            printElem(array,j,two - 1);
        }

    }

    private static void printElem(int[][] array,int one,int two){
        for (;two >= 0 & one < array.length;){
            System.out.println(array[one][two]);
            one++;
            two--;
        }
    }








}
