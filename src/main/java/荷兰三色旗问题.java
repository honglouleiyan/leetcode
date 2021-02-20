/**
 *
 * 某盒子中有n个球，每个球的颜色可以是红、蓝、白，现在要求把球按照红、蓝、白的顺序摆放。这个问题叫做荷兰旗问题（荷兰旗由红、蓝、白三色组成）。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/6/28
 * @time: 17:09
 * @description:
 **/
public class 荷兰三色旗问题 {

    /*
 荷兰三色旗问题解
 */
    public static void sortColors(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else {
                curr++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        sortColors(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }
}
