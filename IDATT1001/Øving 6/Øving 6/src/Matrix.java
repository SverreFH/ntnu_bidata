
final class Matrix {
    
    private int[][] mat;
    

    public Matrix(int[][] matrix){
        mat = matrix.clone();
    }

    public int[][] add(Matrix m2){
        int[][] resultMatrix = new int[mat.length][mat[0].length];
        
        if(mat.length != m2.getHeight() || mat[0].length != m2.getWidth()){
            int[][] zero = {{0}};
            return zero;
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                resultMatrix[i][j] = this.mat[i][j] + m2.getMat()[i][j]; 
            }
        }
        return resultMatrix;
    }

    public int[][] mult(Matrix m2){
        int[][] resultMatrix = new int[mat[0].length][m2.getHeight()];

        if(mat[0].length != m2.getHeight()){
            int[][] zero = {{0}};
            return zero;
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                resultMatrix[i][j] = 0;
                for(int k = 0; k < mat.length; k++){
                    resultMatrix[i][j] += mat[i][k] * m2.getMat()[k][j];
                }
            }
        }
        return resultMatrix;
    }

    public int[][] trans(){
        int[][] resultMatrix = new int[mat[0].length][mat.length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                resultMatrix[j][i] = mat[i][j];
            }
        }
        return resultMatrix;
    }

    public int getHeight(){
        return mat.length;
    }
    
    public int getWidth(){
        return mat[0].length;
    }

    public int[][] getMat(){
        return mat;
    }
}
