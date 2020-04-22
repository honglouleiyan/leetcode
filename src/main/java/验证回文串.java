/**
 * 验证是不是回文串
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/17
 * @time: 16:46
 * @description:
 **/
public class 验证回文串 {

    /**
     * 一般不允许用reverse方法
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c))   {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    /**
     * 左右开弓，双指针，遇到非字母数字跳过，判断是否相等
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length()-1;
        while (right >= left){
            //遇到非数字或字母跳过
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            //判断是否相等
            if (right >= left && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            }else {
                return false;
            }


        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
