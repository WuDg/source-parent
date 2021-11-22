package simple.arr;


/**
 *  @Description 4. 寻找两个正序数组的中位数
 *  https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *  @author wudiguang
 *  @Date 2021/11/22
 */ 
public class Demo004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(new Demo004().findMedianSortedArrays(nums1, nums2));;
    }

    /**
     * 思路1：nums1最小的和nums2最小的比较，去掉小的，保留大的。nums1最大的和nums2最大的比较，去掉大的，保留小的。
     * 思路2：拼接要给length为nums1长度和nums2长度之和的数组，再根据结果数组长度奇偶性来计算中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 结果数组
        int[] result = new int[length1 + length2];

        // 遍历nums1和nums2
        while(length1 > 0 || length2 > 0){
            // nums1和nums2未遍历完
            if(length1 > 0 && length2 > 0){
                boolean num1Big = nums1[length1 - 1] >= nums2[length2 - 1];
                result[length1 + length2 - 1] = num1Big ? nums1[--length1] : nums2[--length2];
            }else if(length2 > 0){
                // nums1遍历完，直接将nums2赋值给结果
                while(length2 > 0){
                    result[length2 - 1] = nums2[length2 - 1];
                    length2--;
                }
            }else if(length1 > 0){
                // nums2遍历完，直接将nums2赋值给结果
                while(length1 > 0){
                    result[length1 - 1] = nums1[length1 - 1];
                    length1--;
                }
            }
        }
        int length = result.length;
        //  偶数个
        if(length% 2 == 0){
            return (result[length/2] + result[length/2 - 1])/2.0;
        }else{
            return result[length/2];
        }
    }
}
