/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/7/1
 * @time: 15:04
 * @description:
 **/
public class 二分查找 {

    static  int search(int[] nums, int target) {
        if(nums.length <= 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            //前一段递增
            if(nums[lo] <= nums[mid])
            {
                if(target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            else
            {
                //后一段递增
                if(target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                }

                else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,0,1,2};
        System.out.println(search(nums1,1));
    }
}
