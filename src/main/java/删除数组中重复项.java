/**

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/27
 * @time: 15:49
 * @description:
 **/
public class 删除数组中重复项 {


    /**
     *  * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *  *
     *  * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param list
     * @return
     */
    public static int removeList(int[] list) {
      int result = 0;
      if(list == null && list.length== 0) {
          return result;
      }
      int p = 0;
      int q = 1;
      while (q < list.length) {
          if(list[p] == list[q]) {
              q++;
          } else {
              list[p+1] = list[q];
              p++;
              q++;
          }
      }
      return p+1;
    }


    /**
     * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     */


    public static int[] removeList2(int[] list) {
        int count = 1;

        int tmp = list[0];
        for(int i = 1; i < list.length; i++) {
            if(list[i] != tmp) {
                list[count] = list[i];
                tmp = list[i];
                count++;

            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,4,5};
        int[] result = removeList2(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(nums[i]);
        }

    }


}
