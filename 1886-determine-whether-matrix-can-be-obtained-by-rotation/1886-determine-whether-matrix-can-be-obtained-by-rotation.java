class Solution {
    public void reverse(int[][] mat, int n ,int row) {
        for (int i = 0; i < n/2; i++) {
            // swap
            int temp = mat[row][i];
            mat[row][i] = mat[row][n-1-i];
            mat[row][n-1-i] = temp;
        }
    }

    // public void display(int[][] mat) {
    //     int n = mat.length;
    //     for(int i =0;i<n ;i++){
    //         for(int j =0;j<n ;j++){
    //             System.out.print(mat[i][j]+" ");
    //         }
    //             System.out.println();
    //     }
    //             System.out.println();
    //             System.out.println();

    // }

    public void rotate90deg(int[][] mat) {
        int n = mat.length;

        //transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //reverse
        for (int i = 0; i < n; i++) {
            reverse(mat, n,i);
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if (Arrays.deepEquals(mat,target))
            return true;
        
        for (int i = 1; i <= 3; i++) {
            rotate90deg(mat);
            // display(mat);
            if (Arrays.deepEquals(mat,target)){
                return true;
            }
        }
        return false;
    }
}