package 算法;

/**
 * 【简单】
 * https://leetcode.cn/problems/number-of-changing-keys/description/?envType=daily-question&envId=2025-01-07
 *
 * 给你一个下标从 0 开始的字符串 s ，该字符串由用户输入。按键变更的定义是：使用与上次使用的按键不同的键。例如 s = "ab" 表示按键变更一次，而 s = "bBBb" 不存在按键变更。
 *
 * 返回用户输入过程中按键变更的次数。
 *
 * 注意：shift 或 caps lock 等修饰键不计入按键变更，也就是说，如果用户先输入字母 'a' 然后输入字母 'A' ，不算作按键变更。
 *
 *
 * @author ：Good_M
 * @date ：Created in 2025 2025/1/7 23:01
 */
public class 按键变更次数 {

    public static void main(String[] args) {
        System.out.println(countKeyChanges("aAbBcC"));
        System.out.println(countKeyChanges("AaAaAaaA"));
        System.out.println(countKeyChanges("bBBb"));
    }


    public static int countKeyChanges(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int changeTimes = 0;
        char lastChangeChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != lastChangeChar) {
                changeTimes++;
            }
            lastChangeChar = chars[i];
        }
        return changeTimes;
    }

}
