import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/27
 * @time: 20:35
 * @description:
 **/
public class 蛇形打印二叉树 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int level = 0;
        dfs(root, result, level);
        return result;
    }

    public static void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> newLevel = new ArrayList<Integer>();
            result.add(newLevel);
        }
        List<Integer> curList = result.get(level);
        if ((level & 1) == 0) {
            curList.add(node.val);
        } else {
            curList.add(0, node.val);
        }
        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1);
    }


    private static class TreeNode {

        int val; // 链表节点的值
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

       public TreeNode(int val,TreeNode left,TreeNode right){// 有参构造函数进行成员赋值
            this.left = left;
            this.right = right;
            this.val = val;
        }


        @Override
        public String toString() {
            return Integer.toString(val);
        }

        public static TreeNode mkTree(int[] arr) {

            TreeNode[] nodes = new TreeNode[arr.length + 1];
            for (int i = 1; i < nodes.length; i++) {
                if (arr[i - 1] != Integer.MAX_VALUE) {
                    nodes[i] = new TreeNode(arr[i - 1]);
                } else {
                    nodes[i] = null;
                }
            }
            TreeNode node = null;
            for (int i = 1; i < nodes.length / 2; i++) {
                node = nodes[i];
                if (node == null) {
                    continue;
                }
                node.left = nodes[2 * i];
                node.right = nodes[2 * i + 1];
            }
            return nodes[1];
        }

        public static TreeNode create() {


            TreeNode a8 = new TreeNode(8,null,null);
            TreeNode a9 = new TreeNode(9,null,null);
            TreeNode a10 = new TreeNode(10,null,null);
            TreeNode a11 = new TreeNode(11,null,null);
            TreeNode a12 = new TreeNode(12,null,null);
            TreeNode a13 = new TreeNode(13,null,null);
            TreeNode a14= new TreeNode(14,null,null);
            TreeNode a15 = new TreeNode(15,null,null);

            TreeNode a4 = new TreeNode(4,a8,a9);
            TreeNode a5 = new TreeNode(5,a10,a11);
            TreeNode a6 = new TreeNode(6,a12,a13);
            TreeNode a7 = new TreeNode(7,a14,a15);

            TreeNode a2 = new TreeNode(2,a4,a5);
            TreeNode a3 = new TreeNode(3,a6,a7);

            TreeNode a1 = new TreeNode(1,a2,a3);




            return a1;
        }


        //谦虚遍历
        public static ArrayList<Integer> beforeTraverse(TreeNode treeNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (treeNode == null) {
                arrayList.add(null);
            }else if (treeNode.left == null && treeNode.right == null) {
                arrayList.add(treeNode.val);
            } else {
                arrayList.add(treeNode.val);
                arrayList.addAll(beforeTraverse(treeNode.left));
                arrayList.addAll(beforeTraverse(treeNode.right));
            }
            return arrayList;
        }

        //中序遍历
        public static ArrayList<Integer> middleTraverse(TreeNode treeNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (treeNode == null) {
                arrayList.add(null);
            }else if (treeNode.left == null && treeNode.right == null) {
                arrayList.add(treeNode.val);
            } else {
                arrayList.addAll(middleTraverse(treeNode.left));
                arrayList.add(treeNode.val);
                arrayList.addAll(middleTraverse(treeNode.right));
            }
            return arrayList;
        }

        //后序遍历
        public static ArrayList<Integer> afterTraverse(TreeNode treeNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (treeNode == null) {
                arrayList.add(null);
            }else if (treeNode.left == null && treeNode.right == null) {
                arrayList.add(treeNode.val);
            } else {
                arrayList.addAll(afterTraverse(treeNode.left));
                arrayList.addAll(afterTraverse(treeNode.right));
                arrayList.add(treeNode.val);
            }
            return arrayList;
        }


        //层序遍历
        public static ArrayList<Integer> sequenceTraverse(TreeNode root) {
            //保存元素
            ArrayList<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            TreeNode current = null;
            queue.offer(root);
            while (!queue.isEmpty()) {
                current = queue.poll();
                list.add(current.val);

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            return list;
        }



        //蛇形遍历
        public static ArrayList<Integer> sheTraverse(TreeNode root) {
            //保存元素
            ArrayList<Integer> list = new ArrayList<>();

            Stack<TreeNode> left = new Stack<>();
            Stack<TreeNode> right = new Stack<>();
            left.push(root);
            while (left.isEmpty() || right.isEmpty()) {
                if (left.isEmpty() && right.isEmpty()) {
                    break;
                }
                if (right.isEmpty()) {
                    while (!left.isEmpty()) {
                        TreeNode current = left.pop();
                        list.add(current.val);
                        if (current.left != null) {
                            right.push(current.left);
                        }
                        if (current.right != null) {
                            right.push(current.right);
                        }
                    }
                }
                if(left.isEmpty()) {
                    while (!right.isEmpty()) {
                        TreeNode current = right.pop();
                        list.add(current.val);
                        if (current.right != null) {
                            left.push(current.right);
                        }
                        if (current.left != null) {
                            left.push(current.left);
                        }
                    }

                }

            }
            return list;
        }
    }



    public static void main(String[] args) {

//        int[] a = new int[] {1, 2, 3, 4, 5, 6,7,8,9,10,11,12,13,14,15};
//        TreeNode node = TreeNode.mkTree(a);
        TreeNode node = TreeNode.create();
        System.out.println(TreeNode.beforeTraverse(node));
        System.out.println(TreeNode.middleTraverse(node));
        System.out.println(TreeNode.afterTraverse(node));
        System.out.println(TreeNode.sequenceTraverse(node));
        System.out.println(zigzagLevelOrder(node));
        System.out.println(TreeNode.sheTraverse(node));
    }


}
