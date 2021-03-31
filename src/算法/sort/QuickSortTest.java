package 算法.sort;

/**
 * @author ：Good_M
 * @date ：Created in 2020 2020/3/7 11:36
 *
 * 快排
 * 整体思路：
 * https://blog.csdn.net/qq_40941722/article/details/94396010
 */
public class QuickSortTest {




    void Quick_Sort(int[] arr, int begin, int end){
        if(begin > end) {
            return;
        }
        int tmp = arr[begin];
        int i = begin;
        int j = end;
        while(i != j){
            while(arr[j] >= tmp && j > i){
                j--;
            }
            while(arr[i] <= tmp && j > i){
                i++;
            }
            if(j > i){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[begin] = arr[i];
        arr[i] = tmp;
        Quick_Sort(arr, begin, i-1);
        Quick_Sort(arr, i+1, end);
    }
}
