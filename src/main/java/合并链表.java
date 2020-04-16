/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/15
 * @time: 15:21
 * @description:
 **/
public class 合并链表 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    private static class ListNode {

        int val; // 链表节点的值
        合并链表.ListNode next; // 下一个节点

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {

            StringBuilder b = new StringBuilder();
            b.append(val);
            合并链表.ListNode nextNode = next;
            while(null != nextNode) {
                b.append(",").append(nextNode.val);
                nextNode = nextNode.next;
            }

            return b.toString();
        }

    }

    public static void main(String[] args) {
        合并链表.ListNode l11 = new 合并链表.ListNode(2);
        合并链表.ListNode l12 = new 合并链表.ListNode(6);
        合并链表.ListNode l13 = new 合并链表.ListNode(4);
        l13.next = l12;
        l11.next = l13;

        合并链表.ListNode l21 = new 合并链表.ListNode(3);
        合并链表.ListNode l22 = new 合并链表.ListNode(5);
        合并链表.ListNode l23 = new 合并链表.ListNode(7);
        l22.next = l23;
        l21.next = l22;

        合并链表.ListNode result = mergeTwoLists(l11,l21);
        System.out.println(result.toString());
    }

}
