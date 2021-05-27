package 算法;

import java.util.Stack;

/**
 * @author ：Good_M
 * @date ：Created in 2021 2021/5/27 23:02
 */
public class 只借助栈结构对已知无序栈做排序 {


    public static Stack<Integer> sortStack(Stack<Integer> source){
        if (source == null || source.isEmpty() || source.size() == 1) {
            return source;
        }
        Stack<Integer> res = new Stack<>();
        Integer temp = null;
        while (!source.isEmpty()){
            if (temp == null) {
                temp = source.pop();
            }
            if (res.isEmpty() || temp >= res.peek()) {
                res.push(temp);
                temp = null;
            } else {
                source.push(res.pop());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(5);
        integers.push(2);
        integers.push(7);
        integers.push(3);
        integers.push(3);
        integers.push(9);
        integers.push(0);
        integers.push(2);
        System.out.println(sortStack(integers));
    }


}
