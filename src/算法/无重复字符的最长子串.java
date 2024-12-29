package 算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author ：Good_M
 * @date ：Created in 2024 2024/12/29 11:11
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(a));
        String a2 = "bbbbbbb";
        System.out.println(lengthOfLongestSubstring(a2));
        String a3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(a3));
        String a4 = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(a4));
    }


    public static int lengthOfLongestSubstring(String s) {
        char[] split = s.toCharArray();
        if (split.length < 2) {
            return split.length;
        }
        int start = 0;
        int finalRes = 0;

        Map<Character, Integer> strIndexMap = new HashMap<>();
        strIndexMap.put(split[start],start);
        for (int end = 1; end < split.length;) {
            Character currentElem = split[end];
            if (!strIndexMap.containsKey(currentElem)) {
                if (end - start + 1 > finalRes) {
                    finalRes = end - start + 1;
                }
                strIndexMap.put(currentElem,end);
                end++;
                continue;
            }

            Integer preIndex = strIndexMap.get(currentElem);
            if (preIndex < start) {
                if (end - start + 1 > finalRes) {
                    finalRes = end - start + 1;
                }
                strIndexMap.put(currentElem,end);
                end++;
                continue;
            }

            if (end - start > finalRes) {
                finalRes = end - start;
            }
            start = preIndex + 1;
            strIndexMap.put(currentElem,end);
            end++;

        }
        return finalRes;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }



}
