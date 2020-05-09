import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/23
 * @time: 10:30
 * @description:
 **/
public class 有效的括号生成个数 {
    //参数有n对的{}()[],
    public static List<String> generater(int n) {
        List<String> result=new ArrayList<String>();
        generaterOneByOne("",result,n,n);
        return result;
    }
    /**
     * left:左边的括号就n个
     * right:右边的括号有n个
     * 思想：
     *   必须先放左边的括号，以递归的方式，然后直到左边的括的数目小于0时，以及右边的括号为0时，截止并放到结果中
     *   右边的括号要后放：也就是right>left，保证右括号大于左边括号的数目
     *
     * @param substring
     * @param result
     * @param left
     * @param right
     */
    private static void generaterOneByOne(String substring, List<String> result, int left, int right) {
        if (left==0&&right==0) {
            result.add(substring);
            return;
        }
        if (left>0) {
            generaterOneByOne(substring+"(", result, left-1, right);
        }
        if (right>left) {
            generaterOneByOne(substring+')', result, left, right-1);
        }
    }


    //卡特兰数公式
    // 使用递归的方式解决卡特兰数
    public static long CatalanNumber(int n) {
        if (n == 1) {
            return 1;
        } else {
            return CatalanNumber(n - 1) * 2 * (2 * n - 1) / (n + 1);
        }
    }

    //卡特兰数魔板
    public static BigInteger scanner(int n){
        BigInteger[]h=new BigInteger[101];
        h[0]=new BigInteger("0");
        h[1]=new BigInteger("1");
        for(int i=2;i<=100;i++){
            h[i]=h[i-1].multiply(BigInteger.valueOf(4*i-2)).divide(BigInteger.valueOf(i+1));

        }
        return h[n];
    }


    public static void main(String[] args) {
        int i = 3;
        System.out.println(generater(i).size());
        System.out.println(CatalanNumber(i));

    }
}
