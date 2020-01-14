
public class MirrorTree {
    public static TreeNode getMirror(TreeNode root) {
        if (root != null && (root.left == null & root.right == null)) {
            return root;
        }
        if (root == null) {
            return null;
        } else {
            TreeNode result = new TreeNode(root.val);
            result.left = getMirror(root.right);
            result.right = getMirror(root.left);
            return result;
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }


   public static void Mirror(TreeNode root) {
        reverseTree(root);
    }
 
    private static void reverseTree(TreeNode root){
        //为空则结束
        if(root == null){
            return;
        }
        //假设root两边的子树自己都已经翻转成功了，那么只需要再将左右子树互换一下就成功了
        //交换root的左右子树
        swap(root);
 
        //左右子树翻转自己去处理就行了，我们规定每个子树的root都跟最终的root处理方式一样即可
        reverseTree(root.left);
        reverseTree(root.right);
    }
 
    private static void swap(TreeNode root){
        TreeNode node = null;
        node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = six;
        three.left = four;
        three.right = five;
        TreeNode mirror = getMirror(root);
        preOrder(mirror);
        // Mirror(root);
        // preOrder(root);
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