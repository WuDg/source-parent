package middle;

import java.util.*;

/**
 *  @Description 找到字符串中所有字母异位词
 *  https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class Demo438 {
    public static void main(String[] args) {
        System.out.println(new Demo438().findAnagrams("abcaaabc", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
