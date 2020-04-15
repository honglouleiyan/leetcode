import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/3/22
 * @time: 10:48
 * @description:
 *
 **/
public class SolutionTwoNum {

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static List<int[]> twoNum(int[] nums,int target) {
        List<int[]> result = new ArrayList<int[]>();
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    result.add(new int[]{i,j});
                }
            }
        }

        return result;
    }


    /**
     * 优化后算法
     * @param nums
     * @param target
     * @return
     * 一趟hash,将遍历过的值放到map里面，然后后面的值一个个判断是不是有complement的值
     */
    public static List<int[]> twoNum2(int[] nums, int target) {
        List<int[]> result = new ArrayList<int[]>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add(new int[] { map.get(complement), i });
            }
            map.put(nums[i], i);
        }
        return  result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,3,6};
        int target = 9;
        System.out.println(JSONObject.toJSONString(twoNum(nums,target)));
        System.out.println(JSONObject.toJSONString(twoNum2(nums,target)));
    }
}
