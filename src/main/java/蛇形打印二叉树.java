import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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

    public static void dfs(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() <= level) {
            List<Integer> newLevel = new ArrayList<Integer>();
            list.add(newLevel);
        }
        List<Integer> curList = list.get(level);
        if ((level & 1) == 0) {
            curList.add(node.val);
        } else {
            curList.add(0, node.val);
        }
        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }


    private static class TreeNode {

        int val; // 链表节点的值
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
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


        //前序遍历
        public static ArrayList<Integer> beforeTraverse(TreeNode treeNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (treeNode == null) {
                arrayList.add(null);
            }else if (treeNode.left == null && treeNode.right == null) {
                arrayList.add(treeNode.val);
            } else {
                arrayList.addAll(beforeTraverse(treeNode.left));
                arrayList.add(treeNode.val);
                arrayList.addAll(beforeTraverse(treeNode.right));
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
                arrayList.addAll(afterTraverse(treeNode.right));
                arrayList.add(treeNode.val);
                arrayList.addAll(afterTraverse(treeNode.left));
            }
            return arrayList;
        }


        //层序遍历
        public static ArrayList<Integer> sequenceTraverse(TreeNode root) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(root);
            arrayList.add(root.val);
            while (treeNodes.size() > 0) {
                ArrayList<TreeNode> subTreeNodes = new ArrayList<>();
                for (TreeNode value : treeNodes) {
                    if (value.left != null || value.right != null) {
                        if (value.left != null) {
                            subTreeNodes.add(value.left);
                            arrayList.add(value.left.val);
                        } else {
                            arrayList.add(null);
                        }
                        if (value.right != null) {
                            subTreeNodes.add(value.right);
                            arrayList.add(value.right.val);
                        } else {
                            arrayList.add(null);
                        }
                    }
                }
                treeNodes = subTreeNodes;
            }
            return arrayList;
        }
    }



    public static void main(String[] args) {

        int[] a = new int[] {1, 2, 3, 4, 5, 6,7};
        TreeNode node = TreeNode.mkTree(a);
        System.out.println(TreeNode.beforeTraverse(node));

        System.out.println(zigzagLevelOrder(node));
    }


}
