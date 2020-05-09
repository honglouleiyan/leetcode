package util;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/8
 * @time: 17:28
 * @description:
 **/
public class Node {
    public String data;//结点值
    public Node next;//下一个元素
    public Node(String data){
        this.data = data;
    }
    public void show(){
        System.out.print(data + " ");
    }
}
