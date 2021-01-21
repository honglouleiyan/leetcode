/**
 *
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/21
 * @time: 14:14
 * @description:
 **/
public class 分割链表 {


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

    /**
     * 双指针法
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        // 新建before和after两个辅助链表
        // 遍历输入链表，划分结点到辅助链表
        // 合并两个辅助链表
        ListNode present = head;
        ListNode before = null;
        ListNode after = null;
        ListNode tmp = null;
        ListNode newHead = null;
        while(present!=null) {
            tmp = present;
            present = present.next;
            if (tmp.val >=x) {
                tmp.next=after;
                after=tmp;
            } else {
                if (before ==null) {
                    before=tmp;
                    newHead=tmp;
                } else {
                    before.next=tmp;
                    before=tmp;
                }
            }
        }
        if (head!=null &&before!=null) {
            before.next=after;
            return newHead;
        } else {
            return after;
        }
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(5);
        ListNode a5= new ListNode(10);
        ListNode a6 = new ListNode(2);
        ListNode a7 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;


        System.out.println(partition(a1,5));

    }


}
