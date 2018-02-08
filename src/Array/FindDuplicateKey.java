package Array;

public class FindDuplicateKey {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args){
        FindDuplicateKey f = new FindDuplicateKey();
        int[] nums = {2,1,3,4,7,6,8,9,10};
        f.findDuplicate(nums);
    }

}
