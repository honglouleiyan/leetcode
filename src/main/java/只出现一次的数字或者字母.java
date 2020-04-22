import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字或者字母
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/17
 * @time: 16:53
 * @description:
 **/
public class 只出现一次的数字或者字母 {

    /**
     * hash表
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,1,22};
        System.out.println(singleNumber(nums1));
    }



}
