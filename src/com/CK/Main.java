package com.CK;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;

        int slow = 0, fast = 0, sum = 0, min = Integer.MAX_VALUE, count = 0;
        for (fast = 0; fast < size; fast++) {
            sum += nums[fast];
            count++;
            if (sum < s)
                continue;

            while (sum >= s) {
                min = Math.min(min, count);
                sum -= nums[slow];
                count--;
                slow++;
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}