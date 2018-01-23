package Array;

/**
 * Created by yyt on 2018/1/23.
 */
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//        You may assume that the array is non-empty and the majority element always exist in the array.

public class MajorityElement {
    public MajorityElement() {

    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i])
                count++;
            else
                count--;
        }
        return major;
    }


    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] nums = {3,2, 1, 2,  3, 3, 4};
        System.out.print( m.majorityElement( nums ) );

    }
}
