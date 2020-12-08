/**
 *
 * 有两个字符串（可能包含空格）,请找出其中最长的公共连续子串,输出其长度。(长度在1000以内)
 *
 * 例如：
 *
 * 输入：abcde bcd
 *
 * 输出：3
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/13
 * @time: 15:50
 * @description:
 **/
public class 最长公共子串 {


    //解题思路，将两个数组转化为一个二维矩阵
    //   a b c d e
    //b  0 1 0 0 0
    //c  0 0 1 0 0
    //d  0 0 0 1 0
    //然后找出堆场的对角线为1的值，为3

    public static int LCS1 (String str1, String str2) {
        int result = -1;
        if(str1 == null || str1.length() <= 0) {
            return -1;
        }
        if(str2 == null || str2.length() <= 0) {
            return -1;
        }

        for(int i=0; i < str1.length(); i ++) {
            for(int j=0; j < str2.length(); j ++) {
                int len = 0;
                int m = i;
                int n = j;
                while (m < str1.length() &&  n < str2.length() && str1.charAt(m) == str2.charAt(n)) {
                    len++;
                    m++;
                    n++;
                }
                result = Math.max(result,len);
            }
        }
        return  result;
    }


    //通过LCS1可以看到
    //   a b c d e
    //b  0 1 0 0 0
    //c  0 0 1 0 0
    //d  0 0 0 1 0

    //ab b子串长度为1
    //abc bc子串长度为2
    //abcd bcd子串长度为3
    //是不是后一个数组的结果就是根据上一个结果来的，也就是说，要计算（N,N）的子串长度，只需要计算（N-1,N-1）的子串长度后，在判断最后一个数，综合得出结论即可
    //这是一个典型的动态规划问题
    public static int LCS2 (String str1, String str2) {
        int result = -1;
        if(str1 == null || str1.length() <= 0) {
            return -1;
        }
        if(str2 == null || str2.length() <= 0) {
            return -1;
        }
        //定义动态规划二维数组，用来存放（N-1,N-1）各种情况的结果）
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i=0; i < str1.length(); i ++) {
            for(int j=0; j < str2.length(); j ++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    result = Math.max(result,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return  result;
    }


    public static int LCSxxx (String str1, String str2) {
        int result = -1;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        if(str1 == null || str1.length() <= 0) {
            return -1;
        }
        if(str2 == null || str2.length() <= 0) {
            return -1;
        }

        for(int i = 0; i < str1.length(); i ++) {
            for(int j = 0; j < str2.length(); j ++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                   if(i == 0 || j == 0) {
                       dp[i][j] = 1;
                   } else {
                       dp[i][j] = dp[i-1][j-1] + 1;
                   }
                   result = Math.max(result,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }


        return result;

    }




    public static void main(String[] args) {
        System.out.println(LCS1("acbcbcef","abcbced"));
        System.out.println(LCSxxx("acbcbcef","abcbced"));
    }

}
