package util;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/8
 * @time: 17:29
 * @description:
 **/
public class LinkedList<I extends Number> {
    public Node head;
    public int location;//结点位置
    //头插
    public void insertHeadNode(String data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public String NthNodeFromEnd(int NthNode){//查找倒数第n个结点
        Node pNthNode = null;//!!!!易错
        Node pTemp = head;
        for(int count = 1;count<NthNode;count++){//1:先让pTemp移动到第NthNode个结点处
            if(pTemp != null){
                pTemp = pTemp.next;
            }
        }
        while(pTemp != null){//2:pNthNode开始移动
            if(pNthNode == null){
                pNthNode = head;
            }else{
                pNthNode = pNthNode.next;
            }
            pTemp = pTemp.next;
        }
        if(pNthNode != null) {
            return pNthNode.data;
        }
        return null;
    }
    //显示所有结点信息
    public void displayAllNodes(){
        Node curNode = head;
        while(curNode != null){
            curNode.show();
            curNode = curNode.next;
        }
        System.out.println();
    }
}
