public int minCameraCover(TreeNode root) {
if(root.left == null && root.right == null) return 1;
Queue<TreeNode> q = new LinkedList<>();
ArrayList<Integer> list  = new ArrayList<>();
q.add(root);
while(!q.isEmpty()){
int size = q.size();
list.add(size);
while(size-- >0 ){
TreeNode par = q.remove();
if(par.left!=null) q.add(par.left);
if(par.right!=null) q.add(par.right);
}
}
System.out.println(list.size());
int ans1 = 0;
int ans2 = 0;
for(int i = list.size()-1;i>=0;i--){
System.out.println(i);
if(i%2 == 0){
ans1 += list.get(i);
}
else  ans2 += list.get(i);
}
return Math.min(ans1,ans2);
}