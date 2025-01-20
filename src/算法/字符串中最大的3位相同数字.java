package 算法;

/**
 * 【简单】
 * https://leetcode.cn/problems/largest-3-same-digit-number-in-string/description/?envType=daily-question&envId=2025-01-08
 *
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 *
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 *
 * 注意：
 *
 * 子字符串 是字符串中的一个连续字符序列。
 * num 或优质整数中可能存在 前导零 。
 *
 * @author ：Good_M
 * @date ：Created in 2025 2025/1/8 23:44
 */
public class 字符串中最大的3位相同数字 {

    public static void main(String[] args) {
//        System.out.println(largestGoodInteger("6777133339"));
//        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("00111"));
        System.out.println(largestGoodInteger("000"));//这个输出000也符合题意
        System.out.println(largestGoodInteger("11111"));//这个输出000也符合题意
    }


    public static String largestGoodInteger(String num) {
        int showTotal = 0;
        Character tempMaxNumber = null;
        char[] chars = num.toCharArray();
        for (int i = 1; i < chars.length - 1 ; i++) {
            if (chars[i] == chars[i-1]
                    && chars[i] == chars[i+1]
                    && (i+2 > chars.length -1 ||chars[i] != chars[i+2])//这一行是排除1111超过3个的情况，因为题干上写长度为3，描述有点模糊
                    && (i-2 < 0 ||chars[i] != chars[i-2])){
                if (tempMaxNumber == null || chars[i] > tempMaxNumber ){
                    tempMaxNumber = chars[i];
                }
            }
        }
        if (tempMaxNumber == null) {
            return "";
        }
        return tempMaxNumber.toString() +tempMaxNumber.toString() + tempMaxNumber.toString();
    }

    public static String largestGoodInteger2(String num) {//官方答案
        int n = num.length();
        String res = "";
        for (int i = 0; i < n - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String current = num.substring(i, i + 3);
                if (res.compareTo(current) < 0) {
                    res = current;
                }
            }
        }
        return res;
    }




}
