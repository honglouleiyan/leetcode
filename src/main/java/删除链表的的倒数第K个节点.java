/**
 *
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/21
 * @time: 17:08
 * @description:
 **/
public class 删除链表的的倒数第K个节点 {

    private static class ListNode {

        int val; // 链表节点的值
        ListNode next; // 下一个节点

        public ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {

            StringBuilder b = new StringBuilder();
            b.append(val);
            ListNode nextNode = next;
            while(null != nextNode) {
                b.append(",").append(nextNode.val);
                nextNode = nextNode.next;
            }

            return b.toString();
        }

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode a7 = new ListNode(1,null);
        ListNode a6 = new ListNode(2,a7);
        ListNode a5= new ListNode(10,a6);
        ListNode a4 = new ListNode(5,a5);
        ListNode a3 = new ListNode(8,a4);
        ListNode a2 = new ListNode(5,a3);
        ListNode a1 = new ListNode(1,a2);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        System.out.println(a1);

        System.out.println(removeNthFromEnd(a1,5));
    }
}
