/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/30
 * @time: 14:53
 * @description:
 **/
public class 分治算法数组中查询某个数是否出现过 {


    /**
     * 在数组 { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } 中，查找 8 是否出现过
     * @param a
     * @param target
     * @return
     */
    public static Boolean fenzhi(int[] a,int target) {
        Boolean flag = false;



        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = (low + high)/2;
            if(a[middle] == target) {
                return true;
            } else if(target > a[middle]) {
                low = middle + 1;
            } else if(target < a[middle]) {
                high = middle - 1;
            }
        }
        return flag;
    }


    /**
     * 在一个有序数组中，查找出第一个大于 9 的数字，假设一定存在。例如，arr = { -1, 3, 3, 7, 10, 14, 14 }; 则返回 10。
     * @param a
     * @param target
     * @return
     */
    public static int fenzhi2(int[] a,int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = (low + high)/2;

            if(a[middle] > target && a[middle - 1] <= target) {
                return middle;
            } else if(a[middle] > target) {
                high = middle - 1;
            } else  {
                low = middle + 1;
            }


        }
        return 0;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,13};
        System.out.println(fenzhi(a,11));

        System.out.println(fenzhi2(a,10));
    }
}
