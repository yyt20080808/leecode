package Array;

/**
 * Created by yyt on 2018/2/1.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int nums[]) {
        int walker = nums[0], runner = nums[nums[0]];
        while (walker != runner) {
            walker = nums[walker];
            runner = nums[nums[runner]];
        }
        runner = 0;
        while(walker!= runner){
            walker = nums[walker];
            runner = nums[runner];
        }
        return walker;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,5,7,6,4,2};
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        f.findDuplicate( nums );
    }
}
