package Array;

/**
 * Created by yyt on 2018/3/5.
 */
//Given an array of integers that is already sorted in ascending order, find two numbers
// such that they add up to a specific target number.
//
//        The function twoSum should return indices of the two numbers such that they add up
// to the target, where index1 must be less than index2. Please note that your returned answers
// (both index1 and index2) are not zero-based.
//
//        You may assume that each input would have exactly one solution and you may not use
// the same element twice.
//
//        Input: numbers={2, 7, 11, 15}, target=9
//        Output: index1=1, index2=2
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int N = numbers.length;
        int i = 0,j=N-1;
        int[] res = new int[2];
        while(i<j){
            int temp = numbers[i]+numbers[j];
            if(temp < target)
                i++;
            else if(temp > target)
                j--;
            else{
                res[0] = i;
                res[1] = j;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
