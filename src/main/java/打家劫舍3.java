import java.util.ArrayList;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/11
 * @time: 09:55
 * @description:
 **/
public class 打家劫舍3 {
    public static int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public static int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }


    private static class TreeNode {

        int val; // 链表节点的值
        public 打家劫舍3.TreeNode left;
        public 打家劫舍3.TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }


        @Override
        public String toString() {
            return Integer.toString(val);
        }

        public static 打家劫舍3.TreeNode mkTree(int[] arr) {

            打家劫舍3.TreeNode[] nodes = new 打家劫舍3.TreeNode[arr.length + 1];
            for (int i = 1; i < nodes.length; i++) {
                if (arr[i - 1] != Integer.MAX_VALUE) {
                    nodes[i] = new 打家劫舍3.TreeNode(arr[i - 1]);
                } else {
                    nodes[i] = null;
                }
            }
            打家劫舍3.TreeNode node = null;
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
        public static ArrayList<Integer> beforeTraverse(打家劫舍3.TreeNode treeNode) {
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
        public static ArrayList<Integer> afterTraverse(打家劫舍3.TreeNode treeNode) {
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
        public static ArrayList<Integer> sequenceTraverse(打家劫舍3.TreeNode root) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<打家劫舍3.TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(root);
            arrayList.add(root.val);
            while (treeNodes.size() > 0) {
                ArrayList<打家劫舍3.TreeNode> subTreeNodes = new ArrayList<>();
                for (打家劫舍3.TreeNode value : treeNodes) {
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
        打家劫舍3.TreeNode node = 打家劫舍3.TreeNode.mkTree(a);
        System.out.println(打家劫舍3.rob(node));
    }
}
