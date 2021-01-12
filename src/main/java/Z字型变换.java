/**
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 **/
public class Z字型变换 {


    /**
     *以 V 字型为一个循环, 循环周期为 n = (2 * numRows - 2) （2倍行数 - 头尾2个）。
     * 对于字符串索引值 i，计算 x = i % n 确定在循环周期中的位置。
     * 则行号 y = min(x, n - x)
     *
     * @param s   字符串
     * @param numRows   行数
     * @return
     */
    public  static String cover(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int n = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int x = i % n;
            int tmp = Math.min(x,n - x );
            rows[tmp].append(s.charAt(i));
        }
        return String.join("", rows);
    }

    public static void main(String[] args) {
        System.out.println(cover("LEETCODEISHIRING",3));
    }
}
