import java.util.Arrays;

public class BSin2D{
    public static void main(String[] args) {
        int[][] matrix = {{10 , 20 , 30 ,40}, {15, 25 ,35 , 45}, {28, 29 , 37 , 49}, {33, 34, 38, 50} };
        System.out.println(matrix.length - 1);
        System.out.println(Arrays.toString(BinarySin2D(matrix, 37)));
    }
    static int[] BinarySin2D(int[][] matrix , int target){ // if the matrix is both row and col wise sorted
        int r = 0;
        int c = matrix.length - 1;
        while(r < matrix.length && c>=0){
            if(matrix[r][c] == target){
                return new int[]{r , c};
            }
            if(matrix[r][c] < target){
                r++;
            }if(matrix[r][c] > target){
                c--;
            }
        } 
        return new int[]{-1,-1};
    }
}
