/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/29
 * @time: 15:30
 * @description:
 **/
public class 盛最多水的容器求最大面积 {
    public static  int maxArea(int[] height) {
        int i =0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            if(height[i] < j) {
                res = Math.max(res,j-i) * height[i];
                i++;
            } else {
                res = Math.max(res,(j-i) * height[j]);
                j--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }

}
