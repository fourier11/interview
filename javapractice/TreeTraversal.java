import java.util.*;

public class TreeTraversal {

    /**
     * 按层次遍历（广度优先遍历）
     * 
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        cur.offer(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!cur.isEmpty()) {
            TreeNode pNode = cur.poll();
            list.add(pNode.val);
            if (pNode.left != null)
                next.offer(pNode.left);
            if (pNode.right != null)
                next.offer(pNode.right);
            if (cur.isEmpty()) {
                Queue<TreeNode> tmp = cur;
                cur = next;
                next = tmp;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }

    /**
     * 之字形遍历
     * 
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> cur = new Stack<>();
        Stack<TreeNode> rev = new Stack<>();
        cur.push(pRoot);
        int flag = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!cur.isEmpty()) {
            TreeNode pNode = cur.pop();
            list.add(pNode.val);
            if (flag == 0) {
                if (pNode.left != null)
                    rev.push(pNode.left);
                if (pNode.right != null)
                    rev.push(pNode.right);
            } else if (flag != 0) {
                if (pNode.right != null)
                    rev.push(pNode.right);
                if (pNode.left != null)
                    rev.push(pNode.left);
            }
            if (cur.isEmpty()) {
                Stack<TreeNode> tmp = cur;
                cur = rev;
                rev = tmp;
                flag = 1 - flag;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        System.out.println(Print(root));
        System.out.println(Print2(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}