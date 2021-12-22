import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *  @Description IP排序
 *  机器环境：4核16G
 *  测试结果：记录条数    |    比较次数    | 耗时/s
 *          5w             134967      1
 *          50w            1057863     4.6
 *          100w           2035374     8.6
 *          200w           3948947     16.9
 *  时间复杂度：n
 *  空间复杂度：n
 *  思路：利用IP和HashMap特性，即通过点号分割，每一段都是0~255的数字，HashMap对数字的查找时间为O(1)，且HashMap默认遍历的数值数据是有序的
 *  
 *  @author wudiguang
 *  @Date 2021/12/13
 */ 
public class IPsSort {
    private static Integer printCount = 0;
    private static Integer sortCount = 0;
    public static void main(String[] args) {
        String[] bigIps = initIps(50);
        long start = System.currentTimeMillis();
        new IPsSort().sortIPs(bigIps);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("打印循环次数:" + printCount);
        System.out.println("赋值循环次数:" + sortCount);
    }
    /**
     * 生成随机IP数组
     * @return
     */
    private static String[] initIps(Integer size) {
        String[] ips = new String[size];
        Random random = new Random();
        for (int i = 0; i < ips.length; i++) {
            String ip = String.format("%d.%d.%d.%d", random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextInt(255));
            ips[i] = ip;
        }
        return ips;
    }
    /**
     * ip排序
     * @param ips
     */
    public void sortIPs(String[] ips){
        Map<Integer, Node> rootMap = new HashMap<>(256);
        for (String ip : ips) {
            String[] split = ip.split("\\.");
            assert split.length > 3;
            Integer index = 0;
            // 如果根节点空值，则
            fillValue(rootMap, split, index);
        }
        print(rootMap, "", 0);
    }
    /**
     * 递归赋值
     * @param map
     * @param values
     * @param index
     */
    private void fillValue(Map<Integer, Node> map, String[] values, Integer index) {
        if(index > 3){
            return;
        }
        sortCount++;
        int value = Integer.parseInt(values[index]);
        if(!map.containsKey(value)){
            map.put(value, new Node(value));
        }
        if(map.get(value).next == null){
            map.get(value).next = new HashMap<>(256);
        }
        fillValue(map.get(value).next, values, index + 1);
    }
    /**
     * 遍历有序ip
     * @param map
     * @param ip
     * @param index
     */
    public void print(Map<Integer, Node> map, String ip, Integer index){
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            printCount++;
            if(entry.getValue() != null){
                String nowIp = ip + "." + entry.getKey();
                if(index >= 3){
                    System.out.println(nowIp.substring(1));
                }else {
                    print(entry.getValue().getNext(), nowIp, index + 1);
                }

            }
        }
    }
    @Data
    @NoArgsConstructor
    public static class Node{
        private Integer num;
        private Map<Integer, Node> next;

        public Node(Integer num) {
            this.num = num;
        }
    }
}

