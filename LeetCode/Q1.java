package LeetCode;

import java.util.Arrays;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-21 21:00
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案
 **/
public class Q1 {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] num = new int[]{11,15,7,3, 4,2};
        System.out.println(Arrays.toString(s1.twoSum(num, 9)));
    }
}

class Solution1 {
    int[] arr = new int[2];

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }return arr;
    }
}

