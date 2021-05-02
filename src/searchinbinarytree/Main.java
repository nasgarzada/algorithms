package searchinbinarytree;

public class Main {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        addRight(
                addLeft(node, 2),
                3
        );
        addLeft(node, 1);

        var result = searchBST(node, 2);

        printTree(result);
    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return root;
        if (root.val > val)
            return searchBST(root.left, val);
        else if (root.val < val)
            return searchBST(root.right, val);
        else
            return root;
    }

    private static TreeNode addLeft(TreeNode head, int val) {
        if (head == null)
            return null;

        if (head.left == null) {
            head.left = new TreeNode(val);
            return head.left;
        }
        return addLeft(head.left, val);
    }

    private static TreeNode addRight(TreeNode head, int val) {
        if (head == null)
            return null;

        if (head.right == null) {
            head.right = new TreeNode(val);
            return head.right;
        }
        return addRight(head.right, val);
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val);
        System.out.print(" -> ");

        printTree(root.right);
        printTree(root.left);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
