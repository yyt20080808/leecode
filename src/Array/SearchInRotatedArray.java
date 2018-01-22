package Array;

/**
 * Created by yyt on 2018/1/19.
 */
public class SearchInRotatedArray {
    public SearchInRotatedArray() {

    }

    public int search(int[] nums, int target) {
        int N = nums.length;
        int low = 0, high = N - 1;
        int rot;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        rot = low;
        low = 0;
        high = N - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int realmid = (mid + rot) % N;
            if (target == nums[realmid])
                return realmid;
            else if (nums[realmid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedArray s = new SearchInRotatedArray();
        int[] a = {4, 5, 7, 8, 9, -2, 1, 2, 3};
        for (int e : a)
            System.out.println( s.search( a, e ) );
    }
}
