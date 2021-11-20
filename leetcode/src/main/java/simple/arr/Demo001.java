package simple.arr;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 *  @Description
 *
 *  https://leetcode-cn.com/problems/two-sum/
 *
 *  @author wudiguang
 *  @Date 2021/11/19
 */

public class Demo001 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] result = new Demo001().twoSum1(nums, 6);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 使用简单双层遍历
     * @param nums 数组
     * @param target 目标值
     * @return 返回符合调整数值的下标
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 利用 HashMap 原理，遍历nums 的同时，在 Map 中查找 target-nums[i] 的值，不存在则将 map.put(num[i],i),存在则直接返回
     * @param nums 数组
     * @param target 目标值
     * @return 返回符合调整数值的下标
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            // 判断 map 中是否存在 key = target - nums[i]
            if(map.containsKey(target - nums[i])){
                // 存在则找到目标数据
                return new int[]{map.get(target - nums[i]), i};
            }
            // 不存在则把 nums[i] put到 map中
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
