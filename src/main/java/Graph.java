import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 /**
 *
 * 1929年，匈牙利作家Frigyes Karinthy在短篇故事‘Chains’中首次提出的“六度人脉理论”，是指地球上所有的人都可以通过六层以内的熟人链和任何其他人联系起来。我们定义A的‘一度好友’为A直接相识的好友，A的‘二度好友’为A一度好友的好友且与A不是一度好友，A的‘三度好友’为A二度好友的好友且与A不是一度好友、二度好友，以此类推。
 *
 * 在美团点评，小美、小团、小卓、小越、小诚、小信的好友关系见下图。
 *
 * 小团、小卓、小诚是小美的一度好友。小越、小信是小美的二度好友。小诚、小越是小信的一度好友，小美、小卓是小信的二度好友，小团是小信的三度好友。
 *
 * 现在已知每个人的所有一度好友，需要为‘小点’推荐10个六度好友，请使用伪代码写出计算方法。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/2/20
 * @time: 11:32
 * @description:
 **/

/*
 * @author: heaven
 * @date: 2021/2/20
 * @time: 11:33
 * @description:
 **/
public class Graph {

    //边
    public class EdgeNode{
        int index;  //存储该顶点对应的下标
        int weight; //存储权重
    }

    ArrayList<String> pointList;    //顶点数组
    LinkedList<EdgeNode> edjList[]; //邻接表
    int pointNum;       //顶点数
    int edgeNum;        //边数


    public Graph(int n){
        pointList = new ArrayList<>(n);
        edjList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edjList[i] = new LinkedList<>();
        }
        pointNum = n;
    }

    //添加一条顶点
    public void addPoint(String name){
        if(pointList.size() >= pointNum){
            System.out.println("point array full");
            return ;
        }
        if(pointList.indexOf(name) != -1){
            System.out.println("已经存在"+name);
            return ;
        }
        pointList.add(name);
    }

    public String getName(int index){
        return pointList.get(index);
    }

    //添加一条边
    public void addEdge(String name1, String name2, int weight){

        int i = pointList.indexOf(name1);
        if(i == -1){
            System.out.println("not find nam1="+name1);
            return ;
        }
        int j = pointList.indexOf(name2);
        if(j == -1){
            System.out.println("not find name2="+name2);
            return ;
        }

        EdgeNode edge = new EdgeNode();
        edge.index = j;
        edge.weight = weight;
        edjList[i].add(edge);
        edgeNum++;

        //加入另一个边 （无向边 两边都加）
        edge = new EdgeNode();
        edge.index = i;
        edge.weight = weight;
        edjList[j].add(edge);
        edgeNum++;
    }

    public void printAll(){
        for (String s : pointList) {

        }
        for (int i=0;i<pointList.size();i++) {
            System.out.print("节点"+pointList.get(i) +"边为:");
            for (EdgeNode edgeNode : edjList[i]) {
                System.out.print(pointList.get(edgeNode.index)+" ");
            }
            System.out.println("");
        }
    }

    /**
     * 广度遍历
     * @param name
     */
    public void BSTTraverse(String name){
        LinkedList<Integer> queue = new LinkedList();

        //找到name
        int i = pointList.indexOf(name);
        if(i == -1){
            System.out.println("not find name="+name);
            return ;
        }
        int[] a = new int[pointNum];
        for (int j = 0; j < pointNum; j++) {
            a[j] = 0;
        }

        a[i] = 1;
        LinkedList<EdgeNode> list = edjList[i];
        for (EdgeNode edgeNode : list) {
            queue.addLast(edgeNode.index);
            a[edgeNode.index] = 1;
        }
        while(queue.size() != 0){
            //从queue中拿出一个节点
            i = queue.removeFirst();
            System.out.println("遍历 " + pointList.get(i));

            list = edjList[i];
            for (EdgeNode edgeNode : list) {
                if(a[edgeNode.index] != 1){
                    queue.addLast(edgeNode.index);
                    a[edgeNode.index] = 1;
                }
            }
        }
    }


    public class Node{
        int index;
        int deep;
    }

    /**
     * 根据深度获取好友队列
     * @param name
     * @param deep 获取1度好友 则深度为2
     * @return
     * 采用广度优先算法
     */
    public LinkedList<Node> getQueueByDeep(String name, int deep){
        LinkedList<Node> queue = new LinkedList();
        //找到name
        int i = pointList.indexOf(name);
        if(i == -1){
            System.out.println("not find name="+name);
            return null;
        }
        int[] a = new int[pointNum];
        for (int j = 0; j < pointNum; j++) {
            a[j] = 0;
        }
        Node node = new Node();
        node.index = i;
        node.deep = 1;
        queue.addLast(node);
        a[i] = 1;

        while(queue.size() != 0){
            //从queue中拿出一个节点
            node = queue.getFirst();
            if(node.deep == deep){
                return queue;
            }
            queue.removeFirst();
            //System.out.println("遍历 " + pointList.get(node.index).data);

            List<EdgeNode> list = edjList[node.index];
            for (EdgeNode edgeNode : list) {
                if(a[edgeNode.index] != 1){
                    Node temp = new Node();
                    temp.index = edgeNode.index;
                    temp.deep = node.deep+1;
                    queue.addLast(temp);
                    a[edgeNode.index] = 1;
                    System.out.println("deep="+temp.deep + pointList.get(edgeNode.index));
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{

        Graph g = new Graph(7);
        g.addPoint("小团");
        g.addPoint("小美");
        g.addPoint("小诚");
        g.addPoint("小信");
        g.addPoint("小卓");
        g.addPoint("小越");

        g.addPoint("小孩");

        g.addEdge("小团", "小美", 1);
        g.addEdge("小卓", "小美", 1);
        g.addEdge("小诚", "小美", 1);
        g.addEdge("小团", "小卓", 1);
        g.addEdge("小诚", "小信", 1);
        g.addEdge("小信", "小越", 1);
        g.addEdge("小卓", "小越", 1);

        g.addEdge("小信", "小孩", 1);

        g.printAll();

        g.BSTTraverse("小美");

        int deep = 4;
        LinkedList<Node> queue = g.getQueueByDeep("小美", 4);
        if(queue == null){
            System.out.println("没有"+(deep-1)+"度好友");
        }else{
            for (Node node : queue) {
                System.out.println(node.deep+"度好友为 "+ g.getName(node.index));
            }
        }
    }
}
