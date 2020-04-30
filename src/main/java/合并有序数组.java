/**
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/27
 * @time: 20:17
 * @description:
 **/
public class 合并有序数组 {
    public static void merge(int[] A, int m, int[] B, int n) {
        // 先确保将其中一个数组中的数字遍历完
        int i = m + n - 1;

        while (m > 0 && n > 0) {
            // 对比选出较大的数放在 m + n - 1 的位置，并将选出此数的指针向前移动
            if(A[m - 1] > B[n - 1]) {
                A[i]  = A[m - 1];
                m--;
            } else {
                A[i]  = B[n - 1];
                n--;
            }
            i = m + n -1;
        }
        // 剩下的数都比已经遍历过的数小
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }
    }

    // 测试一下
    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 0, 0, 0};
        int[] B = new int[] {2, 5, 6};
        merge(A, 3, B, 3);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
    }

}
