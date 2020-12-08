/**
 *
 *
 * 从左到右有 x、y、z 三根柱子，其中 x 柱子上面有从小叠到大的 n 个圆盘。现要求将 x 柱子上的圆盘移到 z 柱子上去。
 * 要求是，每次只能移动一个盘子，且大盘子不能被放在小盘子上面。求移动的步骤
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/30
 * @time: 11:29
 * @description:
 **/
public class 汉诺塔叠盘子 {

    public static void hanio(int n,String x, String y,String z) {
        if(n <= 0) {
            System.out.println("不用移动");
        }

        if(n == 1) {
            System.out.println("从"+x+"移动到" + z);
        } else {
            hanio(n-1,x,z,y);
            System.out.println("从"+x+"移动到" + z);
            hanio(n-1,y,x,z);
        }
    }


    /**
     * 下面，我们给出一道练习题，斐波那契数列。斐波那契数列是：0，1，1，2，3，5，8，13，21，34，55，89，144……。
     * 你会发现，这个数列中元素的性质是，某个数等于它前面两个数的和；也就是 a[n+2] = a[n+1] + a[n]。至于起始两个元素，则分别为 0 和 1。在这个数列中的数字，就被称为斐波那契数。
     *
     * 现在的问题是，写一个函数，输入 x，输出斐波那契数列中第 x 位的元素。例如，输入 4，输出 2；输入 9，输出 21。要求：需要用递归的方式来实现
     */

    public static int feibolaqi(int n) {
        int result = 0;
        if(n <= 0) {
            return result;
        }
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n > 2) {
            return feibolaqi(n-1) + feibolaqi(n-2);
        }



        return result;
    }


    public static void main(String[] args) {
        String x = "x";
        String y = "y";
        String z = "z";
//        hanio(34,x,y,z);
        System.out.println(feibolaqi(9));
    }
}
