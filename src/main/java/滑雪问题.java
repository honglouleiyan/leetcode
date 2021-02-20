/**
 *
 * NowCoder喜欢滑雪，因为滑雪的确很刺激。为了获得速度，必须从高处往低处滑。现在知道某片区域的海拔，如下所示
 * 1   2  3  4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * 可以从某个点滑向上下左右四个方向中海拔比当前位置低的点。例如上图中一条可行的滑坡为24-17-16-1。当然25-24-23-…-3-2-1是最长的一条。
 * 现在给出区域的海拔，你能帮忙计算最长的滑道有多长吗？
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/2/19
 * @time: 15:02
 * @description:
 **/
public class 滑雪问题 {


    private static int[][] arr = {{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}}; //存放输入的矩阵
    private static int c = 5; //arr的列数
    private static int r = 5; //arr的行数
    private static int[][] value = new int[r][c]; //对应arr每点的“滑雪长度”
    /**
     * @param col：arr的列数
     * @param row：arr的行数
     * @param maxValue：上一个arr点的值
     * @return
     */
    private static int ski(int row, int col, int maxValue) {
        //出了矩阵的区域或者现在arr这个点的值大于上一个arr点的值，即跑到更高的点去了，无效，返回0
        if (col >= c || col < 0 || row >= r || row < 0 || maxValue <= arr[row][col] ) {
            return 0;
        }
        //若已经计算过了此arr点的“滑雪长度”，直接返回
        if (value[row][col] > 0) {
            return value[row][col];
        }
        //不然就计算此点的“滑雪长度” = 上下左右的点的“滑雪长度”的最大值 + 1
        value[row][col] = max(ski(row-1, col, arr[row][col]), ski(row+1, col, arr[row][col]), ski(row, col-1, arr[row][col]), ski(row, col+1, arr[row][col])) + 1;
        return value[row][col];
    }

    /**
     * @param ski1
     * @param ski2
     * @param ski3
     * @param ski4
     * @return 最大值
     */
    private static int max(int ski1, int ski2, int ski3, int ski4) {
        return Math.max(Math.max(ski1, ski2), Math.max(ski3, ski4));
    }

    public static void main(String[] args) {
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp = ski(i, j, Integer.MAX_VALUE);
                if (temp > max) {
                    max = temp;
                }
            }
        }

        System.out.println(max);
    }

}
