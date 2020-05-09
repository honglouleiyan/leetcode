import util.LinkedList;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/7
 * @time: 19:05
 * @description:
 **/
public class 单项链表查找倒数N个数 {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertHeadNode("A");
            linkedList.insertHeadNode("B");
            linkedList.insertHeadNode("C");
            linkedList.insertHeadNode("D");
            linkedList.insertHeadNode("E");
            linkedList.insertHeadNode("F");
            linkedList.displayAllNodes();
            String st = linkedList.NthNodeFromEnd(3);
            System.out.println(st);
    }
}
