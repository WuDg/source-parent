package simple.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *  @Description
 *
 * https://leetcode-cn.com/problems/map-sum-pairs/
 *  实现一个 MapSum 类，支持两个方法，insert和sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 思考
 * 时间复杂度：insert 方法最优，无法优化，sum 方法暂无办法
 * 空间复杂度：insert 方法最优，sum方法最优
 *
 * 题解：前缀 HASH
 *  @author wudiguang
 *  @Date 2021/11/15
 */ 

class Demo667 {

    /**
     * 定义 map
     */
    private final Map<String, Integer> map = new HashMap<>(16);

    public Demo667() {

    }

    /**
     * 插入
     * @param key
     * @param val
     */
    public void insert(String key, int val) {
        map.put(key, val);
    }

    /**
     * 求和
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)){
                sum += entry.getValue();
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        Demo667 mapSum = new Demo667();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        mapSum.insert("app", 3);
        mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */