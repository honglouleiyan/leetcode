/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/15
 * @time: 13:58
 * @description:
 **/
public class 公约数 {


    public static int equalGCD(int m, int n) {
        while (m != n) {
            if (m > n) {
                m -= n;
            } else {
                n -= m;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(equalGCD(5,3));
    }
}
