/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OSTEEN
 */
class Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            // If both are null, continue
            if (left == null && right == null) continue;
            
            // If one is null and the other is not, return false
            if (left == null || right == null) return false;
            
            // If values don't match, return false
            if (left.val != right.val) return false;
            
            // Add children in mirror order
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        
        return true;
    }
}
