import java.util.List;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 *
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 *
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 *
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 *
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/22
 * @time: 15:40
 * @description:
 **/
public class 情侣牵手 {


    /**
     * 举个例子来说吧，比如：
     *
     * [3   1   4   0   2   5]
     *
     * 如何将其重新排序呢？首先明确，交换数字位置的动机是要凑对儿，如果交换的两个数字无法组成新对儿，那么这个交换就毫无意义。来手动交换吧，两个两个的来看数字，前两个数是3和1，知道其不成对儿，数字3的老相好是2，不是1，那么怎么办呢？就把1和2交换位置呗。好，那么现在3和2牵手成功，度假去了，再来看后面的：
     *
     * [3   2   4   0   1   5]
     *
     * 再取两数字，4和0，互不认识！4跟5有一腿儿，不是0，那么就把0和5，交换一下吧，得到：
     *
     * [3   2   4   5   1   0]
     *
     * 好了，再取最后两个数字，1和0，两口子，不用动！前面都成对的话，最后两个数字一定成对。而且这种方法所用的交换次数一定是最少的
     *
     * 这其实是一种贪婪算法
     * @param row
     * @return
     */
    public static int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if (row[i+1] == (x ^ 1)) {
                continue;
            }
            ans++;
            for (int j = i+1; j < row.length; ++j) {
                if (row[j] == (x^1)) {
                    row[j] = row[i+1];
                    row[i+1] = x^1;
                    break;
                }
            }
        }
        return ans;
    }


    /**
     * UnionFind算法，看不懂
     */
    private class UnionFind{
        int[] parent;
        int[] weight;
        UnionFind(int[] row){
            int m = row.length / 2;
            parent = new int[m];
            weight = new int[m];
            for(int i = 0; i < m; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) {
                return;
            }
            if(weight[rootx] > weight[rooty]){
                parent[rooty] = rootx;
                weight[rootx] += weight[rooty];
            }else{
                parent[rootx] = rooty;
                weight[rooty] += weight[rootx];
            }
        }

        public int getRet(){
            int ret = 0;
            for(int i = 0; i < parent.length; i++){
                if(parent[i] != i){
                    ret++;
                }
            }
            return ret;
        }
    }

    public int minSwapsCouples2(int[] row) {
        UnionFind uf = new UnionFind(row);
        for(int i = 0; i < row.length; i += 2){
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return uf.getRet();
    }


    public static int tanxin(int[] row) {
        int ans = 0;
        for(int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if(row[i+1] == (x ^ 1)) {
                //说明满足情侣条件，不需要移动
                continue;
            }

            //不满足条件，需要移动
            ans++;
            //寻找满足条件的值
            for(int j = i+1; j < row.length; j++) {
                if(row[j] == (x^1)) {
                    //移动
                    int tmp = row[i+1];
                    row[i+1] = row[j];
                    row[j] = tmp;
                    break;
                }
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] nums2 = {2,1,3,6,0,5,4,7};
//        System.out.println(minSwapsCouples(nums2));
        System.out.println(tanxin(nums2));
        System.out.println(1^1^2^3^2^3^0);
    }
}
