//Brute Force
public void rotate(int[][] matrix) {
int mat[][] = new int[matrix.length][matrix.length];
for(int i=0;i<matrix.length;i++){
for(int j=0;j<matrix.length;j++){
mat[j][matrix.length-1-i] = matrix[i][j];
}
}
for(int i=0;i<matrix.length;i++){
for(int j=0;j<matrix.length;j++){
matrix[i][j] = mat[i][j];
}
}
}
copy 1 array to another