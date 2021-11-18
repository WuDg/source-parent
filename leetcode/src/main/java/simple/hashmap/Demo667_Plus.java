package simple.hashmap;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

class Demo667_Plus {

    public Demo667_Plus() {

    }

    /**
     * 插入
     * @param key
     * @param val
     */
    public void insert(String key, int val) {

        insertTree(key, val, roots);
    }

    /**
     * 构建前缀树
     * @param key
     * @param val
     * @param roots
     */
    private void insertTree(String key, int val, Map<Character, Node> roots) {
        for (int i = 0; i < key.length(); i++) {
            Node node = searchTree(key.substring(0, i + 1), roots);
            if(Objects.isNull(node)){
                node = new Node();
                node.setSum(val);
                node.setLetter(key.charAt(i));
                roots.put(key.charAt(i), node);
            }else {
                Map<Character, Node> childs = node.getChild();
                if(Objects.isNull(childs) || childs.isEmpty()){
                    childs = new HashMap<>(16);
                    Node child = new Node();
                    child.setSum(val);
                    child.setLetter(key.charAt(i));
                    child.setParent(node);
                    childs.put(key.charAt(i), child);
                }else{
                    if(node.getLetter().equals(key.charAt(i))){
                        node.setSum(node.getSum() + val);
                    }else {
                        Node child = childs.get(key.charAt(i));
                        if(Objects.isNull(child)){
                            child = new Node();
                            child.setSum(val);
                            child.setLetter(key.charAt(i));
                            child.setParent(node);
                            childs.put(key.charAt(i), child);
                        }else {
                            child.setSum(val + child.getSum());
                            child.setLetter(key.charAt(i));
                            childs.put(key.charAt(i), child);
                        }
                    }
                }
                node.setChild(childs);
            }
        }
    }

    /**
     * 前缀树中查找字符串节点所在位置
     * @param key
     * @param roots
     * @return
     */
    private Node searchTree(String key, Map<Character, Node> roots) {
        int length = 0;
        Node node = null;
        while(length < key.length()){
            node = roots.get(key.charAt(length));
            if(length == 0 && Objects.isNull(node)){
                return null;
            }else if((!Objects.isNull(node) && Objects.isNull(node.child)) || key.length() == 1){
                break;
            }else if(length == 0){
                node= searchTree(key.substring(length + 1), node.getChild());
                if(!Objects.isNull(node) || (length + 1) == (key.length() - 1)){
                    break;
                }
            }else if(Objects.isNull(node)){
                break;
            }
            length ++;
        }
        return node;
    }

    /**
     * 求和
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        int sum = 0;

        return sum;
    }

    public static void main(String[] args) {
        Demo667_Plus mapSum = new Demo667_Plus();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        mapSum.insert("app", 3);
        mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
    }
    
    private Map<Character, Node> roots = new HashMap<>(16);
    

    @Data
    private static class Node{
        /**
         * 节点字符
         */
        private Character letter;
        /**
         * 节点对应总和
         */
        private Integer sum;

        /**
         * 最新值
         */
        private Integer newVal;

        /**
         * 字符串
         */
        private String key;

        /**
         * 子节点
         */
        private Map<Character, Node> child;

        /**
         * 父节点
         */
        private Node parent;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */