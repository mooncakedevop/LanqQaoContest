package 三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: _1
 * @description: 力扣三数之和
 * @author: mooncake
 * @create: 2020-06-12 14:29
 **/
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            int sum = -nums[i];
            int start = 0;
            int end = nums.length-1;
            while (start<end){

                if (nums[start]+nums[end]>sum){
                    end--;
                }else if(nums[start]+nums[end]<sum){
                    start++;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(start);
                    list.add(end);
                    res.add(list);
                    end--;
                }
            }
        }
        return res;
    }
}