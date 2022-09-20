};
*/
​
class Solution {
public Node connect(Node root) {
Queue<Node> q  = new LinkedList<>();
Node ans = new Node(-1);
Node tail = ans;
q.add(root);
Node temp = new Node(-1);
temp.right = null;
while(!q.isEmpty()){
int size = q.size();
for(int i =0;i<size;i++){
Node par = q.remove();
tail.right = new Node(par.val);
tail = tail.next;
if(par.left != null){
q.add(par.left);
}
if(par.right != null){
q.add(par.right);
}
}
// tail.next = temp.right;
// tail = tail.next;
}
return ans.next;
}
}