import com.alibaba.fastjson.JSON;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/20
 * @time: 15:11
 * @description:
 **/
public class 完全背包问题2 {

    private static int[] P={5,8};
    private static int[] V={5,7};
    private static int T = 10;

    private int[][] dp = new int[P.length + 1][T + 1];

    public void solve3() {
        for (int i = 0; i < P.length; i++){
            for (int j = 0; j <= T; j++){
                for (int k = 0; k * V[i] <= j; k++){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-k * V[i]] + k * P[i]);
                }
            }
        }
        System.out.println("最大价值为：" + dp[P.length][T]);
    }



    public static void main(String[] args) {
        完全背包问题2 aa = new 完全背包问题2();
        aa.solve3();
    }
}
