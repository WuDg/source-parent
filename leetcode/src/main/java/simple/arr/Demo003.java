package simple.arr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  @Description 最长不重复字符串
 *  https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *  
 *  @author wudiguang
 *  @Date 2021/11/20
 */ 
public class Demo003 {
    public static void main(String[] args) {
        new Demo003().lengthOfLongestSubstring1("abcabcbccsdcklasdhasjkhgag");
    }

    /**
     * 双重循环
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int biggestCount = 0;
        int circuit = 0;
        char[] chars = s.toCharArray();
        if(chars.length == 1){
            return 1;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int count = 1;
            Set<Character> set = new HashSet<>(16);
            set.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                circuit++;
                int oldSize = set.size();
                set.add(chars[j]);
                int newSize = set.size();
                if(oldSize == newSize){
                    System.out.println("起始下标:" + i + "开头的字符串开始重复，重复下标为:" + j);
                    break;
                }
                count++;
            }
            System.out.println("起始下标:" + i + "开头的字符串最长数量:" + count);
            biggestCount = Math.max(count, biggestCount);
        }
        System.out.println("循环次数："+ circuit);
        return biggestCount;
    }

    /**
     * 质量较差
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int biggestCount = 0;

        if(s.length() <= 1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        int start = 0, now = 1;
        Map<Character, Integer> map = new HashMap<>(16);
        map.put(chars[start], start);
        int count = 1;
        int circuit = 0;
        while(start < chars.length && now < chars.length){
            circuit++;
            int oldSize = map.size();
            Integer oldIndex = map.get(chars[now]);
            if(null != oldIndex && oldIndex < start){
                map.remove(chars[now]);
                oldIndex = null;
            }
            map.put(chars[now], now);
            int newSize = map.size();
            if(null != oldIndex && oldSize == newSize && oldIndex != now){
                System.out.println("起始下标:" + start + "开头的字符串开始重复，重复下标为:" + now);
                biggestCount = Math.max(count, biggestCount);

                if(start != oldIndex){
//                    map.put(chars[now], oldIndex);
                    map.put(chars[now], now);
                    count -= (oldIndex + 1) - start;
                    start = oldIndex + 1;
                }else {
                    start++;
                    count--;
                }
            }else {
                now++;
                count++;
                biggestCount = Math.max(count, biggestCount);
            }
            if(start == now){
                count++;
                now++;
            }
        }
        System.out.println("循环次数："+ circuit);
        return biggestCount;
    }

    /**
     * 循环次数少
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        int start = 0, now = 1;
        Map<Character, Integer> map = new HashMap<>(16);
        map.put(chars[start], start);
        int count = 1;
        int biggestCount = 1;
        int circuit = 0;
        while(start < chars.length && now < chars.length){
            circuit++;
            Integer existIndex = map.get(chars[now]);
            map.put(chars[now], now);
            if(null != existIndex){
                if(existIndex >= start){
                    System.out.println("起始下标:" + start + "开头的字符串开始重复，重复下标为:" + now);
                    count -= existIndex - start;
                    start = existIndex + 1;
                }else {
                    count++;
                }
            }else {
                count++;
            }
            now++;
            biggestCount = Math.max(count, biggestCount);

        }
        System.out.println("循环次数："+ circuit);
        return biggestCount;
    }

    /**
     * 官方解答
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        int circuit = 0;
        for (int i = 0; i < n; ++i) {
            circuit++;
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        System.out.println("循环次数："+ circuit);
        return ans;
    }
}
