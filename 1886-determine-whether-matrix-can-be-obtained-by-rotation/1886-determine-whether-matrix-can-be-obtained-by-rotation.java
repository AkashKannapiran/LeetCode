class Solution {
    public void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public void rotate(int[][] mat) {
        int n = mat.length;
        
        for (int i2 = 0; i2 < n - 1; i2++) {
            for (int j = i2 + 1; j < n; j++) {
                swap(mat, i2, j);
            }
        }
        
        for (int i1 = 0; i1 < n; i1++) {
            reverse(mat[i1]);
        }
    }

    public boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isEqual(mat, target)) {
                    return true;
                }

                rotate(mat);
            }
        }
        
        return false;
    }
}