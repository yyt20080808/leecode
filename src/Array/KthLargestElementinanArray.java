package Array;

/**
 * Created by yyt on 2018/1/25.
 */
public class KthLargestElementinanArray {
    public KthLargestElementinanArray() {

    }

    public int findKthLargest(int[] nums, int key) {
        int N = nums.length;
        int i = partication( nums,0,N-1 );
        int low = 0;
        int high = N-1;
        key = N - key;
        while(i != key){
            if (i > key)
                high = i-1;
            else
                low = i+1;
            i = partication( nums,low,high );
        }
        return nums[key];
    }

    public int partication(int[] nums, int low, int high) {
        int key = nums[low];
        int i = low+1;
        int j = high;
        if(i==j )
            if(nums[low]< nums[high])
                return low;
            else {
                exchange( nums,low,high);
                return high;
            }

        while (i<j) {
             while( j > low ){
                 // 说明j 很小
                if(key > nums[j])
                    break;
                j--;
             }
            while (i < high){
                 // 说明i很大
                if(key < nums[i])
                    break;
                i++;
            }
            if (i < j) {
                exchange( nums, i, j );
            }
            else
                exchange( nums, low, j );
        }
        return j;
    }

    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        int N = 7;

        for(int i = 1;i<=N;i++){
            int []nums = new int[]{5,5,3,2,7,1,6};
            System.out.println(k.findKthLargest( nums,i ));
        }
    }
}
