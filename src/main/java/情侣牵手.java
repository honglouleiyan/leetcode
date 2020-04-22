/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/22
 * @time: 15:40
 * @description:
 **/
public class 情侣牵手 {
    public static int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            System.out.println(x ^ 1);
            if (row[i+1] == (x ^ 1)) {
                continue;
            }
            ans++;
            for (int j = i+1; j < row.length; ++j) {
                int aaa = row[j];
                int bbb = x^1;
                if (row[j] == (x^1)) {
                    row[j] = row[i+1];
                    row[i+1] = x^1;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums2 = {2,1,3,6,0,5,4,7};
        System.out.println(minSwapsCouples(nums2));
    }
}
