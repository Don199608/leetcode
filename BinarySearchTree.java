package zzy.leecode;
// 二叉查找树
public class BinarySearchTree {
    private TreeNode tree;

    public TreeNode find(int data){
        TreeNode p = tree;
        while (p!=null){
            if (data<p.data)
                p = p.left;
            else if (data>p.data)
                p = p.right;
            else return p;
        }
        return null;
    }

    public void insert(int data){
        if (tree == null)
            tree = new TreeNode(data);
        TreeNode p = tree;
        while (p!=null){
            if (data>p.data){
                if (p.right==null){
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            }else {
                if (p.left == null){
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    // 有点复杂，理解思路即可
    public void deleta(int data){

    }
}


















