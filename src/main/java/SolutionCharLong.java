import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/3/25
 * @time: 16:44
 * @description:
 **/
public class SolutionCharLong {
    public static int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray() ;
        int left = 0 , right = 0 , n = ss.length ;
        int max = Integer.MIN_VALUE ;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        while(right < n){
            //当前字符已在滑动窗口内
            if(map.containsKey(ss[right])){
                //记录遍历至此最长的符合题意的字符串。right-left为当前窗口大小
                max = Math.max(max,right - left) ;
                int temp = map.get(ss[right]) ;
                for(int i = left ; i <= temp ; i++){
                    // 清除部分map记录
                    map.remove(ss[i]) ;
                }
                // 调整滑动窗口的左端点
                left = temp + 1 ;
            }
            map.put(ss[right],right) ;
            right++ ;
        }
        return Math.max(max,right - left) ;
    }

    public static void main(String[] args) {
        String s = "dfsdfdsfesfsfsjiojisdhufbewyuisdnuifdbsfmodsnfoasofnois";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
