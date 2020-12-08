import java.util.HashMap;
import java.util.Map;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/5
 * @time: 10:35
 * @description:
 **/
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                return new int[]{map.get(tmp),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }


    private static int[] twoSum3(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { map.get(complement), i };
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] B = new int[] {2, 5, 6};
        int[] A = twoSum2(B,7);
        for (int i = 0; i < A.length; i++) {
            System.out.print(B[i] + ",");
        }
    }

}
