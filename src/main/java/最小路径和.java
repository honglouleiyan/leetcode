/**
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/21
 * @time: 17:50
 * @description:
 **/
public class 最小路径和 {

    /**
     * 此题是典型的动态规划题目。
     *
     * 状态定义：
     *
     * 设 dpdp 为大小 m \times nm×n 矩阵，其中 dp[i][j]dp[i][j] 的值代表直到走到 (i,j)(i,j) 的最小路径和。
     * 转移方程：
     *
     * 题目要求，只能向右或向下走，换句话说，当前单元格 (i,j)(i,j) 只能从左方单元格 (i-1,j)(i−1,j) 或上方单元格 (i,j-1)(i,j−1) 走到，因此只需要考虑矩阵左边界和上边界。
     *
     * 走到当前单元格 (i,j)(i,j) 的最小路径和 == “从左方单元格 (i-1,j)(i−1,j) 与 从上方单元格 (i,j-1)(i,j−1) 走来的 两个最小路径和中较小的 ” ++ 当前单元格值 grid[i][j]grid[i][j] 。具体分为以下 44 种情况：
     * 当左边和上边都不是矩阵边界时： 即当i \not= 0i
     * 
     * ​
     *  =0, j \not= 0j
     * 
     * ​
     *  =0时，dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j] ；
     * 当只有左边是矩阵边界时： 只能从上面来，即当i = 0, j \not= 0i=0,j
     * 
     * ​
     *  =0时， dp[i][j] = dp[i][j - 1] + grid[i][j]dp[i][j]=dp[i][j−1]+grid[i][j] ；
     * 当只有上边是矩阵边界时： 只能从左面来，即当i \not= 0, j = 0i
     * 
     * ​
     *  =0,j=0时， dp[i][j] = dp[i - 1][j] + grid[i][j]dp[i][j]=dp[i−1][j]+grid[i][j] ；
     * 当左边和上边都是矩阵边界时： 即当i = 0, j = 0i=0,j=0时，其实就是起点， dp[i][j] = grid[i][j]dp[i][j]=grid[i][j]；
     * 初始状态：
     *
     * dpdp 初始化即可，不需要修改初始 00 值。
     * 返回值：
     *
     * 返回 dpdp 矩阵右下角值，即走到终点的最小路径和。
     *

     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                else if(i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                else if(j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        int[][] m = {{1,3,1}, {1,5,1}, {4,2,1}};
       int result =  minPathSum(m);
        System.out.println(result);
    }
}
