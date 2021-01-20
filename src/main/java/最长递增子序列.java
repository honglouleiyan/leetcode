import java.util.Arrays;

/**
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/20
 * @time: 15:41
 * @description:
 **/
public class 最长递增子序列 {


    /**
     * dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
     *当 nums[i] > nums[j] 时： nums[i]可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1 ；
     * 当 nums[i] <= nums[j] 时： nums[i] 无法接在 nums[j]之后，此情况上升子序列不成立，跳过。
     *
     *
     * 上述所有 1. 情况 下计算出的 dp[j] + 1dp[j]+1 的最大值，为直到 ii 的最长上升子序列长度（即 dp[i]dp[i] ）。实现方式为遍历 jj 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)dp[i]=max(dp[i],dp[j]+1)。
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     *
     *
     * dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1
     *返回 dpdp 列表最大值，即可得到全局最长上升子序列长度
     *
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        if(nums.length == 0)  {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if(res == j) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,-4,5,22};
        System.out.println(lengthOfLIS1(nums1));
    }

}
