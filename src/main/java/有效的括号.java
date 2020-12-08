import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/15
 * @time: 14:16
 * @description:
 **/
public class 有效的括号 {
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            // '('，')'，'{'，'}'，'['，']' 的 ASCII 码分别是 40、41、91、93、123、125
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                //Math.abs(ch - stack.pop()) > 2 ----通过ASCII方式判断是不是他对齐的括号
            } else if (stack.isEmpty() || Math.abs(ch - stack.pop()) > 2) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    private static int isPair(char p, char curr) {
        if ((p == '{' && curr == '}') || (p == '[' && curr == ']') || (p == '(' && curr == ')')) {
            return 1;
        } else {
            return 0;
        }
    }


    public static boolean isValid2(String s) {
        Stack stack = new Stack();
        if (s.isEmpty()) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '{' || curr == '('  || curr == '[' ) {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    char pop = (char) stack.pop();
                    if(isPair(pop,curr) == 0) {
                        return false;
                    }
                }
            }
        }

        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("((({{[]}}))))"));
        System.out.println(isValid2("((({{[]}})))"));
    }
}
