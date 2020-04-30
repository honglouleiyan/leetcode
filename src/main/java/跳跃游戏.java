/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/27
 * @time: 17:08
 * @description:
 **/
public class 跳跃游戏 {
    public  static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,5,22};
        System.out.println(canJump(nums1));
    }

}
