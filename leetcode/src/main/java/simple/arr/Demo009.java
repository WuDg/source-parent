package simple.arr;

/**
 *  @Description 回文数
 *  https://leetcode-cn.com/problems/palindrome-number/
 *  @author wudiguang
 *  @Date 2021/11/27
 */
public class Demo009 {
    public static void main(String[] args) {
//        System.out.println(new Demo009().isPalindrome(111));
        System.out.println(new Demo009().isPalindrome(1001));
    }
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < length/2; i++) {
            if(str.charAt(i) != str.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
