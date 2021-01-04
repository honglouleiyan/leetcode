/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。例如，输入: "the sky is blue"，输出: "blue is sky the"。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/28
 * @time: 17:11
 * @description:
 **/
public class 翻转句子 {
    public static String over(String a) {
        a = a.trim();
        StringBuffer b = new StringBuffer();

        int j = a.length() -1;
        int i = j;
        while(i >= 0) {
            while(i >= 0 && a.charAt(i) != ' ') {
                i--;
            }
            b.append(a.substring(i + 1, j + 1) + " ");
            i--;
            j = i;
        }


        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(over("the sky is blue ccc"));
    }
}
