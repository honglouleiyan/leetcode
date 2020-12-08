/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/18
 * @time: 18:59
 * @description:
 **/
public class 接雨水 {


    /**
     * 求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
     *
     * 装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
     *
     * 所以，根据较矮的那个墙和当前列的墙的高度可以分为三种情况。
     *中间数为当前墙，左边右边的数代表
     *
     * 1、较矮的墙的高度大于当前列的墙的高度
     * 如213
     * 很明显，较矮的一边，也就是左边的墙的高度，减去当前列的高度就可以了，也就是 2 - 1 = 1，可以存一个单位的水。
     *
     * 2、较矮的墙的高度小于当前列的墙的高度
     * 如123
     * 想象下，往两边最高的墙之间注水。正在求的列会有多少水？
     * 正在求的列不会有水，因为它大于了两边较矮的墙。
     *
     * 3、较矮的墙的高度等于当前列的墙的高度
     * 同2
     *
     * 时间复杂度：O(n²）O(n²），遍历每一列需要 nn，找出左边最高和右边最高的墙加起来刚好又是一个 nn，所以是 n²n²。
     *
     * 空间复杂度：O(1）O(1）。
     *
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(maxLeft, maxRight);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    /**
     * 我们注意到，解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，都是重新遍历一遍所有高度，这里我们可以优化一下。
     *
     * 首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
     *
     * 对于 max_left我们其实可以这样求。
     *
     * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     *
     * 对于 max_right我们可以这样求。
     *
     * max_right[i] = Max(max_right[i+1],height[i+1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
     *
     * 这样，我们再利用解法二的算法，就不用在 for 循环里每次重新遍历一次求 max_left 和 max_right 了。
     * 时间复杂度：O(n)O(n)。
     *
     * 空间复杂度：O(n)O(n)，用来保存每一列左边最高的墙和右边最高的墙。
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        //左边最大，从左边开始数
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }

        //右边最大，从右边开始数
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划中，我们常常可以对空间复杂度进行进一步的优化。
     *
     * 例如这道题中，可以看到，max_left [ i ] 和 max_right [ i ] 数组中的元素我们其实只用一次，然后就再也不会用到了。所以我们可以不用数组，只用一个元素就行了。我们先改造下 max_left。
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 我们成功将 max_left 数组去掉了。但是会发现我们不能同时把 max_right 的数组去掉，因为最后的 for 循环是从左到右遍历的，而 max_right 的更新是从右向左的。
     *
     * 所以这里要用到两个指针，left 和 right，从两个方向去遍历。
     *
     * 那么什么时候从左到右，什么时候从右到左呢？根据下边的代码的更新规则，我们可以知道
     *
     * Java
     * max_left = Math.max(max_left, height[i - 1]);
     * height [ left - 1] 是可能成为 max_left 的变量， 同理，height [ right + 1 ] 是可能成为 right_max 的变量。
     *
     * 只要保证 height [ left - 1 ] < height [ right + 1 ] ，那么 max_left 就一定小于 max_right。
     *
     * 因为 max_left 是由 height [ left - 1] 更新过来的，而 height [ left - 1 ] 是小于 height [ right + 1] 的，而 height [ right + 1 ] 会更新 max_right，所以间接的得出 max_left 一定小于 max_right。
     *
     * 反之，我们就从右到左更。
     *
     * Java
     * @param height
     * @return
     */
    public static int trap4(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }



    public static int trap5(int[] height) {
        int sum = 0;
        int[]  leftMax= new int[height.length];

        int rightMax = 0;

        for(int i = 1; i < height.length -1; i ++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }


        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax,height[i+1]);


            int tmp = Math.min(rightMax,leftMax[i]);


            if(tmp > height[i]) {
                sum += tmp - height[i];
            }

        }



        return sum;

    }


    public static void main(String[] args) {
        int[] nums1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums1));
        System.out.println(trap2(nums1));
        System.out.println(trap3(nums1));
        System.out.println(trap4(nums1));
        System.out.println(trap5(nums1));
    }


}
