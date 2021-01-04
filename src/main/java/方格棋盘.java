/**给定一个方格棋盘，从左上角出发到右下角有多少种方法
 *
 *
 * 如棋盘      --n
 * 1,1, 1, 1, 1,1   ----m
 * 1,1,-1,-1, 1,1
 * 1,1,-1, 1,-1,1
 *
 * 1表示可走   2表示不可走
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/12/15
 * @time: 15:55
 * @description:
 **/
public class 方格棋盘 {


    /**
     *
     * @param data  表格数据
     * @param m   到达的横坐标，从0开始
     * @param n   到达的纵坐标，从0开始
     */
    public static int path(int[][] data,int m,int n) {

        if(m < 0 || n < 0) {
            return -1;
        }

        //目的地不可达
        if(data[m][n] == -1) {
            return 0;
        }

        if(m == 0 && n == 0) {
            return 1;
        } else if(m == 0 && n > 0) {
            return path(data,m, n-1);
        } else if(n == 0 && m > 0) {
            return path(data,m - 1, n);
        } else  if(m > 0 && n > 0){
            return path(data,m , n - 1) + path(data,m-1, n );
        } else {
            return 0;
        }
    }




    public static void main(String[] args) {
        int[][] m = {{1,1, 1, 1, 1,1}, {1,1,-1,-1,1,1}, {1,1,-1, 1,-1,1}};
        System.out.println(path(m,2,5));
    }
}
