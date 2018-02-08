package Greedy;

/**
 * Created by yyt on 2018/2/7.
 */
//There are N gas stations along a circular route, where the amount of gas at
// station i is gas[i].
//
//        You have a car with an unlimited gas tank and it costs cost[i] of gas t
// o travel from station i to its next station (i+1). You begin the journey with an
// empty tank at one of the gas stations.
//
//        Return the starting gas station's index if you can travel around the
// circuit once, otherwise return -1.
//
//        Note:
//        The solution is guaranteed to be unique.
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int start = N-1;
        int end = 0;
        for(int i = 0;i<N;i++)
            gas[i] = gas[i] - cost[i];
        int sum = gas[start];
        while(end < start){
            if(sum >= 0){
                sum += gas[end];
                end++;
            }else{
                start--;
                sum += gas[start];
            }
        }
        if(sum >= 0)
            return start;
        return -1;
    }

    public static void main(String[] args) {
        GasStation c = new GasStation();
        int[] gas = {5,4,3,6};
        int[] cost = {6,6,6,3};
        System.out.println(c.canCompleteCircuit( gas,cost ));
    }
}
