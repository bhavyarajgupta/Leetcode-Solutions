/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */

let first = null;
let second = null;
let temp = 0;
let prev = Number.MIN_VALUE;


function inorder(root){
    if(root == null) return;
    
    inorder(root.left);
    if(first == null && prev.val >root.val){
        first = prev;
    }
    
    if(first != null && prev.val >root.val){
        second = root;
    }
    
    prev = root;
    inorder(root.right);
    
}

var recoverTree = function(root) {
    first = null;
    second = null;
    temp = 0;
    prev = Number.MIN_VALUE;
    
    inorder(root);
    
    // console.log(first,second);
    temp = first.val;
    first.val = second.val;
    second.val = temp;
    
    // console.log(first,second,temp);
    
};