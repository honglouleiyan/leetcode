import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/20
 * @time: 12:16
 * @description:
 **/
public class 打家劫舍 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2:
     *
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }


    /**
     * 紧紧是复制数组
     * @param num
     * @param i
     * @param j
     * @return
     */
    private static int[] copyInt(int[] num,int i,int j) {
        int[] result = new int[num.length-1];
        int m = 0;
        for(int k =i;k<j;k++) {
            result[m] = num[k];
             m++;

        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,1,22};
        System.out.println(rob(nums1));
        System.out.println(JSONObject.toJSONString(copyInt(nums1,0,nums1.length-1)));
    }
}
