/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list= new ArrayList();
        traverseTree(root,list,k);
        
        return list.get(k-1);
        
    }
    public static void traverseTree(TreeNode root,List<Integer> list, int k){
        if(list.size()>=k){
            return;
        }
        if(root==null){
            return ;
        }
        traverseTree(root.left,list,k);
        list.add(root.val);
        traverseTree(root.right,list,k);
    }
}
