/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/12/15
 * @time: 17:52
 * @description:
 **/
public class 单调递增的数字 {


    /**
     * 我们可以从高到低按位构造这个小于等于 NN 的最大单调递增的数字。
     * 假设不考虑 NN 的限制，那么对于一个长度为 nn 的数字，最大单调递增的数字一定是每一位都为 99 的数字。
     *
     * 记 strN[i] 表示数字 N 从高到低的第 i 位的数字（i 从 0 开始）。
     *
     * 如果整个数字 N 本身已经是按位单调递增的，那么最大的数字即为 N。
     *
     *如果找到第一个位置 i 使得[0,i−1] 的数位单调递增且 {strN}[i-1]>{strN}[i]，此时 [0,i]的数位都与 N 的对应数位相等，
     * 仍然被 N 限制着，即我们不能随意填写 [i+1,n-1]位置上的数字。为了得到最大的数字，我们需要解除 N 的限制，
     * 来让剩余的低位全部变成 99 ，即能得到小于 N 的最大整数。而从贪心的角度考虑，我们需要尽量让高位与 N 的对应数位相等，故尝试让strN[i−1] 自身数位减 1。
     * 此时已经不再受 N 的限制，直接将 [i, n-1] 的位置上的数全部变为 9 即可。
     *
     * 但这里存在一个问题：当strN[i−1] 自身数位减 1 后可能会使得 strN[i−1] 和 strN[i−2] 不再满足递增的关系，
     * 因此我们需要从 i-1 开始递减比较相邻数位的关系，直到找到第一个位置 j 使得 strN[j] 自身数位减 1 后 strN[j−1] 和 strN[j] 仍然保持递增关系
     * ，或者位置 j 已经到最左边（即 j 的值为 0），此时我们将 [j+1,n−1] 的数全部变为 9 才能得到最终正确的答案。
     *
     *
     * @param N
     * @return
     */

    public static int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(331));
    }

}
