import util.Node;

/**
 *
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 *
 **/
public class 查找链表的中间节点 {


    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        Node l1 = new Node("1");
        Node l2 = new Node("2");
        Node l3 = new Node("3");
        Node l4 = new Node("4");
        Node l5 = new Node("5");

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Node result = middleNode(l1);
        System.out.println(result.data);

    }


}
