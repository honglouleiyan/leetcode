import java.util.Arrays;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/5
 * @time: 17:36
 * @description:
 **/
public class 打家劫舍2 {


    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //针对只有一个长度的【0】  因为下面要复制数组
        if(nums.length == 1){
            return nums[0];
        }
        int begin = 打家劫舍.rob(Arrays.copyOfRange(nums,0,nums.length-1));
        int end = 打家劫舍.rob( Arrays.copyOfRange(nums,1,nums.length) );
        if(begin > end) {
            return begin;
        } else {
            return end;
        }
    }


}
