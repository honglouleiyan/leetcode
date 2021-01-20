import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/20
 * @time: 15:11
 * @description:
 **/
public class 完全背包问题 {

    //物品重量
    private static int[] weight={0,5,8};

    //物品价值
    private static int[] value={0,5,7};

    //背包容量
    private static int w = 10;

    private int[] newResults = new int[w + 1];


    private int ksp(int i, int t){
        // 开始填表
        for (int m = 0; m < i; m++){
            for (int n = weight[m]; n <= t; n++){
                newResults[n] = Math.max(newResults[n] , newResults[n - value[m]] + weight[m]);
            }
            // 可以在这里输出中间结果
            System.out.println(JSON.toJSONString(newResults));
        }
        return newResults[newResults.length - 1];
    }

    public static void main(String[] args) {

        完全背包问题 aa = new 完全背包问题();
        int result = aa.ksp(weight.length,w);
        System.out.println(result);
    }
}
