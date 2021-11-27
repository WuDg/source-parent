package simple.arr;

import java.util.Objects;

/**
 *  @Description 字符串转换整数 (atoi)
 *  https://leetcode-cn.com/problems/string-to-integer-atoi/
 *  @author wudiguang
 *  @Date 2021/11/27
 */
public class Demo008 {
    public static void main(String[] args) {
//        System.out.println(new Demo008().myAtoi("495"));
//        System.out.println(new Demo008().myAtoi("   -42"));
        System.out.println(new Demo008().myAtoi("   4193 with words"));
//        System.out.println(new Demo008().myAtoi("words and 987"));
//        System.out.println(new Demo008().myAtoi("-91283472332"));
//        System.out.println(new Demo008().myAtoi("2147483648"));
//        System.out.println(new Demo008().myAtoi("2147483646"));
    }
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        char firstChar = s.charAt(0);
        int value = 0;
        boolean isNegative;
        if(Objects.equals('-', firstChar)){
            isNegative = true;
        }else if(Objects.equals('+', firstChar)){
            isNegative = false;
        }else if((firstChar >= '0' && firstChar <= '9')) {
            isNegative = false;
            value = firstChar - '0';
        } else{
            return 0;
        }

        int index = 1;
        while(index < s.length()){
            char nowChar = s.charAt(index);
            boolean isNum = nowChar >= '0' && nowChar <= '9';
            if(!isNum){
                break;
            }
            if(isNegative && -value < (Integer.MIN_VALUE + (nowChar - '0')) / 10){
                return Integer.MIN_VALUE;
            }else if(!isNegative &&  value > (Integer.MAX_VALUE - (nowChar - '0')) / 10){
                return Integer.MAX_VALUE;
            }
            if(isNum) {
                value = 10 * value + (nowChar - '0');
            }
            index++;
        }

        return isNegative ? -value : value;
    }
}
