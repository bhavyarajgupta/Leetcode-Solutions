}
Queue<Node> q  = new LinkedList<>();
q.add(root);
Node temp = new Node(-1);
temp.right = null;
while(!q.isEmpty()){
int size = q.size();
Node dummy = new Node(-1);
for(int i =0;i<size;i++){
Node par = q.remove();
dummy.next = par;
dummy = dummy.next;
if(par.left != null){
q.add(par.left);
}
if(par.right != null){
q.add(par.right);
}
}
}
return root;
}
}