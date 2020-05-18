import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.LinkedList;

/**
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/14
 * @time: 16:30
 * @description:
 **/
public class 跳跃游戏3 {


    /**
     * DFS
     * 准备一个函数：dfs(int[] arr, int curPos, boolean[] visited)
     * 其中curPos表示当前访问的位置
     * visited表示当前的curPos位置有无被访问过
     * 出口条件：
     * 当前curPos越界了，也就是不在[0,len-1]范围内时，返回false
     * 当前curPos的访问过，返回false
     * 当arr[curPos]==0时，表示找到了，返回true
     * 探索左边和右边位置
     * @param arr
     * @param start
     * @return
     */
    public static boolean canJump(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private static boolean dfs(int[] arr, int curPos, boolean[] visited) {
        if (curPos < 0 || curPos >= arr.length || visited[curPos]) {
            return false;
        }
        if (arr[curPos] == 0) {
            return true;
        }
        visited[curPos] = true;
        return dfs(arr, curPos - arr[curPos], visited) || dfs(arr, curPos + arr[curPos], visited);
    }


    /**
     * 方法2：BFS
     * 准备一个bool类型的数组visited表示当前的下标有无被访问过
     * 准备一个queue，转这个queue
     * 取到这一轮的总的size大小，进行for loop
     * 弹出当前的curPos,如果arr[curPos]== 0说明找到了，返回true
     * 分别渠道左右两边去找，curPos的位置不越界并且leftPos和rightPos未被访问过
     * 访问后要设置下visited的属性，并且将位置放置于queue中
     * @param arr
     * @param start
     * @return
     */
    public static boolean canJump2(int[] arr, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.removeFirst();
                int curValue = arr[curPos];
                if (curValue == 0) {
                    return true;
                }
                int leftPos = curPos - curValue;
                if (leftPos >= 0 && !visited[leftPos]) {
                    visited[leftPos] = true;
                    queue.addFirst(leftPos);
                }
                int rightPos = curPos + curValue;
                if (rightPos < n && !visited[rightPos]) {
                    visited[rightPos] = true;
                    queue.addFirst(rightPos);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1 = {4,2,3,0,3,1,2};
        System.out.println(canJump(nums1,0));
        System.out.println(canJump2(nums1,0));
    }
}

