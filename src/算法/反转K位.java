package 算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 入参数组[1,2,3,4,5,6]，第K位反转
 * k=3，出参：[3,2,1,6,5,4]
 * @author ：Good_M
 * @date ：Created in 2025 2025/1/14 21:17
 */
public class 反转K位 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        List<Integer> reverse = reverse(a, 3);
        System.out.println(reverse);
//        System.out.println(1+4%3);
    }

    public static List<Integer> reverse(int[] param,int k){
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < param.length; i++) {
            stack.add(param[i]);
            if ((i+1) % k == 0) {
                reverse(stack,res);
            }
        }

        return res;
    }

    private static void reverse(Stack<Integer> stack,List<Integer> res){
        while (!stack.empty()) {
            res.add(stack.pop());
        }
    }



}
