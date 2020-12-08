import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 *
 * 要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
 *
 * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。仍然是这道题，我们试试用栈来解决它吧。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/26
 * @time: 17:20
 * @description:
 **/
public class 翻转链表 {


    public static int[] over(int[] s,int k) {
        Stack stack = new Stack();
        int[] result = new int[s.length+1];
        int number = s.length%k > 0 ? s.length/k + 1: s.length/k;
        for(int j = 0; j < number; j++) {
            for(int i = j*k; i < j*k + k; i++) {
                stack.push(s[i]);
            }

            for(int i = j*k; i < j*k + k; i++) {
                result[i] = (int) stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,3,22,44,66,55,77,88,99};
        int[] result = over(nums1,2);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
}
