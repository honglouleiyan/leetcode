/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和
 *
 * 输入：(2 -> 4 -> 3)
 *    + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/3/25
 * @time: 13:42
 * @description:
 *
 * 使用一个进位符，一直加就行
 **/
public class 两数相加加法运算 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //虚拟头节点
        ListNode head = new ListNode(0);
        //指针
        ListNode cur = head;
        //进位值
        int carry = 0;
        //两个链表均为空时停止遍历
        while (l1 != null || l2 != null) {
            //x为l1的值，如果节点为空，值为0
            int x = (l1 != null) ? l1.val : 0;
            //y为l2的值，如果节点为空，值为0
            int y = (l2 != null) ? l2.val : 0;
            //sum为两节点值之和
            int sum = carry + x + y;
            //得进位值（1）
            carry = sum / 10;
            //sum 得余数即 个位数的值
            //刷新指针
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            //l1节点不为空继续刷新下一个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            //l2节点不为空继续刷新下一个节点
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果仍然需要进 1 ，则直接新建一个节点
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    private static class ListNode {

        int val; // 链表节点的值
        ListNode next; // 下一个节点

        public ListNode(int val) {
            this.val = val;
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

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
//        l12.next = l13;
        l11.next = l12;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(8);
        l22.next = l23;
        l21.next = l22;

        ListNode result = addTwoNumbers(l11,l21);
        System.out.println(result.toString());
    }
}
