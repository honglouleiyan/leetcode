import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/14
 * @time: 18:18
 * @description:
 **/
public class 缺失的第一个正整数 {

    /**
     * 解题思路
     * 长度为N的无序数组在保证“无重复，无越界”的情况下，最多能装下N以内的正整数。
     *
     * 借用数组的[0, n-1]存储区间，试图有序的摆放[1, N]区间的正整数：
     * nums[i] 存储正整数 i + 1
     *
     * 如果出现重复，越界的情况，说明无效数字多占了一个坑位，丢掉无效数字的同时坑位减一。
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int res = 0;
        int n = nums.length - 1;
        int tmp = 0;

        while(res <= n){
            if(nums[res] == res + 1){
                res++;
            }else{
                tmp = nums[res];
                if(tmp > n + 1 || tmp < res + 1 || nums[tmp - 1] == tmp){
                    nums[res] = nums[n--];
                }else{
                    nums[res] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
        }

        return res + 1;
    }


    /**
     * 按照刚才我们读例子的思路，其实我们只需从最小的正整数 11 开始，依次判断 22、 33 、44 直到数组的长度 N 是否在数组中。
     *
     * 如果当前考虑的数不在这个数组中，我们就找到了这个缺失的最小正整数。
     *
     * 由于我们需要依次判断某一个正整数是否在这个数组里，我们可以先把这个数组中所有的元素放进哈希表。接下来再遍历的时候，就可以以 O(1)O(1) 的时间复杂度判断某个正整数是否在这个数组。
     *
     * 由于题目要求我们只能使用常数级别的空间，而哈希表的大小与数组的长度是线性相关的，因此空间复杂度不符合题目要求。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,4,5,22};
        System.out.println(firstMissingPositive2(nums1));

    }
}
