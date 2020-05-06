import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/5
 * @time: 17:55
 * @description:
 **/
public class 四数之和 {

    public static List<List<Integer>> sun(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) {
            return result;
        }
        int size = nums.length;
        int c,d;
        for (int i = 0; i < size-4; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j= i + 1; j < size-3; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                c = j+1;
                d= size-1;
                while (c < d) {
                    if(nums[i] + nums[j] + nums[c] + nums[d] < target) {
                        c++;
                    } else if(nums[i] + nums[j] + nums[c] + nums[d] > target) {
                        d--;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j] );
                        temp.add(nums[c]);
                        temp.add(nums[d]);
                        result.add(temp);
                        while (c < d && nums[c] == nums[c+1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d-1]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int [] input = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(JSONObject.toJSONString(sun(input,target)));
    }
}
