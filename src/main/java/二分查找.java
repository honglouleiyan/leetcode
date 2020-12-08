/**
 * 一个有序数组旋转后，查找某个数
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
            //若nums[lo] <= nums[mid]，则左边必定是有序数组，否则  右边是有序数组
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



    public static int search2(int[] nums,int target) {
        int result = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high)/2;

            if(target == nums[middle]) {
                return middle;
            }

             if(nums[low] <= nums[middle]) {
                //左边有序
                if(target >= nums[low] && target <= nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }

            } else {
                 //右边有序
                  if (target >= nums[middle] && target <= nums[high]) {
                     low = middle + 1;
                 } else {
                     high = middle - 1;
                 }
             }
        }


        return result;
    }


    public static void main(String[] args) {


        int[] nums1 = {4,5,6,7,0,1,2};
        System.out.println(search2(nums1,7));
    }
}
