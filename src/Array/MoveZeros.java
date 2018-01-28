package Array;

/**
 * Created by yyt on 2018/1/25.
 */

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int k = 0;
        for (int i = 0; i <N ; i++) {
            if(nums[i]!=0)
                nums[k++] = nums[i];
        }
        for (int i = k; i <N ; i++) {
            nums[i] = 0;
        }

    }


    public static void main(String[] args) {
        MoveZeros s = new MoveZeros();
        int [] a={0,1,0,0,3,4,5,0,0,7};
        s.moveZeroes(a);
        for(int e:a)
            System.out.println(e);
    }
}
