package hello.leet;

import java.util.HashSet;

/**
 * @author karl xie
 */
public class Solution {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (!integers.add(num)){
                return true;
            }
        }
        return false;
    }


    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a ={1,2,3,4};
        System.out.println(containsDuplicate(a));
    }
}