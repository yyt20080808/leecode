package Array;

/**
 * Created by yyt on 2018/1/16.
 */
public class CanJump {
    public CanJump() {

    }
    public boolean solutions(int[] nums){
        int N = nums.length;
        int maxJump = 0;
        for(int i = 0;i<=maxJump;i++){
            maxJump = Math.max(maxJump,i+nums[i]);
            if(maxJump>=N)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,1,1};
        CanJump canJump = new CanJump();
        System.out.print( canJump.solutions( nums ) );
    }
}
