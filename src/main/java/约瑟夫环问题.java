import java.util.LinkedList;

/**
 *
 * 以编号 1，2，3...n 分别表示）围坐在一张圆桌周围。从编号为 k 的人开始报数，数到 m 的那个人出列；
 * 他的下一个人又从 1 开始报数，数到 m 的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列。
 * 这个问题的输入变量就是 n 和 m，即 n 个人和数到 m 的出列的人。输出的结果，就是 n 个人出列的顺序
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/27
 * @time: 12:40
 * @description:
 **/
public class 约瑟夫环问题 {


    /**
     * n个圆桌编号，从k个人开始报错，数到m那个人
     * @param n
     * @param m
     * @param k
     */
    public static void ring(int n,int m,int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        //调换元素顺序，使其从k开始
        int tmp = 0;
        for(int i = 1; i <= k; i++) {
            tmp = list.pop();
            list.add(tmp);
        }

        int j = 1;
        while (list.size() > 0) {
            tmp = list.pop();
            if(j < m) {
                list.add(tmp);
                j++;
            } else {
                System.out.println(tmp);
                j = 1;
            }

        }
    }

    public static void main(String[] args) {
        ring(10,5,2);
    }
}
