/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/16
 * @time: 17:23
 * @description:
 **/
public class 删除排序链表中的重复元素 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    private static class ListNode {

        int val; // 链表节点的值
        删除排序链表中的重复元素.ListNode next; // 下一个节点

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {

            StringBuilder b = new StringBuilder();
            b.append(val);
            删除排序链表中的重复元素.ListNode nextNode = next;
            while(null != nextNode) {
                b.append(",").append(nextNode.val);
                nextNode = nextNode.next;
            }

            return b.toString();
        }

    }
    public static void main(String[] args) {
        删除排序链表中的重复元素.ListNode l11 = new 删除排序链表中的重复元素.ListNode(2);
        删除排序链表中的重复元素.ListNode l12 = new 删除排序链表中的重复元素.ListNode(6);
        删除排序链表中的重复元素.ListNode l13 = new 删除排序链表中的重复元素.ListNode(4);
        l13.next = l12;
        l11.next = l13;

        System.out.println(deleteDuplicates(l11));

    }

}
