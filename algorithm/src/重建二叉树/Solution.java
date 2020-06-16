package 重建二叉树;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: _1
 * @description: 剑指offer 重建二叉树
 * @author: mooncake
 * @create: 2020-06-16 09:55
 **/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||preorder.length==0)return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,inorder.length-1,inorder,0,inorder.length-1,map);
        return root;

    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
        if (preStart>preEnd)return null;
        int rootVal=preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd){
            return root;
        }else{
            int rootIndex = map.get(rootVal);
            int leftNodes = rootIndex-inStart,rightNodes=inEnd-rootIndex;
            TreeNode leftSubtree = buildTree(preorder,preStart+1,preStart+leftNodes,inorder,inStart,rootIndex-1,map);
            TreeNode rightSubtree = buildTree(preorder,preEnd-rightNodes+1,preEnd,inorder,rootIndex+1,inEnd,map);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;

        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}