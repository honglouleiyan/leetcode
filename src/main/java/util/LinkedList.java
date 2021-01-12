package util;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/8
 * @time: 17:29
 * @description:
 **/
public class LinkedList<I extends Number> {
    public Node next;
    public int val;//结点位置
    //头插
    public void insertHeadNode(String data){
        Node node = new Node(data);
        node.next = next;
        next = node;
    }


    //查找倒数第n个结点
    public String NthNodeFromEnd(int NthNode){
        //!!!!易错
        Node pNthNode = null;
        Node pTemp = next;
        //1:先让pTemp移动到第NthNode个结点处
        for(int count = 1;count<NthNode;count++){
            if(pTemp != null){
                pTemp = pTemp.next;
            }
        }
        //2:pNthNode开始移动
        while(pTemp != null){
            if(pNthNode == null){
                pNthNode = next;
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
        Node curNode = next;
        while(curNode != null){
            curNode.show();
            curNode = curNode.next;
        }
        System.out.println();
    }
}
