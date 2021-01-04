/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/14
 * @time: 16:16
 * @description:
 **/
public class 跳跃游戏2 {

    /**
     * 如果我们「贪心」地进行正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
     *
     * 例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，从下标 0 出发，最远可到达下标 2。下标 0 可到达的位置中，下标 1 的值是 3，从下标 1 出发可以达到更远的位置，因此第一步到达下标 1。
     *
     * 从下标 1 出发，最远可到达下标 4。下标 1 可到达的位置中，下标 4 的值是 4 ，从下标 4 出发可以达到更远的位置，因此第二步到达下标 4。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int canJump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //下标i最大可达位置，动态规划比较i 和 i- 1最大边界
            //如坐标0可到达位置1和2，但是通过下面一行可以看到，位置1可以到达更远的位置，所以maxPosition就是位置1的值
            maxPosition = Math.max(maxPosition, i + nums[i]);

            //找下标可到达的最远位置，以i=0为例，num2[0] = 2,可达位置为1，2，num[1],num【2】中num[1] = 3最大，第一步应该调到num[1]
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }




    public static void main(String[] args) {
//        int[] nums1 = {1,4,5,1,1,5,2,2,7,2,1,2,2,2};
        int[] nums1 = {2,3,1,2,4,2,3};
        System.out.println(canJump(nums1));
    }
}
