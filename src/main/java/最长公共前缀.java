/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/15
 * @time: 10:47
 * @description:
 **/
public class 最长公共前缀 {
    //分治算法
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs,0,strs.length-1);
    }

    private static String longestCommonPrefix(String[] strs,int l,int r) {
        if (l == r) {
            return strs[l];
        } else {
            // 将数组分成两组分别查找最长公共前缀，然后再查找两个公共前缀的最长公共前缀。
            int mid = (l + r)/2;
            String lcpLeft = longestCommonPrefix(strs,l,mid);
            String lcpRight = longestCommonPrefix(strs,mid+1,r);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }


    //找出两个数的公告前缀
    private static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(),right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0,i);
            }
        }
        return left.substring(0,min);
    }

    //二分查找
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        // 遍历得到数组中最短字符串的长度。
        for (String str : strs){
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        // 用二分法从最短字符串中间循环遍历。
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs,middle)){
                low = middle + 1;
            } else{
                high = middle - 1;
            }
        }
        return strs[0].substring(0,(low+high)/2);
    }

    private boolean isCommonPrefix(String[] strs,int len){
        // 截取当前位置之前的字符串判断是否是数组中字符串的公共前缀。
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++){
            if (!strs[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs  = new String[]{"flowfsdfd","flowfsdfddfdfdfd","flowfsdfddfdfdfdkkk"};
        System.out.println(longestCommonPrefix(strs));

    }
}
