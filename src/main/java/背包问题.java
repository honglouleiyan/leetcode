/**
 *
 * 给定n个重量为w1，w2，w3，...，wn，价值为v1，v2，...，vn的物品和一个承重为W的背包，
 * 求这些物品中最有价值的子集（PS：每一个物品要么选一次，要么不选），并且要能够装到背包。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/20
 * @time: 14:23
 * @description:
 **/
public class 背包问题 {

    /**
     *
     * @param weight   物品重量
     * @param value     物品价值
     * @param w    背包容量
     * @param n     物品个数
     * @return
     */
    public static int getMaxValue(int[] weight, int[] value, int n, int w) {
        // 创建一个二维数组，横列是物品的价值，竖列是物品的重量
        int[][] table = new int[n + 1][w + 1];
        // 蓝色代码注释开始
        //物品
        for (int i = 1; i <= n; i++) {
            //背包大小
            for (int j = 1; j <= w; j++) {
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装

                    /**
                     * 一个是f[i-1,j]，这种情况就是承重为8的背包里面不放a这个物品这一种情况(根据上面的状态转换方程来的)，
                     * 这里i就是下面的横列的值，然后j就是指竖列的值，所以此时f[i-1,j]里面的i就是a、j就是8，
                     * 因为a的下一列是b，所以f[i-1,j]就是指b8，所以此时的f[i-1,j]的值就是9
                     */
                    table[i][j] = table[i - 1][j];
                } else {
                    //装得下，Max{装物品i， 不装物品i}

                    /**
                     * 另一个是f[i-1,j-Wi]+Pi，这种情况就是承重为8的背包里面要放a这个物品这一种情况(根据上面的状态转换方程来的)，
                     * 既然要放a这个物品，那么此时的Pi的值就是6(因为a商品的价值是6)，
                     * 然后因为承重为8的背包里面已经确定要放a这个物品，所以此时这个背包里面最多还只能存放的重量就是6，
                     * 这里i就是下面的横列的值，然后j就是指竖列的值，所以此时f[i-1,j-Wi]里面的i就是a、j就是8、Wi就是2(这个2就是a物品的重量)，
                     * 所以此时f[i-1,j-Wi]就是指b6，此时b6的值是9，所以f[i-1,j-Wi]+Pi=9+6=15，所以物品a应该放入称重是8的背包里面
                     */
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        // 蓝色代码注释结束
        return table[n][w];
    }

    public static void main(String[] args) {
        //物品个数，背包容量
        int n = 5, w = 10;
        // 红色代码注释开始
        //各个物品的价值
        int[] value = {0,6, 3, 5, 4, 6};
        //各个物品的重量
        int[] weight = {0,2, 2, 6, 5, 4};
        // 红色代码注释结束
        System.out.println(getMaxValue(weight, value, n, w));
    }
}
