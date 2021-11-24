package simple.arr;

/**
 *  @Description 整数反转
 *  https://leetcode-cn.com/problems/reverse-integer/
 *  @author wudiguang
 *  @Date 2021/11/24
 */
public class Demo007 {
    public static void main(String[] args) {
//        System.out.println(new Demo007().reverse(123));
//        System.out.println(new Demo007().reverse(-123));
//        System.out.println(new Demo007().reverse(120));
//        System.out.println(new Demo007().reverse(0));
        System.out.println(new Demo007().reverse(-1563847412));
    }
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        boolean isNegative = x < 0;
        x = isNegative ? -x : x;
        int radix = 10;
        int resultNum = 0;
        while(x > 0){
            // 判断是否溢出
            if(resultNum < Integer.MIN_VALUE / 10 || resultNum > Integer.MAX_VALUE / 10){
                return 0;
            }
            resultNum = resultNum * radix +  (x % 10);
            x/=10;
        }
        return isNegative ? -resultNum : resultNum;
    }
}
