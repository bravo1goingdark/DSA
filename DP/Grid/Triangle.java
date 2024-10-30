package Grid;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> tri = new ArrayList<>();
        
        tri.add(new ArrayList<>()); 
        tri.get(0).add(2);
        
        tri.add(new ArrayList<>()); 
        tri.get(1).add(3);
        tri.get(1).add(4);
        
        tri.add(new ArrayList<>()); 
        tri.get(2).add(6);
        tri.get(2).add(5);
        tri.get(2).add(7);
        
        tri.add(new ArrayList<>()); 
        tri.get(3).add(4);
        tri.get(3).add(1);
        tri.get(3).add(8);
        tri.get(3).add(3);

        System.out.println(minimumTotal(tri));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() - 1][triangle.size() - 1];
        for (int[] is : dp) {
            Arrays.fill(is,-1);
        }
        // return mintotal(0, 0, triangle);
        // return mintotalMemo(0, 0, triangle , dp);
        // return mintotalTabu(0,0,triangle);
        return mintotalSpaceOpt(triangle);
    }

    private static int mintotal(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }


        int down = mintotal(row + 1, col, triangle); 
        int diagonal = mintotal(row + 1, col + 1, triangle); 

        return Math.min(down, diagonal) + triangle.get(row).get(col);
    }

    private static int mintotalMemo(int row, int col, List<List<Integer>> triangle , int[][] dp) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }


        int down = mintotalMemo(row + 1, col, triangle,dp); 
        int diagonal = mintotalMemo(row + 1, col + 1, triangle,dp); 

        return dp[row][col] = Math.min(down, diagonal) + triangle.get(row).get(col);
    }

    private static int mintotalTabu(int row, int col, List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
           
        }
 
        return dp[0][0];
    }

    private static int mintotalSpaceOpt(List<List<Integer>> triangle) {
        int[] front = new int[triangle.size()];
        int[] curr = new int[triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            front[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j+1];
                curr[j] = Math.min(down, diagonal);
            }
           front = curr;
        }
 
        return front[0];
    }
}
