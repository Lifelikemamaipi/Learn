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
            if (!strIndexMap.containsKey(currentElem)) {//如果之前没有出现过该元素，就直接计算目前子串长度，并把当前元素和坐标添加到map中
                if (end - start + 1 > finalRes) {
                    finalRes = end - start + 1;
                }
                strIndexMap.put(currentElem,end);
                end++;
                continue;
            }
            //如果之前出现过该元素，需要判断这个出现的元素是否还在当前正在处理的子串（滑动窗口）中
            Integer preIndex = strIndexMap.get(currentElem);
            if (preIndex < start) {//判断之前出现的元素的坐标和当前滑动窗口起始位置的关系
                //如果不在当前窗口中，说明已经不必要了，可以忽略，按没有出现处理，覆盖之前出现的元素坐标
                if (end - start + 1 > finalRes) {
                    finalRes = end - start + 1;
                }
                strIndexMap.put(currentElem,end);
                end++;
                continue;
            }
            //如果出现在当前滑动窗口中，先计算重复的两个元素间的长度
            if (end - start > finalRes) {
                finalRes = end - start;
            }
            //然后将窗口起始位置挪到当前重复元素+1，并将当前元素记录到map中
            start = preIndex + 1;
            strIndexMap.put(currentElem,end);
            end++;

        }
        return finalRes;
    }


    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length() ; i++)
        {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i)))
            {
                left = Math.max(left , map.get(s.charAt(i))+1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
        }

        return maxLen;
    }



}
