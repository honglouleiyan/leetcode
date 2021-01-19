import java.util.Arrays;

/**
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/19
 * @time: 18:52
 * @description:
 **/
public class 不同路径 {


    /**
     * 动态规划
     * dp[i][j]=dp[i-1][j]+dp[i][j-1]。
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一列都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行都是1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //这里是递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * 动态规划优化
     * 我们看上面二维数组的递推公式，当前坐标的值只和左边与上面的值有关，和其他的无关，这样二维数组造成大量的空间浪费，所以我们可以把它改为一维数组。
     */
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }


}
